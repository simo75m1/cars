package dat3.car.api;

import dat3.car.dto.CarRequest;
import dat3.car.dto.CarResponse;
import dat3.car.service.CarService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/cars")
public class CarController {
    CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    //Security --> Anonymous
    @GetMapping
    List<CarResponse> getCars() {
        return carService.getCars(false);
    }
    //Security ADMIN

    @GetMapping("/admin")
    List<CarResponse> getCarsAll(){
        return carService.getCars(true); //false --> Only info relevant for customers
    }

    //Security --> Admin only
    @GetMapping(path = "/{id}")
    CarResponse getCarById(@PathVariable long id) throws Exception{
        return carService.findById(id);
    }


    //Can be used to filter results for customers
    //Security --> Anonymous
    @GetMapping(path="/{brand}/{model}")
    List<CarResponse> getCarByBrandAndModel(@PathVariable String brand, @PathVariable String model) throws Exception{
        return carService.getCarsByBrandAndModel(brand,model);
    }
    //Security --> Admin
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    CarResponse addCar(@RequestBody CarRequest body){
        return carService.addCar(body);
    }

    //Security --> Admin
    @PutMapping("/{id}")
    ResponseEntity<Boolean> editCar(@RequestBody CarRequest body, @PathVariable long id){
        return carService.editCar(body, id);
    }

    //Security ADMIN
    @PatchMapping("/{id}/{discount}")
    void setBestDiscountForCar(@PathVariable long id, @PathVariable int discount) {
        carService.setBestDiscount(id, discount);
    }

    // Security ADMIN
    @DeleteMapping("/{id}")
    void deleteMemberByUsername(@PathVariable long id) {
        carService.deleteCarById(id);
    }

}
