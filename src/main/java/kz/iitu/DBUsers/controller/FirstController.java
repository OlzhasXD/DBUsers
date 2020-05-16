package kz.iitu.DBUsers.controller;

import kz.iitu.DBUsers.model.Users;
import kz.iitu.DBUsers.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class FirstController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping(path="/save")
    public @ResponseBody String addNewUser (@RequestParam String name, @RequestParam String pass,
                                            @RequestParam String date) {

        Users new_user = new Users(name, pass, date);
        userRepository.save(new_user);
        return String.valueOf(new_user.getId());
    }

    @GetMapping(path="/find")
    public @ResponseBody Iterable<Users> findUser (@RequestParam String filter) {
        List<Users> user = userRepository.findById(Integer.parseInt(filter));
        return user;
    }
}
