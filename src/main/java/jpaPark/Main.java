package jpaPark;

import jpaPark.models.Car;
import jpaPark.models.User;
import jpaPark.repository.CarRepository;
import jpaPark.repository.UserRepository;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        UserRepository userRepo = new UserRepository();
        CarRepository carRepo = new CarRepository();

        User user = new User(null, "Michel", null);
        user = userRepo.insert(user);
        System.out.println("Utilisateur ajouté : " + user);

        Car car = new Car(null, "Toyota", user);
        car = carRepo.insert(car);
        System.out.println("Voiture ajoutée : " + car);

        List<User> users = userRepo.findAll();
        System.out.println("Liste des utilisateurs : " + users);

        List<Car> cars = carRepo.findAll();
        System.out.println("Liste des voitures : " + cars);
    }
}