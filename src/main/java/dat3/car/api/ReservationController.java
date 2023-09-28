package dat3.car.api;

import dat3.car.dto.ReservationRequest;
import dat3.car.dto.ReservationResponse;
import dat3.car.service.ReservationService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/reservations")
public class ReservationController {
    ReservationService reservationService;

    public ReservationController(ReservationService reservationService)
    {
        this.reservationService = reservationService;
    }

    //Security --> Authorized only (Skal bruge oplysninger på brugeren self.)
    @PreAuthorize("hasAuthority('USER')")
    @PostMapping
    ReservationResponse makeReservation(@RequestBody ReservationRequest res){
        return reservationService.reserveCar(res);
    }
    @PreAuthorize("hasAuthority('USER')")
    @PostMapping("/v2") //Can use pathvariables with carId and date, instead of requestbody
    ReservationResponse makeReservationV2(@RequestBody ReservationRequest res, Principal principal){
        res.setUserName(principal.getName());
        return reservationService.reserveCar(res);
    }

    //Security --> Admin only
    @GetMapping
    List<ReservationResponse> getReservations(){
        return reservationService.getReservations();
    }


    //USER (the current USER)
    @PreAuthorize("hasAuthority('USER')")
    @GetMapping("/reservations-for-authenticated")
    public List<ReservationResponse> getReservationsForUser(Principal principal){
        List<ReservationResponse> res = reservationService.getReservationsByMember(principal.getName());
        return res;
    }

    //ADMIN
    @GetMapping("/{userName}")
    public List<ReservationResponse> getReservationsForUser(@PathVariable String userName){
        List<ReservationResponse> res = reservationService.getReservationsByMember(userName);
        return res;
    }


}
