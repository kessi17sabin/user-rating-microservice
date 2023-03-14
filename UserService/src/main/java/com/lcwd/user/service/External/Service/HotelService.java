package com.lcwd.user.service.External.Service;

import com.lcwd.user.service.Entities.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "HOTEL-SERVICE")
public interface HotelService {

    // get hotel by hotel id
    @GetMapping("/hotels/{hotelId}")
    Hotel getHotelById(@PathVariable String hotelId);
}
