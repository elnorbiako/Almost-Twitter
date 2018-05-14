package pl.workshop5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.workshop5.entity.Comment;
import pl.workshop5.entity.Tweet;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findAllByTweetOrderByCreatedDesc(Tweet tweet);
    List<Comment> findAllByTweetIdOrderByCreatedDesc(Long tweetId);


}
