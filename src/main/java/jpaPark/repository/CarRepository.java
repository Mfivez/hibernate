package jpaPark.repository;

import jpaPark.models.Car;
import jpaPark.models.User;

public class CarRepository extends CrudRepository<Car, Long> {
    public CarRepository() {
        super(Car.class);
    }
}
