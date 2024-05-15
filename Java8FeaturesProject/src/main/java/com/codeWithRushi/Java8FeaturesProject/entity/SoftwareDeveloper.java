package com.codeWithRushi.Java8FeaturesProject.entity;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SoftwareDeveloper {

    private String firstname;
    private String lastname;
    private int age;
    private double salary;
    private List<String> skills;
    private String gender;

}
