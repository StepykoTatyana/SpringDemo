package com.example.demo3;

import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class DataController {
    DataId dataId = new DataId();
    DataData dataData = new DataData();
    Map<Integer, String> map = new LinkedHashMap<>();

    @GetMapping("/api/data/{id}")
    public DataData getRequestData(@PathVariable int id) {
        dataData.setData(map.get(id));
        return dataData;

    }

    @PostMapping("/api/data/new")
    public DataId postRequestData(@RequestBody DataData dataUser) {
        dataData.setData(dataUser.getData());
        if (map.size() == 0) {
            dataId.setId(1);
            map.put(1, dataData.getData());
        } else {
            dataId.setId(dataId.getId() + 1);
            map.put(dataId.getId(), dataData.getData());
        }
        return dataId;

    }
}

class DataId {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DataId() {
    }

    public DataId(int id) {
        this.id = id;

    }


}

class DataData {
    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public DataData(String data) {
        this.data = data;
    }

    public DataData() {
    }
}