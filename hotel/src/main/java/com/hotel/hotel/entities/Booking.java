package com.hotel.hotel.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "bookings")
public class Booking {
    private Long id;
    private String bookingId;
    private String guestId;
    private String roomId;
    private Date check_in_Date;
    private Date check_out_Date;
    private Integer number_of_guests;
    private String specialRequests;
}
