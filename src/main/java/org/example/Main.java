package org.example;

import org.example.config.JPAConfig;
import org.example.entity.User;
import org.example.repository.UserRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDate;
import java.util.Optional;

public class Main {
    static ApplicationContext context = new AnnotationConfigApplicationContext(JPAConfig.class);
    static UserRepository userRepository = (UserRepository) context.getBean("userRepository");
    public static void main(String[] args) {
//        createNewUser();
        showList();
//        findById(1);
//        findByName("Le Hoang Long");
//        findByPhoneOrEmail("?","0587107407");
        isMen();
    }

    // Add User Method
    public static void createNewUser(){
        User u = new User("Lam Nhu", LocalDate.parse("1965-01-08")
                ,true,"lamdeptrai123@gmail.com","0587107407","DN");
        userRepository.save(u);
    }

    // Show all user
    public static void showList(){
        System.out.println(userRepository.findAll());
    }

    // Find By Id
    public static void findById(int id){
        Optional<User> u = userRepository.findById(id);
        if(u.isPresent()){
            System.out.println("The user with id = " + id + " is here");
            System.out.println(u.toString());
        }
    }

    // Find By Name
    public static void findByName(String name){
        User u = userRepository.findByName(name);
        if(u != null){
            System.out.println(u.toString());
        } else {
            System.out.println("Can't not found!");
        }
    }

    // Find By Phone or Email
    public static void findByPhoneOrEmail(String email, String phoneNumber){
        User u = userRepository.findByPhoneOrEmail(email, phoneNumber);
        if(u != null){
            System.out.println(u.toString());
        } else {
            System.out.println("Can't not found!");
        }
    }

    // Find By user who is a men and 20 < age > 30
    public static void isMen(){
        User u = userRepository.isMenBetWeen20And30();
        if(u != null){
            System.out.println(u.toString());
        } else {
            System.out.println("Can't not found!");
        }
    }
}