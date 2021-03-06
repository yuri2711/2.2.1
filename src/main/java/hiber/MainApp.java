package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

//        User userss = new User("Яков", "Марусчак", "79991621127@ya.ru");
//        userss.setCar(new Car("Граната", 3));
//        User userss2 = new User("Sergey", "Oblauhov", "sergo@ya.ru");
//        userss2.setCar(new Car("Мерседес", 8));
//        userService.add(userss);
//        userService.add(userss2);

        List<User> users = userService.listUsers();
//        for (User user : users) {
//            System.out.println("Id = " + user.getId());
//            System.out.println("First Name = " + user.getFirstName());
//            System.out.println("Last Name = " + user.getLastName());
//            System.out.println("Email = " + user.getEmail());
//            System.out.println("car = " + user.getCar().getModel());
//            System.out.println("car_series = " + user.getCar().getSeries());
//            System.out.println();
//        }
        User user = userService.getUser("Audi A",7);
        if (user!=null) {
            System.out.println(user.getFirstName());
            System.out.println(user.getLastName());
            System.out.println(user.getCar().getModel());
            System.out.println(user.getCar().getSeries());
        }
        context.close();
    }
}
