package com.example.restservice.consumingrest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Quote {
    private String type;
    private Value value;
}
