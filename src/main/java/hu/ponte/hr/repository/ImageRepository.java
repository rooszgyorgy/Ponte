package hu.ponte.hr.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import hu.ponte.hr.entity.ImageE;

@Repository
public interface ImageRepository extends CrudRepository< ImageE, String>{
	

}
