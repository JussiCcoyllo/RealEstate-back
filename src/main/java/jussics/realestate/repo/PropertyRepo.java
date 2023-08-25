package jussics.realestate.repo;

import jussics.realestate.model.Property;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PropertyRepo extends JpaRepository<Property, Long> {
   Optional<Property> findPropertyById(Long id);
   //query method
   void deletePropertyById(Long id);

}
