package dat3.car.api;

import dat3.car.dto.ReservationRequest;
import dat3.car.dto.ReservationResponse;
import dat3.car.service.ReservationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {
    ReservationService reservationService;

    public ReservationController(ReservationService reservationService)
    {
        this.reservationService = reservationService;
    }

    //Security --> Admin only
    @GetMapping
    List<ReservationResponse> getReservations(){
        return reservationService.getReservations();
    }

    //Security --> Authorized only (Skal bruge oplysninger på brugeren self.)
    @PostMapping
    ReservationResponse makeReservation(@RequestBody ReservationRequest res){
        return reservationService.reserveCar(res);
    }



}
