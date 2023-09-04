package dat3.car.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String reservationDate;
    String rentalDate;

    @ManyToOne
    Car car;
    @ManyToOne
    Member member;

    public Reservation(String reservationDate, String rentalDate) {
        this.reservationDate = reservationDate;
        this.rentalDate = rentalDate;
    }
}
