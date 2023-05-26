package com.cinema.clients.customer.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public enum Layout {
    THEATER("Theater"),

    USHAPE("U-Shape"),

    BOARD("Board Meeting");

    private String description;

}
