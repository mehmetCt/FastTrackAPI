package com.cydeo.pojo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Getter@Setter@ToString
@NoArgsConstructor@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Room {

    private int id;

    private String name;

    private int capacity;


}
