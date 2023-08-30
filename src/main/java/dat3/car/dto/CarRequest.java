package dat3.car.dto;

import dat3.car.entity.Car;
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
