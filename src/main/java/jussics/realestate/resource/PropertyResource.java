package jussics.realestate.resource;

import jussics.realestate.model.Property;
import jussics.realestate.service.PropertyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//this is the rest service
@RequestMapping("/property")
public class PropertyResource {
    private final PropertyService propertyService;

    public PropertyResource(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Property>> getAllProperties(){
        List<Property> properties = propertyService.findAllProperties();
        return new ResponseEntity<>(properties, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Property> getPropertyById(@PathVariable("id") Long id){
         Property property = propertyService.findPropertyById(id);
        return new ResponseEntity<>(property, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Property> addProperty(@RequestBody Property property) {
        Property newProperty = propertyService.addProperty(property);
        return new ResponseEntity<>(newProperty, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Property> updateProperty(@RequestBody Property property) {
        Property updateProperty = propertyService.updateProperty(property);
        return new ResponseEntity<>(updateProperty, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProperty(@PathVariable("id") Long id) {
        propertyService.deleteProperty(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
