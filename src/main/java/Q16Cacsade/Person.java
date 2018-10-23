package Q16Cacsade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    Integer id;
    String name;
    Integer age;
    @OneToMany(cascade = CascadeType.PERSIST)
    List<Vehicle> listOfVehicles = new ArrayList<Vehicle>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Vehicle> getListOfVehicles() {
        return listOfVehicles;
    }

    public void setListOfVehicles(List<Vehicle> listOfVehicles) {
        this.listOfVehicles = listOfVehicles;
    }
}