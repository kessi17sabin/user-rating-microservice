package com.lcwd.hotel.Repositories;

import com.lcwd.hotel.Entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, String> {
}
