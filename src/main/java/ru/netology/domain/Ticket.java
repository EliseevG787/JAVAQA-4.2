package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data

public class Ticket{
    private int id;
    private int price;
    private String departure;
    private String arrival;
    private int travelTime;
}
