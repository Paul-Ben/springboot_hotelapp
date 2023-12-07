package com.hotel.hotel.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "hotel_details")
public class Hotel {

    @Valid

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @NotBlank
    private String hotelName;
    private String hotelId;
    @NotNull
    @NotBlank
    private String hotelAddress;
    private String hotelStarRating;
    @NotNull
    @NotBlank
    private String hotelPhone;
    @NotNull
    @NotBlank
    private String hotelEmail;
    private Integer number_of_rooms;

}
