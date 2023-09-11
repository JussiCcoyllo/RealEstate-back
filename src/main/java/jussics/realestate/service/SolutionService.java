package jussics.realestate.service;

import jussics.realestate.exception.UserNotFoundException;
import jussics.realestate.model.Solution;
import jussics.realestate.repo.SolutionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SolutionService {
    private final SolutionRepo solutionRepo;

    @Autowired
    public SolutionService(SolutionRepo solutionRepo) {
        this.solutionRepo = solutionRepo;
    }
    public Solution addSolution(Solution solution){
        return solutionRepo.save(solution);
    }
    public List<Solution> findAllSolutions(){
        return solutionRepo.findAll();
    }
    public Solution updateSolution(Solution solution){
        Solution sol = solutionRepo.findById(solution.getId()).orElseThrow();
        sol.setStatus(solution.getStatus());
        sol.setDescriptionSolution(solution.getDescriptionSolution());
        return solutionRepo.save(sol);
    }
    public Solution findSolutionById(Long id){
        return solutionRepo.findSolutionById(id)
                .orElseThrow(()-> new UserNotFoundException("Solution by id" + id + "is not found"));
    }
    public void deleteSolution(Long id){
        solutionRepo.deleteSolutionById(id);
    }

}
