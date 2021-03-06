package com.team.Bok.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter

@Entity
@Table(name = ("order"))
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer  quantity;
    private Integer  book_id;
    private Integer  user_id;
    private Double  total_price;


}
