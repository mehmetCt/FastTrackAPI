package com.cydeo.pojo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter@Setter@NoArgsConstructor
@AllArgsConstructor@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Driver {
    @JsonProperty("driverId")
    private String id;
    private String givenName;
    private String familyName;
    private String nationality;

}
