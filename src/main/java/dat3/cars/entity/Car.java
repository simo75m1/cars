package dat3.cars.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
public class Car
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
    private int bestDiscount;

    @CreationTimestamp
    private LocalDateTime createDateTime;

    @UpdateTimestamp
    private LocalDateTime updateDateTime;

    public Car()
    {}

    public Car(String brand, String model, double pricePrDay, int bestDiscount)
    {
        this.brand = brand;
        this.model = model;
        this.pricePrDay = pricePrDay;
        this.bestDiscount = bestDiscount;
    }

}
