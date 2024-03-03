package SocialMedia.repository;

import SocialMedia.entity.Post;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {
    public List<Post>findByUserId(Long userId);

    Post getByuserId(Long id);

    //public Post getByuserId(Long userId);
}
