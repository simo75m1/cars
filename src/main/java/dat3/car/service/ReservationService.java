package dat3.car.service;

import dat3.car.dto.ReservationRequest;
import dat3.car.dto.ReservationResponse;
import dat3.car.entity.Car;
import dat3.car.entity.Member;
import dat3.car.entity.Reservation;
import dat3.car.repository.CarRepository;
import dat3.car.repository.MemberRepository;
import dat3.car.repository.ReservationRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.w3c.dom.html.HTMLHtmlElement;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationService {
    static ReservationRepository reservationRepository;
    static MemberRepository memberRepository;
    CarRepository carRepository;

    public ReservationService(ReservationRepository reservationRepository, MemberRepository memberRepository, CarRepository carRepository) {
        this.reservationRepository = reservationRepository;
        this.memberRepository = memberRepository;
        this.carRepository = carRepository;
    }

    public ReservationResponse reserveCar(ReservationRequest body){
        if(body.getDate().isBefore(LocalDate.now())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Date in past not allowed");
        }
        Member member = memberRepository.findById(body.getUserName()).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"No member with this id found"));
        Car car = carRepository.findById((long) body.getCarId()).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"No Car with this id found"));
        //What if already reserved  --> Tomorrow
        if(reservationRepository.existsByCar_IdAndRentalDate(body.getCarId(), body.getDate())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Car is already reserved on this date");
        }
        Reservation res = reservationRepository.save(new Reservation(body.getDate(),car,member));
        return new ReservationResponse(res);
    }

    public List<ReservationResponse> getReservations(){
        List<Reservation> reservations = reservationRepository.findAll();
        List<ReservationResponse> response = new ArrayList<>();
        for(Reservation reservation : reservations){
            ReservationResponse rr = new ReservationResponse(reservation);
            response.add(rr);
        }
        return response;
    }
    public static List<ReservationResponse> getReservationsByMember(Member member){
        if(!memberRepository.existsById(member.getUsername())){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Member with this username does not exist");
        }
        List<Reservation> reservations = reservationRepository.findAllReservationsByMemberUsername(member.getUsername());
        List<ReservationResponse> response = new ArrayList<>();
        for(Reservation reservation : reservations){
            ReservationResponse rr = new ReservationResponse(reservation);
            response.add(rr);
        }
        return response;
    }

    public void editReservationDate(Reservation reservation, LocalDate newDate){
        //TODO
    }

    public void deleteReservation(Reservation reservation){
        //TODO
    }



}
