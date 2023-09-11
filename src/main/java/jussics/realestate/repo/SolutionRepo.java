package jussics.realestate.repo;


import jussics.realestate.model.Solution;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SolutionRepo extends JpaRepository<Solution, Long> {
    Optional<Solution> findSolutionById(Long id);
    //query method
    void deleteSolutionById(Long id);

}
