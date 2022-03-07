package com.example.demo3;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@RestController
public class FlightController {
    private static final List<FlightInfo> flightInfoList;

    static {
        flightInfoList = new ArrayList<>();
        flightInfoList.add(new FlightInfo("Delhi Indira Gandhi", "Stuttgart", "D80"));
        flightInfoList.add(new FlightInfo("Tokyo Haneda", "Frankfurt", "110"));
        flightInfoList.add(new FlightInfo("Kilimanjaro Arusha", "Boston", "15"));
        flightInfoList.add(new FlightInfo("Berlin Schönefeld", "Tenerife", "15"));
    }

    @GetMapping("flights/{id}")
    public static FlightInfo getFlightInfo(@PathVariable int id) {
        if (id > flightInfoList.size()) {
            throw new FlightNotFoundException("Flight not found for id = " + id);
        }
        FlightInfo flightInfo = flightInfoList.get(id);

        if (Objects.equals(flightInfo.getFrom(), "Berlin Schönefeld")) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,
                    "Berlin Schönefeld is closed for service today");
        }


        return flightInfoList.get(id);

    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    static
    class FlightNotFoundException extends RuntimeException {

        public FlightNotFoundException(String cause) {
            super(cause);
        }
    }
}
