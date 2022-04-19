package com.example.appbient.api.resource.Ong;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OngResource {
    private Long id;
    private String name;
    private String description;
    private List<String> locals;
}