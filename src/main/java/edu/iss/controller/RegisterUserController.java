package edu.iss.controller;

import edu.iss.entities.Group;
import edu.iss.entities.User;
import edu.iss.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/register")
public class RegisterUserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public String showRegisterPage(Model model){
        List<User> users = userRepository.findAll();
        model.addAttribute("groups", Group.values());
        model.addAttribute("user", new User());
        return "registerUser";
    }

    @PostMapping
    public String registerUser(@ModelAttribute User user){
        userRepository.create(user);
        return "registerUser";
    }
}
