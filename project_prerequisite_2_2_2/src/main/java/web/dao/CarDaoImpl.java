package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CarDaoImpl implements CarDao {
    private static final List<Car> carList = new ArrayList<>();

    static {
        carList.add(new Car("Mercedes-Benz M II (W164) 350", "black", 2007));
        carList.add(new Car("Hyundai ix35 I ", "white", 2015));
        carList.add(new Car("Land Rover Range Rover Evoque I 6-speed", "white", 2012));
        carList.add(new Car("Peugeot 408 I ", "black", 2017));
        carList.add(new Car("Volkswagen Touareg II", "silver", 2013));
    }

    @Override
    public List<Car> getCars(int count) {
        if (count == 0) {
            return carList;
        }
        return carList.stream().limit(count).collect(Collectors.toList());
    }
}
