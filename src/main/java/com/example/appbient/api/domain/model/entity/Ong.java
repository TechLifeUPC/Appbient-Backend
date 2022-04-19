package com.example.appbient.api.domain.model.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@With
@Table(name = "Ong")
public class Ong{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @NotBlank
    @Size(max = 25)
    private String name;
    @NotNull
    @NotBlank
    @Size(max = 100)
    private String description;
    @OneToMany(targetEntity = Local.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "ong_id", referencedColumnName = "id")
    private List<Local> local;
}
