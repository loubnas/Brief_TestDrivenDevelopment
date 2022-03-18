package com.example.brief_tdd.dto.model;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel("Client")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class ClientDto {
    private Long id;
    private String email;
    private String phone;
    private String fullname;
    private int age;
    private String sex;
    private Boolean isActive;


}
