package com.example.brief_tdd.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "Client")
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class ClientEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Email(message = "Email should be valid")
    @NotNull(message = "Email cannot be null")
    @Column(name = "email",unique = true)
    private String email;

    @Pattern(regexp="(\\+212|0)[6-7][0-9]{8}")
    @Column(name = "phone",nullable = false,unique = true)
    private String phone;

    @NotNull(message = "Name cannot be null")
    @Column(name = "fullname")
    private String fullname;

    @Positive
    @Min(value = 1, message = "Age should not be less than 1")
    @Max(value = 150, message = "Age should not be greater than 150")
    @Column(name = "age")
    private int age;


    @Pattern(regexp="^homme$|^femme$")
    @NotEmpty
    @Column(name = "sex")
    private String sex;

    @Column(name = "isActive")
    private Boolean isActive;

}
