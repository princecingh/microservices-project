package com.lcwd.hotel.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "micro_hotels")
public class Hotel {
    @Id
    @Column(name = "hotel_id")
    private String hotelId;

    @Column(name = "Name", length = 20)
    private String name;

    @Column(name = "Location", length = 20)
    private String location;

    @Column(name = "About", length = 100)
    private String about;

}
