package pl.workshop5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.workshop5.entity.User;
import pl.workshop5.repository.UserRepository;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class LoginController {


    @Autowired
    UserRepository userRepository;


    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "Login";
    }


    @PostMapping("/login")
    public String login(@ModelAttribute User user,Model model, HttpSession session) {

        List<User> users = userRepository.findAll();

        for (User userDb : users) {
            if (userDb.getEmail().matches(user.getEmail())) {
//
//                System.out.println(userDb.getPassword());
//                System.out.println(user.getPassword());

                if (userDb.getPassword().matches(user.getPassword())) {
                    Long loggedUserId = userDb.getId();
                    session.setAttribute("loggedUserId", loggedUserId);
                    return "redirect:/home";
                }
            }
        }
        model.addAttribute("err", "Incorrect email or password");
        return "Login";
    }
}








