package jussics.realestate.service;

import jussics.realestate.exception.UserNotFoundException;
import jussics.realestate.model.Property;
import jussics.realestate.repo.PropertyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyService {
    private final PropertyRepo propertyRepo;

    @Autowired
    public PropertyService(PropertyRepo propertyRepo) {
        this.propertyRepo = propertyRepo;
    }
    public Property addProperty(Property property){
         return propertyRepo.save(property);
    }
    public List<Property> findAllProperties(){
        return propertyRepo.findAll();
    }
    public Property updateProperty(Property property){
        Property prop = propertyRepo.findById(property.getId()).orElseThrow();
        prop.setAddress(property.getAddress());
        prop.setDescription(property.getDescription());
        prop.setDistrict(property.getDistrict());
        prop.setNumber(property.getNumber());
        prop.setPostalCode(property.getPostalCode());
        return propertyRepo.save(prop);
    }
    public Property findPropertyById(Long id){
        return propertyRepo.findPropertyById(id)
                .orElseThrow(()-> new UserNotFoundException("Property by id" + id + "is not found"));
    }
    public void deleteProperty(Long id){
        propertyRepo.deletePropertyById(id);
    }

}
