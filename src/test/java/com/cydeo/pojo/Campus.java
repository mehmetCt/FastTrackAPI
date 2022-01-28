package com.cydeo.pojo;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter@Setter@ToString
@AllArgsConstructor@NoArgsConstructor
public class Campus {

    private int id;

    private String location;

    @JsonProperty("clusters")
    private List<Cluster> clusterList;


}
