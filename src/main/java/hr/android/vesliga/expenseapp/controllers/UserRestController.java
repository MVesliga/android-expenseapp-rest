package hr.android.vesliga.expenseapp.controllers;

import hr.android.vesliga.expenseapp.repositories.UserRepository;
import hr.android.vesliga.expenseapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/users", produces = "application/json")
@CrossOrigin
public class UserRestController {

    @Autowired
    UserRepository userRepository;

    @GetMapping
    public Iterable<User> findAll(){
        return userRepository.findAll();
    }

    @PostMapping(consumes = "application/json")
    public User save(@RequestBody User user){
        return userRepository.save(user);
    }
}
