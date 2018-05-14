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
import pl.workshop5.entity.Tweet;
import pl.workshop5.entity.User;
//import pl.workshop5.repository.TweetRepository;
import pl.workshop5.repository.TweetRepository;
import pl.workshop5.repository.UserRepository;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
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
    public String userForm(@ModelAttribute User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "UserForm";
        }

        List<User> users = userRepository.findAll();
        for (User userDb : users) {
            if (userDb.getEmail().matches(user.getEmail())) {
                model.addAttribute("err", "E-mail already taken");
                return "UserForm";
            }

        }
        userRepository.save(user);
        return "Login";
    }

    @GetMapping("/editUser")
    public String edit(Model model, HttpSession session) {

        Long loggedUserId = (Long) session.getAttribute("loggedUserId");
        if (loggedUserId == null) {
            return "redirect:/login";
        }

        Long id = (Long) session.getAttribute("loggedUserId");
        User user = userRepository.findOne(id);
        model.addAttribute("user", user);
        model.addAttribute("loggedUserId", id);
        return "UserEdit";
    }

    @PostMapping("/editUser")
    public String edit(@Valid @ModelAttribute User user) {
        userRepository.save(user);
        return "redirect:/home";
    }

    @GetMapping("/userPage")
    public String userPage (Model model, HttpSession session) {

        Long loggedUserId = (Long) session.getAttribute("loggedUserId");
        if (loggedUserId == null) {
            return "redirect:/login";
        }

        List<Tweet> tweets = tweetRepository.findAllByUserIdOrderByCreatedDesc(loggedUserId);
        model.addAttribute("tweets", tweets);
        return "UserPage";
    }



}
