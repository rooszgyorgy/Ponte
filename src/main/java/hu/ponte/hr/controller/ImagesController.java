package hu.ponte.hr.controller;


import hu.ponte.hr.entity.ImageE;
import hu.ponte.hr.services.ImageStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("api/images")
public class ImagesController {

	private ImageStore imageStore;

	@Autowired
	public void setImageStore( ImageStore imageStore) {
		this.imageStore = imageStore;
	}

    @GetMapping("meta")
    public List<ImageE> listImages( Model model ) {
    	
        List<ImageE> imageList = (List<ImageE>) imageStore.findAll();
      
		return imageList;
    }

    @GetMapping("preview/{id}")
    public void getImage(@PathVariable("id") String id, HttpServletResponse response) {
    	
    	Optional<ImageE> imageE = imageStore.findById(id);
	}

}

