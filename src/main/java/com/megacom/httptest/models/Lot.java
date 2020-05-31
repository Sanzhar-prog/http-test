package com.megacom.httptest.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Lot {

    private Long id;

    private String description;
    @JsonFormat(pattern = "dd.MM.yyyy")
    private Date start_date;
    @JsonFormat(pattern = "dd.MM.yyyy")
    private Date end_date;


    private double min_price;
    private double max_price;

    private double step;
}
