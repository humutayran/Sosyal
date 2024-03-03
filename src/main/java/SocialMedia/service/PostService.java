package SocialMedia.service;

import SocialMedia.entity.Post;
import SocialMedia.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private PostRepository  postRepository;

    public PostService(PostRepository postRepository){
        this.postRepository=postRepository;
    }
    public Post getPostByUserId(Long id){
      return postRepository.getByuserId(id);
    }
    public List<Post>getAllPosts(){
        return postRepository.findAll();
    }
    public Post createdPost(Post post){
        return postRepository.save(post);
    }
    public void deletePost(Long id){
         postRepository.deleteById(id);
    }
}
