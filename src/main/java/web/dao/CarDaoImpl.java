package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarDaoImpl implements CarDao{

    private static List<Car> carList;
    static {
        carList = new ArrayList<>();
        carList.add(new Car("Jaguar", "XF", 2018));
        carList.add(new Car("BMW", "X7", 2020));
        carList.add(new Car("Lixian", "L9", 2023));
        carList.add(new Car("Lada", "2101", 1999));
        carList.add(new Car("Chery", "Tiggi 7 pro", 2020));
    }

    @Override
    public List<Car> getCars() {
        return carList;
    }

    @Override
    public List<Car> getCarListOnCount(Integer countCars) {
        List<Car> list = getCars();
        if (countCars == null || countCars < 0 || countCars > list.size()) {
            countCars = list.size();
        }
        return list.stream().limit(countCars).toList();
    }
}
