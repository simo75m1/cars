package dat3.car.entity;

import dat3.security.entity.UserWithRoles;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "USER_TYPE")
public class Member extends UserWithRoles
{
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "street")
    private String street;
    @Column(name = "city")
    private String city;
    @Column(name = "zip")
    private String zip;
    @Column(name = "approved")
    private boolean approved;
    @Column(name = "ranking")
    private int ranking;

    @OneToMany(mappedBy = "member", cascade = CascadeType.PERSIST, fetch=FetchType.LAZY)
    List<Reservation> reservations = new ArrayList<>();
    public void addReservation(Reservation reservation)
    {
        reservations.add(reservation);
    }

    public Member(String user, String password, String email, String firstName,
                  String lastName, String street, String city, String zip) {
        super(user, password, email);
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.zip = zip;
    }

}
