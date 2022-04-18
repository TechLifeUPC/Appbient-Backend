package com.example.appbient.api.resource.PublicacionForo;

import com.sun.istack.NotNull;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
public class UpdatePublicacionForoResource {
    private boolean active;
    @NotNull
    @NotBlank
    @Size(max = 50)
    private String name;
    @NotNull
    @NotBlank
    @Size(max = 100)
    private String description;
}
