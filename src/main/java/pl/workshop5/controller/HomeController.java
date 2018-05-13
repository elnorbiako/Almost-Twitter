package pl.workshop5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.workshop5.entity.Tweet;
import pl.workshop5.entity.User;
import pl.workshop5.repository.TweetRepository;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    TweetRepository tweetRepository;

    @GetMapping("/home")
    public String home (Model model, HttpSession session){

        Long loggedUserId = (Long) session.getAttribute("loggedUserId");
        if (loggedUserId == null) {
            return "redirect:/login";
        }

        List<Tweet> tweets = tweetRepository.findAllByOrderByCreatedDesc();
        model.addAttribute("tweets", tweets);
        Tweet tweet = new Tweet();

        model.addAttribute("tweet", tweet);
        model.addAttribute("loggedUserId", loggedUserId);


        return "Index";

    }

    @PostMapping("/home")
    public String home(@Valid @ModelAttribute Tweet tweet, BindingResult result) {
        if (result.hasErrors()) {
            return "Index";
        }
        tweet.setCreated(LocalDateTime.now());
        tweetRepository.save(tweet);
        return "redirect:/home";
    }


    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("loggedUserId");
        return "redirect:/login";
    }

}





