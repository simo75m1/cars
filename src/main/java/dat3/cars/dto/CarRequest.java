package dat3.cars.dto;

import dat3.cars.entity.Car;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CarRequest {
    private Long id;
    private String brand;
    private String model;
    private double pricePrDay;
    private Integer bestDiscount;

    public static Car getCarEntity(CarRequest c){
        return new Car(c.getId(), c.getBrand(), c.getModel(), c.getPricePrDay(), c.getBestDiscount());
    }

    public CarRequest(Long id, String brand, String model, double pricePrDay, Integer bestDiscount) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.pricePrDay = pricePrDay;
        this.bestDiscount = bestDiscount;
    }
}
