package com.example.restservice.consumingrest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Value {
    private Long id;
    private String quote;
}
