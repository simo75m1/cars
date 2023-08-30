package dat3.car.service;

import dat3.car.dto.CarRequest;
import dat3.car.dto.CarResponse;
import dat3.car.entity.Car;
import dat3.car.repository.CarRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {

    CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }


    public List<CarResponse> getCars(boolean includeAll) {
        List<Car> cars = carRepository.findAll();
        List<CarResponse> response = new ArrayList<>();
        for(Car car : cars) {
            CarResponse cr = new CarResponse(car, includeAll);
            response.add(cr);
        }
        return response;
    }
    public CarResponse getCarById(long id) {
        Car car = findCarById(id);
        return new CarResponse(car, true);
    }

    public List<CarResponse> getCarsByBrand(String brand) {
        List<Car> cars = carRepository.findCarByBrand(brand);
        List<CarResponse> response= new ArrayList<>();
        for(Car car : cars){
            CarResponse cr = new CarResponse(car, false);
            response.add(cr);
        }
        return response;
    }


    public CarResponse addCar(CarRequest body) {
        if(carRepository.existsById(body.getId())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This car already exists");
        }
        Car newCar = CarRequest.getCarEntity(body);
        newCar = carRepository.save(newCar);

        return new CarResponse(newCar, true);
    }


    public ResponseEntity<Boolean> editCar(CarRequest body, long id) {
        Car car = findCarById(id);
        if(!body.getId().equals(id)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Cannot change car id");
        }
        car.setBrand(body.getBrand());
        car.setModel(body.getModel());
        car.setPricePrDay(body.getPricePrDay());
        car.setBestDiscount(body.getBestDiscount());
        carRepository.save(car);

        return ResponseEntity.ok(true);
    }

    //Used to get specific car, only for backend usage in service class. No CarResponse needed for this.
    private Car findCarById(long id){
        return carRepository.findById(id).
                orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST,"Car with this id does not exist"));
    }
    public void setBestDiscount(long id, int discount) {
        Car car = findCarById(id);
        car.setBestDiscount(discount);
        carRepository.save(car);
    }
    public void deleteCarById(long id) {
        Car car = findCarById(id);
        carRepository.delete(car);
    }

}
