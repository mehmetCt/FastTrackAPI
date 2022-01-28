package com.cydeo.pojo;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter@Setter@ToString
@AllArgsConstructor@NoArgsConstructor
public class Category {


    private String id;

    @JsonProperty("name")
    private String categoryName;



}
