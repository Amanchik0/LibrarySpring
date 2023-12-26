package io.back.libraryJava.services;

import io.back.libraryJava.dto.UserDTO;
import io.back.libraryJava.model.User;
import io.back.libraryJava.model.Role;
import io.back.libraryJava.exceptions.UserExistException;
import io.back.libraryJava.payload.request.SignupRequest;
import io.back.libraryJava.repo.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
public class UserService {

    public static final Logger LOG = LoggerFactory.getLogger(UserService.class);

    private final UserRepo userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepo userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User createUser(SignupRequest userIn) {
        User user = new User();
        user.setEmail(userIn.getEmail());
        user.setName(userIn.getName());
        user.setPassword(passwordEncoder.encode(userIn.getPassword()));
        user.getRoles().add(Role.ROLE_USER);
        try{
            LOG.info("Saving User {}", userIn.getEmail());
            return userRepository.save(user);
        } catch (Exception e) {
            LOG.error("Error during registration. {}", e.getMessage());
            throw new UserExistException("The user " + user.getName() + " already exist. Please check credentials");
        }
    }

    public User updateUser(UserDTO userDTO, Principal principal) {
        User user = getUserByPrincipal(principal);
        user.setName(userDTO.getFirstname());
        return userRepository.save(user);
    }

    public User getCurrentUser(Principal principal) {
        return getUserByPrincipal(principal);
    }

    private User getUserByPrincipal(Principal principal) {
        String name = principal.getName();
        return userRepository.findByName(name)
                .orElseThrow(() -> new UsernameNotFoundException("Username not found with username " + name));
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(()-> new UsernameNotFoundException("User not found"));
    }

}
