package ru.maxx129.app;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.maxx129.dao.UsersDao;
import ru.maxx129.dao.UsersDaoJdbcTemplateImpl;
import ru.maxx129.models.User;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUsername("postgres");
        dataSource.setPassword("root");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/user_db");

        UsersDao usersDao = new UsersDaoJdbcTemplateImpl(dataSource);

        List<User> users = usersDao.findAll();

        System.out.println(users);
    }




}
