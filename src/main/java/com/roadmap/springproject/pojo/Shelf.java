package com.roadmap.springproject.pojo;

import lombok.Data;

@Data
public class Shelf {

    private long id;

    public Shelf(long id) {
        this.id = id;
    }
}
