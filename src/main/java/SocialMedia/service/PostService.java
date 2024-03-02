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
    public List<Post>getPostByUserId(Long userId){
        return postRepository.findByUserId(userId);
    }
    public Post createdPost(Post post){
        return postRepository.save(post);
    }
}
