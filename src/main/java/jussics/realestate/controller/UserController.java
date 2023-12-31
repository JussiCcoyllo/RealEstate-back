package jussics.realestate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jussics.realestate.model.User;
import jussics.realestate.repo.UserRepo;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    @Autowired
    private UserRepo repo;

    @PostMapping("/user")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        System.out.println("Controller called");
        return ResponseEntity.ok(repo.save(user));
    }

    @GetMapping("/suppliers")
    public List<String> getAllSuppliers(){
        return repo
                .findAllByRole("supplier")
                .stream().map(User::getFullname)
                .collect(Collectors.toList());
    }
}

