package SocialMedia.contrroller;

import SocialMedia.entity.Post;
import SocialMedia.service.PostService;
import SocialMedia.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Posts")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }
    @GetMapping("/{id}")
    public Post getPostsByUserId(@PathVariable Long userId){
        return  postService.getPostByUserId(userId);
    }
    @GetMapping
    public List<Post>getAllPosts(){
        return postService.getAllPosts();
    }
    @PostMapping
    public Post createPost(@RequestBody Post post){
        return postService.createdPost(post);
    }
    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id){
        postService.deletePost(id);
    }

}
