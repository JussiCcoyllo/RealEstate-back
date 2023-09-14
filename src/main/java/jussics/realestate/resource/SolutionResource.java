package jussics.realestate.resource;


import jakarta.transaction.Transactional;
import jussics.realestate.model.Solution;
import jussics.realestate.service.SolutionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Transactional
//this is the rest service
@RequestMapping("/solution")
public class SolutionResource {
    private final SolutionService solutionService;

    public SolutionResource(SolutionService solutionService) {
        this.solutionService = solutionService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Solution>> getAllSolutions(){
        List<Solution> solutions = solutionService.findAllSolutions();
        return new ResponseEntity<>(solutions, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Solution> getSolutionById(@PathVariable("id") Long id){
        Solution solution = solutionService.findSolutionById(id);
        return new ResponseEntity<>(solution, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Solution> addSolution(@RequestBody Solution solution) {
        Solution newSolution = solutionService.addSolution(solution);
        return new ResponseEntity<>(newSolution, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Solution> updateSolution(@RequestBody Solution solution) {
        Solution updateSolution = solutionService.updateSolution(solution);
        return new ResponseEntity<>(updateSolution, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSolution(@PathVariable("id") Long id) {
        solutionService.deleteSolution(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
