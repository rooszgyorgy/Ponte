package hu.ponte.hr.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.ponte.hr.entity.ImageE;
import hu.ponte.hr.repository.ImageRepository;

@Service
public class ImageStore {
    private ImageRepository repository;

    @Autowired
    public void setImageRepo( ImageRepository imageRepo ) {
    	this.repository = imageRepo;
    }
    public List<ImageE> findAll() {

        return (List<ImageE>) repository.findAll();
    }
    
    public Optional<ImageE> findById( String id ) {
	      
    	Optional<ImageE> imageE = repository.findById(id);
    	
    	return imageE;
	          	
    }
    
    public void saveImage( String id, String name, String mimeType, long size, String digitalSign  ) {
    	ImageE imageE = new ImageE(  id,  name,  mimeType,  size,  digitalSign);
    	repository.save( imageE );
    	
    }
}
