package dat3.car.service;


import dat3.car.dto.CarRequest;
import dat3.car.dto.CarResponse;
import dat3.car.entity.Car;
import dat3.car.repository.CarRepository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.event.annotation.AfterTestMethod;
import org.springframework.web.server.ResponseStatusException;
import java.time.LocalDateTime;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@DataJpaTest
class CarServiceH2Test
{

    @Autowired
    CarRepository carRepository;
    CarService carService;

    Car c1, c2;

    @BeforeEach
    void setUp() {
        c1 = carRepository.save(new Car(1,"Toyota", "Aygo", 300, 100));
        c2 = carRepository.save(new Car(2,"Toyota", "Supra", 600, 300));
        carService = new CarService(carRepository); //Set up carService with the mock (H2) database
    }
    @AfterEach
    void tearDown(){
        c1 = null;
        c2 = null;
    }

    @Test
    void testGetCarsAllDetails(){
        List<CarResponse> carResponses = carService.getCars(true);
        assertEquals(2, carResponses.size(), "Expects 2 cars in list");
        LocalDateTime time = carResponses.get(0).getCreated();
        assertNotNull(time, "Time should be set when true is passed to getMembers()");
    }
    @Test
    void testGetCarsNoDetails(){
        List<CarResponse> carResponses = carService.getCars(false);
        assertEquals(2, carResponses.size(), "Expects 2 cars in list");
        LocalDateTime time = carResponses.get(0).getCreated();
        assertNull(time, "Time should not set when false is passed to getMembers()");
    }
    @Test
    void testFindByIdFound(){
        CarResponse res = carService.findById(2);
        assertEquals(2, res.getId());
    }
    @Test
    void testFindByIdNotFound(){
        ResponseStatusException ex = assertThrows(ResponseStatusException.class, () -> carService.findById(5));
        assertEquals(HttpStatus.NOT_FOUND, ex.getStatusCode());
    }

    @Test
    void testAddCar(){
        CarRequest request = CarRequest.builder().
                id(3L).
                brand("Ford").
                model("Mondeo").
                pricePrDay(700).
                build();
        CarResponse res = carService.addCar(request);
        assertEquals(3, res.getId());
        assertTrue(carRepository.existsById(3L));
    }
    @Test
    void testEditCarWithExistingId(){
        CarRequest request = new CarRequest(c1);
        request.setBrand("New Brand");
        request.setModel("New Model");
        request.setBestDiscount(50);

        carService.editCar(request, 1);

        carRepository.flush();
        CarResponse response = carService.findById(1);

        assertEquals(1, response.getId());
        assertEquals("New Brand", response.getBrand());
        assertEquals("New Model", response.getModel());
        assertEquals(300, response.getPricePrDay());
        assertEquals(50, response.getBestDiscount());

    }
    @Test
    void testEditCarNon_ExistingIdThrows(){
        CarRequest carRequest = new CarRequest();
        ResponseStatusException ex = assertThrows(ResponseStatusException.class, () -> carService.editCar(carRequest, 10));
        assertEquals(HttpStatus.NOT_FOUND, ex.getStatusCode());
    }
    @Test
    void testEditCarChangePrimaryKeyThrows(){
        CarRequest request = new CarRequest(c1);
        request.setId(5L);
        ResponseStatusException ex = assertThrows(ResponseStatusException.class, () -> carService.editCar(request, 1));
        assertEquals(HttpStatus.BAD_REQUEST, ex.getStatusCode());
    }
    @Test
    void testSetBestDiscountForCar(){
        carService.setBestDiscount(1L, 200);
        CarResponse response = carService.findById(1);
        assertEquals(200,response.getBestDiscount());
    }
    @Test
    void testSetBestDiscountForNon_ExistingCar(){
        ResponseStatusException ex = assertThrows(ResponseStatusException.class, () -> carService.setBestDiscount(4, 5));
        assertEquals(HttpStatus.NOT_FOUND, ex.getStatusCode());
    }
    @Test
    void testDeleteCar(){
        carService.deleteCarById(1);
        assertFalse(carRepository.existsById(1L));
    }
    @Test
    void testDeleteNon_ExistingCar(){
        ResponseStatusException ex = assertThrows(ResponseStatusException.class, () -> carService.deleteCarById(5));
        assertEquals(HttpStatus.NOT_FOUND, ex.getStatusCode());
    }
}