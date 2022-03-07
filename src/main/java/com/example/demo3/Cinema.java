package com.example.demo3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.*;

public class Cinema {
    private int total_rows;
    private int total_columns;
    private ArrayList<AvailableSeats> available_seats = new ArrayList<>();

    public int getTotal_rows() {
        return total_rows;
    }

    public void setTotal_rows(int total_rows) {
        this.total_rows = total_rows;
    }

    public int getTotal_columns() {
        return total_columns;
    }

    public void setTotal_columns(int total_columns) {
        this.total_columns = total_columns;
    }

    public ArrayList<AvailableSeats> getAvailable_seats() {
        return available_seats;
    }

    public void setAvailable_seats(ArrayList<AvailableSeats> available_seats) {
        this.available_seats = available_seats;
    }

    public Cinema() {
    }

    public Cinema(int total_rows, int total_columns) {
        this.total_rows = total_rows;
        this.total_columns = total_columns;
        addAvailableSeats();

    }

    public void addAvailableSeats() {
        for (int i = 1; i <= total_rows; i++) {
            for (int j = 1; j <= total_columns; j++) {
                available_seats.add(new AvailableSeats(i, j));
            }
        }
    }
}

@RestController
class CinemaController {
    List<Map<String, Integer>> list = new LinkedList<>();
    Cinema cinema = new Cinema(9, 9);
    Map<UUID, AvailableSeats> map1 = new LinkedHashMap<>();

    @PostMapping("/purchase")
    public ResponseEntity<?> postReq(@RequestBody Map<String, Integer> mapUser) {
        ResponseBody responseBody = new ResponseBody();
        if (mapUser.get("row") > cinema.getTotal_rows() | mapUser.get("column") > cinema.getTotal_columns() | mapUser.get("row") < 1 | mapUser.get("column") < 1) {
            return new ResponseEntity<>(Map.of("error", "The number of a row or a column is out of bounds!"), HttpStatus.BAD_REQUEST);
        } else {
            AvailableSeats availableSeats = new AvailableSeats(mapUser.get("row"), mapUser.get("column"));
            Map<String, Integer> map = new LinkedHashMap<>();
            map.put("row", mapUser.get("row"));
            map.put("column", mapUser.get("column"));
            if (list.contains(map)) {
                return new ResponseEntity<>(Map.of("error", "The ticket has been already purchased!"), HttpStatus.BAD_REQUEST);
            } else {
                UUID token = UUID.randomUUID();
                responseBody.setToken(token);
                responseBody.setTicket(availableSeats);
                list.add(map);
                map1.put(token, availableSeats);
                return new ResponseEntity<>(responseBody, HttpStatus.OK);
            }
        }
    }


    @GetMapping("/seats")
    public Cinema getCinemaList() {
        return cinema;
    }


    @PostMapping("/return")
    public ResponseEntity<?> postReq2(@RequestBody Map<String, UUID> tokenMap) {
        UUID tokenUser = tokenMap.get("token");
        if (map1.containsKey(tokenUser)) {
            AvailableSeats availableSeats = map1.get(tokenUser);
            map1.remove(tokenUser);

            Map<String, Integer> map = new LinkedHashMap<>();
            map.put("row", availableSeats.getRow());
            map.put("column", availableSeats.getColumn());
            list.remove(map);
            return new ResponseEntity<>(Map.of("returned_ticket", availableSeats), HttpStatus.OK);

        } else {
            return new ResponseEntity<>(Map.of("error", "Wrong token!"), HttpStatus.BAD_REQUEST);
        }
    }


    @PostMapping(value = "/stats")
    public ResponseEntity<?> postReq3(@RequestParam(defaultValue = "") String password) {
        Cinema cinema = new Cinema(9, 9);
        if (password.equals("super_secret")) {
            Map<String, Integer> map = new LinkedHashMap<>();
            int total_income = 0;
            for (AvailableSeats availableSeats : map1.values()) {
                total_income += availableSeats.getPrice();
            }
            map.put("current_income", total_income);
            map.put("number_of_available_seats", cinema.getTotal_columns() * cinema.getTotal_rows() - map1.size());
            map.put("number_of_purchased_tickets", map1.size());
            return new ResponseEntity<>(map, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(Map.of("error", "The password is wrong!"), HttpStatus.UNAUTHORIZED);
        }
    }



}

