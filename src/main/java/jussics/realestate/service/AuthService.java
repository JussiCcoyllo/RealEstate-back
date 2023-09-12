package jussics.realestate.service;

import jussics.realestate.model.User;
import jussics.realestate.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Base64;

@Service
public class AuthService {

    @Autowired
    private UserRepo userRepo;

    private static final SecureRandom secureRandom = new SecureRandom();
    private static final Base64.Encoder base64encoder = Base64.getUrlEncoder();


    public User register(User user) {
        // Check if user with username exist ir not
        if(checkUserExist(user)== true)
            return null;

        user.setToken(generateToken());

        return userRepo.save(user);

    }

    private String generateToken() {

        byte[] token = new byte[24];
        secureRandom.nextBytes(token);
        return base64encoder.encodeToString(token);

    }

    private boolean checkUserExist(User user) {
	if(user.getId() == null) return false;
        User existingUser = userRepo.findById(user.getId()).orElse(null);

        if(existingUser == null)
            return false;
        return true;
    }

    public User login(User user) {
        User existingUser = userRepo.findByUsername(user.getUsername()).orElse(null);

        if(existingUser.getPassword().equals(user.getPassword())) {
            existingUser.setPassword("");
            return existingUser;
        }

        throw new RuntimeException("user pwd or name wrong");
    }
}
