package hu.ponte.hr.controller.upload;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import hu.ponte.hr.services.ImageStore;
import hu.ponte.hr.util.ImageUtil;

@Component
@RequestMapping("api/file")
public class UploadController
{

	private ImageStore imageStore;
	
	@Autowired
	public void setImageStore( ImageStore imageStore) {
		this.imageStore = imageStore;
	}	
	
    @RequestMapping(value = "post", method = RequestMethod.POST)
    @ResponseBody
    public String handleFormUpload(@RequestParam("file") MultipartFile file) throws IOException {
    	
    	byte[] fileContent = file.getBytes(); //nem mindig a valós file tartalmat kapom. 
    	
//    	InputStream fis = file.getInputStream(); 
//    	byte[] fileContent = IOUtils.toByteArray(fis); Így sem! Ennek mélyebben utána kell nézni.
    	
		String id = ImageUtil.GenerateID( 10 );
		String fileName = file.getOriginalFilename();
		String mimeType = file.getContentType();
		long size = file.getSize();
    	String digitalSign = ImageUtil.encodeFileToBase64Binary(fileContent); //ez nem tartalmazza még a digitális aláírást
    	
		imageStore.saveImage( id, fileName, mimeType, size, digitalSign ); // tároljuk el a file-t. Később bármit lehet vele csinálni.
		
        return "ok";
    }
}
