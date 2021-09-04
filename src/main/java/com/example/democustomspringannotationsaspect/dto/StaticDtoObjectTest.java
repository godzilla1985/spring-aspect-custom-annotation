package com.example.democustomspringannotationsaspect.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StaticDtoObjectTest {

    private long userId;
    private String name;
    private int age;

}
