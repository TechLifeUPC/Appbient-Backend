package com.example.appbient.api.resource.Voluntario;

import com.sun.istack.NotNull;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
public class CreateVoluntarioResource {
    @NotNull
    @NotBlank
    @Size(max = 50)
    private String username;
    @NotNull
    @NotBlank
    @Size(max = 100)
    private String firstname;
    @NotNull
    @NotBlank
    @Size(max = 100)
    private String lastname;
    @Size(max = 100)
    private String email;
}
