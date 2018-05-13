package pl.workshop5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import pl.workshop5.entity.Tweet;
import pl.workshop5.entity.User;
//import pl.workshop5.repository.TweetRepository;
import pl.workshop5.repository.TweetRepository;
import pl.workshop5.repository.UserRepository;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TweetRepository tweetRepository;


//    @GetMapping("/user/all")
//    public String listAll(Model model) {
//
//        List<User> users = userRepository.findAll();
//        model.addAttribute("users", users);
//        return "UserList";
//    }

    @GetMapping("/addUser")
    public String userForm(Model model) {
        model.addAttribute("user", new User());
        return "UserForm";
    }

    @PostMapping("/addUser")
    public String userForm(@ModelAttribute User user, BindingResult result) {
        if (result.hasErrors()) {
            return "UserForm";
        }
        userRepository.save(user);
        return "Login";
    }


}
