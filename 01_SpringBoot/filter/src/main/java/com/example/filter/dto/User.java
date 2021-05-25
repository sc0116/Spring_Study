package com.example.filter.dto;

import lombok.*;

//@Getter           //Getter
//@Setter           //Setter
@Data               //Getter + Setter + toString + equals + ...
@NoArgsConstructor  //기본 생성자
@AllArgsConstructor //전체 생성자
public class User {

    private String name;
    private int age;

}
