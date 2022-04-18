package com.example.appbient.api.resource.Topico;

import com.sun.istack.NotNull;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
public class UpdateTopicoResource {
    @NotNull
    @NotBlank
    @Size(max = 50)
    private String name;
    @Size(max = 100)
    private String description;
}
