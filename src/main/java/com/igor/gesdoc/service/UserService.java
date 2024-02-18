package com.igor.gesdoc.service;

import com.igor.gesdoc.entity.Activity;
import com.igor.gesdoc.entity.User;
import com.igor.gesdoc.repository.ActivityRepository;
import com.igor.gesdoc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final ActivityRepository activityRepository;

    @Autowired
    public UserService(UserRepository userRepository, ActivityRepository activityRepository) {
        this.userRepository = userRepository;
        this.activityRepository = activityRepository;
    }

    public List<User> getAllUsers() {

        return userRepository.findAll();
    }

    public User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Utilisateur non enregistré !"));
            }

    public User createUser(User user, Long activityId) {
        Activity activity = activityRepository.findById(activityId)
                .orElseThrow(() -> new RuntimeException("Service non enregistré !"));
        activity.addUser(user);
        return userRepository.save(user);

    }
    public User updateUser(Long userId, User user) {
        User updateUser = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Utilisateur non enregistré !"));
        updateUser.setMatricule(user.getMatricule());
        updateUser.setFirstname(user.getFirstname());
        updateUser.setLastname(user.getLastname());
        updateUser.setEmail(user.getEmail());
        updateUser.setRoleEnum(user.getRoleEnum());

        return userRepository.save(updateUser);
    }
    public String deleteUserById(Long userId) {
        userRepository.findById(userId)
                        .orElseThrow(() -> new RuntimeException("Utilisateur non enregistré !"));
        userRepository.deleteById(userId);
        return "L'utilisateur ID : "+userId+" a été supprimé !";
    }
}


