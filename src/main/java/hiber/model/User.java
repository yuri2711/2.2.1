package hiber.model;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

   @Id
   @Column(name = "id")
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(name = "name")
   private String firstName;

   @Column(name = "last_name")
   private String lastName;

   @Column(name = "email")
   private String email;

   @OneToOne(cascade = CascadeType.ALL)
   private Car car;

   public User() {}

   public void setCar(Car car) {
      this.car = car;
   }

   public User(String firstName, String lastName, String email) {

      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;

   }

}
