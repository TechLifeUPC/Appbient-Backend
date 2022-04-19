package com.example.appbient.api.resource.Local;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UpdateLocalResource {
    @NotNull
    @NotBlank
    @Size(max = 100)
    private String address;
}
