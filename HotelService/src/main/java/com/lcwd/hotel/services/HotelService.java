package com.lcwd.hotel.services;

import com.lcwd.hotel.entities.Hotel;

import java.util.List;

public interface HotelService {
    // Create hotel
   Hotel saveHotel(Hotel hotel);

    // Get single hotel of given id
    Hotel getHotel(String hotelId);

    // Get all hotels
    List<Hotel> getAllHotels();
}
