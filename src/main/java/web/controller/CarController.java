package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;
import web.service.CarServiceImpl;

import java.util.List;

@Controller
public class CarController {

    private CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping(value = "/cars")
    public String printCars(
            @RequestParam(value = "count", required = false) Integer countCars,
            ModelMap model) {

        List<Car> list = carService.getCarListOnCount(countCars);

        model.addAttribute("cars", list);
        model.addAttribute("countCars", countCars);
        return "cars";
    }
}
