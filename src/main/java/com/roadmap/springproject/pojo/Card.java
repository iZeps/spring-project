package com.roadmap.springproject.pojo;

import lombok.Data;

@Data
public class Card {
    private long id;

    public Card(long id) {
        this.id = id;
    }
}
