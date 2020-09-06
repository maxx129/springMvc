package ru.maxx129.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import ru.maxx129.dao.UsersDao;
import ru.maxx129.models.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class UsersControllerSimple implements Controller {

    @Autowired
    private UsersDao usersDao;

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (request.getMethod().equals("GET")) {
            List<User> users = usersDao.findAll();
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("users");
            modelAndView.addObject("usersFromServer", users);

            return modelAndView;
        }





        return null;
    }
}
