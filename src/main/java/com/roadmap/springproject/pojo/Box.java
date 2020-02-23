package com.roadmap.springproject.pojo;

import lombok.Data;

@Data
public class Box {
    private long id;

    public Box(long id) {
        this.id = id;
    }
}
