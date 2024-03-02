package SocialMedia.service;

import SocialMedia.entity.User;
import SocialMedia.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
   private UserRepository userRepository;

   public UserService(UserRepository userRepository) {
       this.userRepository = userRepository;
   }
   public List<User> getAllUsers() {
       return userRepository.findAll();
   }
   public User createdUser(User user) {
       return userRepository.save(user);
   }
}