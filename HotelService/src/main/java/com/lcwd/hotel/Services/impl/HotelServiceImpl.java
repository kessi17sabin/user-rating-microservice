package com.lcwd.hotel.Services.impl;

import com.lcwd.hotel.Entities.Hotel;
import com.lcwd.hotel.Exceptions.ResourceNotFoundException;
import com.lcwd.hotel.Repositories.HotelRepository;
import com.lcwd.hotel.Services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Hotel create(Hotel hotel) {
        String id = UUID.randomUUID().toString();
        hotel.setId(id);
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAll() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel get(String id) {
        return hotelRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel with given id not found !!"));
    }
}
