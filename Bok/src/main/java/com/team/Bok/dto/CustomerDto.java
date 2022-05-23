package com.team.Bok.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDto {
    private Integer id;

    private String name;
    private String surname;
    private String password;
    private String contact;
    private Boolean city;
    private String email;
}
