package com.cydeo.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;
import java.util.Map;


@Getter@Setter@ToString
@NoArgsConstructor@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Location {

    @JsonProperty("location_id")
    private int locationID;

    private String city;

    @JsonProperty("country_id")
    private String countryID;

    private List<Link> links;




}
