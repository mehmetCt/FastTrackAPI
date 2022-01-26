package com.cydeo.pojo;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter@Setter@ToString
public class Link {

    private String rel;

    private String href;
}
