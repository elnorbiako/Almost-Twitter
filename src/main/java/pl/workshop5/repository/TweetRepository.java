package pl.workshop5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.workshop5.entity.Tweet;
import pl.workshop5.entity.User;

import java.util.List;


public interface TweetRepository extends JpaRepository<Tweet, Long> {

    List<Tweet> findAllByUserId(Long userId);
    List<Tweet> findTop10ByUserIdOrderByCreatedDesc(Long userId);
    List<Tweet> findAllByUser(User user);

    List<Tweet> findAllByOrderByCreatedDesc();



    @Query("select t from Tweet t where t.tweetText like :textPart order by t.created desc")
    List<Tweet> findByTextPart(@Param("textPart") String textPart);


}
