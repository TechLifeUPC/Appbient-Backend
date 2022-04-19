package com.example.appbient.api.resource.Ong;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UpdateOngResource {
    @NotNull
    @NotBlank
    @Size(max = 25)
    private String name;
    @NotNull
    @NotBlank
    @Size(max = 100)
    private String description;
}