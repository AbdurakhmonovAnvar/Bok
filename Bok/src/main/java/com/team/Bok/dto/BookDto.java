package com.team.Bok.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class BookDto {
    private Integer id;
    private String author;
    private String title;
    private Double price;
    private String image;



}
