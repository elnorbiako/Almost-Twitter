package pl.workshop5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.workshop5.entity.Comment;
import pl.workshop5.entity.Tweet;
import pl.workshop5.entity.User;
import pl.workshop5.repository.CommentRepository;
import pl.workshop5.repository.TweetRepository;
import pl.workshop5.repository.UserRepository;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class TweetController {

    @Autowired
    TweetRepository tweetRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CommentRepository commentRepository;


    @GetMapping("/tweet/{id}")
    public String tweetDetails(@PathVariable ("id") Long id,  Model model, HttpSession session) {

        Long loggedUserId = (Long) session.getAttribute("loggedUserId");
        if (loggedUserId == null) {
            return "redirect:/login";
        }

        Tweet tweet = tweetRepository.findOne(id);
        List<Comment> comments = commentRepository.findAllByTweetIdOrderByCreatedDesc(tweet.getId() );
        User user = tweet.getUser();
        Comment comment = new Comment();
        model.addAttribute(tweet);
        model.addAttribute(user);
        model.addAttribute(comments);
        model.addAttribute(comment);

        return "TweetDetails";

    }

    @PostMapping("/tweet/{id}")
    public String tweetDetails(@Valid @ModelAttribute Comment comment, BindingResult result) {
        if (result.hasErrors()) {
            return "TweetDetails";
        }
        comment.setCreated(LocalDateTime.now());
        commentRepository.save(comment);
        return "redirect:/home";
    }
//
//    @GetMapping("/tweetTest")
//    @ResponseBody
//    public String tweetTest() {
//        Long id = (long) 8;
//        Tweet tweet = tweetRepository.findFirstById(id);
//        System.out.println(tweet.getTitle());
//        return tweet.getTitle();
//    }

}
