package SocialMedia.contrroller;

import SocialMedia.entity.User;
import SocialMedia.repository.UserRepository;
import SocialMedia.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Users")
public class UserController {
    private final UserService userService;
    private final UserRepository userRepository;
    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }
    @GetMapping("/{id}")
    public User getByUserId(@PathVariable Long userId){
        return userService.getUser(userId);
    }
    @GetMapping("/users")
    public List<User>getAllUser(){
        return userService.getAllUsers();
    }

    @PostMapping
    public ResponseEntity<User>createUser(@RequestBody User user) {
        User createUser = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User>deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User userDetails){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found" + id));
        user.setName(userDetails.getName());
        return userRepository.save(user);
    }


}
