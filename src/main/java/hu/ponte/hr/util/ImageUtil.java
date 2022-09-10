package hu.ponte.hr.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

import org.apache.tomcat.util.codec.binary.Base64;

public class ImageUtil {

	/*
	 * Generál egy file id-t (0..9,a..z) stringLength hosszan 
	 */
	public static String GenerateID( int stringLength ) {
		
	    int leftLimit = 48; // 0
	    int rightLimit = 122; // z
	    int targetStringLength = stringLength; // generált String hossza 
	    Random random = new Random();

	    String generatedString = random.ints(leftLimit, rightLimit + 1)
	      .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
	      .limit(targetStringLength)
	      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
	      .toString();
		
		return generatedString;
	}
	
	/*
	 * base64 formátumba kódol egy file-t.
	 */
	
	public static String encodeFileToBase64Binary(byte[] fileContent) throws IOException {

  System.out.println( fileContent);
		
	    byte[] bytes = fileContent;
    
	    String encodedString = Base64.encodeBase64String(bytes);

	    return encodedString;
	}
	
	private static byte[] loadFile(File file) throws IOException {
	    InputStream is = new FileInputStream(file);

	    long length = file.length();
	    if (length > Integer.MAX_VALUE) {
	        // A file túl nagy.
	    }
	    byte[] bytes = new byte[(int)length];

	    int offset = 0;
	    int numRead = 0;
	    while (offset < bytes.length
	           && (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) {
	        offset += numRead;
	    }

	    if (offset < bytes.length) {
	        throw new IOException("Nem olvasható a file "+file.getName());
	    }

	    is.close();
	    return bytes;
	}
	
}