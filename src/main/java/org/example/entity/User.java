package org.example.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUser;
    @Column(name = "name")
    private String name;
    @Column(name = "birthDay")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDay;
    @Column(name = "sex")
    private boolean sex;
    @Column(name = "email")
    private String email;
    @Column(name = "phoneNumber")
    private String phoneNumber;
    @Column(name = "address")
    private String address;

    public User(String name, LocalDate birthDay, boolean sex, String email, String phoneNumber, String address) {
        this.name = name;
        this.birthDay = birthDay;
        this.sex = sex;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
}
