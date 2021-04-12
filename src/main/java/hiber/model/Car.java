package hiber.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "car")
public class Car {

    public Car() {
    }

    public Car(String model, int series){
        setSeries(series);
        setModel(model);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "model")
    private String model;


    @Column(name = "series")
    private int series;


}
