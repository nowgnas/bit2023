package com.example.mybatis.app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Cust {
    private String name;
    private String pwd;
    private String id;

}
