package dat3.car.dto;

import dat3.car.entity.Reservation;
import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor //A must for @Builder
@Builder
public class ReservationResponse {

    int id;
    int carId;
    String brand;
    String model;
    LocalDate reservationDate;

    public ReservationResponse(Reservation reservation) {
        this.id = reservation.getId();
        this.carId = Math.toIntExact(reservation.getCar().getId());
        this.brand = reservation.getCar().getBrand();
        this.model = reservation.getCar().getModel();
        this.reservationDate = reservation.getRentalDate();
    }
}
