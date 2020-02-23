package com.roadmap.springproject.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Card {
    int id;
    String text;
}
