package com.cydeo.pojo;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter@Setter@ToString
@NoArgsConstructor@AllArgsConstructor
public class Cluster {

    private int id;

    private String name;

    @JsonProperty("rooms")
    private List<Room> roomList;


}
