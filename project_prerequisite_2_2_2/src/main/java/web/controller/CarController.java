package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarService;

import java.util.Optional;

@Controller
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping("/cars")
    public String showCars(@RequestParam("count") Optional<Integer> count, Model model) {
        int carCount =count.orElse(5);
        carCount = (carCount < 0) ? 5 : carCount;
        model.addAttribute("cars", carService.getCars(carCount));
        return "cars";
    }
}
