package dat3.car.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Car extends AdminDetails
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name="car_brand", length=50, nullable=false)
    private String brand;
    @Column(name="car_model", length=60, nullable=false)
    private String model;
    @Column(name="rental_price_day")
    private double pricePrDay;
    @Column(name="max_discount")
    private Integer bestDiscount;


    public Car()
    {}

    public Car(String brand, String model, double pricePrDay, int bestDiscount)
    {
        this.brand = brand;
        this.model = model;
        this.pricePrDay = pricePrDay;
        this.bestDiscount = bestDiscount;
    }

    public Car(Long id, String brand, String model, double pricePrDay, Integer bestDiscount) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.pricePrDay = pricePrDay;
        this.bestDiscount = bestDiscount;
    }
}
