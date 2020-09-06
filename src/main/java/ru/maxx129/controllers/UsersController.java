package ru.maxx129.controllers;

import org.graalvm.compiler.lir.LIRInstruction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.maxx129.dao.UsersDao;
import ru.maxx129.forms.UserForm;
import ru.maxx129.models.User;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Controller
public class UsersController {

    @Autowired
    private UsersDao usersDao;

    @RequestMapping(path = "/users", method = RequestMethod.GET)
//    public ModelAndView getAllUsers(@RequestParam(value = "first_name", required = false) String firstName) {
    public ModelAndView getAllUsers(String firstName) {
        List<User> users = null;

        if (firstName != null) {
            users = usersDao.findAllByFirstName(firstName);
        } else {
            users = usersDao.findAll();
        }

        ModelAndView modelAndView = new ModelAndView("users");
        modelAndView.addObject("usersFromServer", users);

        return modelAndView;
    }

    @RequestMapping(path = "/users/{user-id}", method = RequestMethod.GET)
    public ModelAndView getUserById(@PathVariable("user-id") Integer userId) {
        Optional<User> userCandidate = usersDao.find(userId);

        ModelAndView modelAndView = new ModelAndView("users");
        userCandidate.ifPresent(user -> modelAndView.addObject("usersFromServer", Collections.singletonList(user)));

        return modelAndView;
    }

    @RequestMapping(path = "/users", method = RequestMethod.POST)
    public String addUser(UserForm userForm) {
        User newUser = User.from(userForm);
        usersDao.save(newUser);

        return "redirect:/users";
    }
}
