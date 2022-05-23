package com.team.Bok.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDto {
    private Integer id;
    private Integer  quantity;
    private Integer  book_id;
    private Integer  user_id;
    private Double  total_price;
}
