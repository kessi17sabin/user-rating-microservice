package com.lcwd.hotel.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/staffs")
public class StaffController {

    @GetMapping("")
    public List<String> getStaffs() {
        return List.of("John", "Ronaldo", "Binod");
    }
}
