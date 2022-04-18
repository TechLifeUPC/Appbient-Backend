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
@Table(name = "Publicacion_foro")
public class PublicacionForo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean active;

    @NotNull
    @NotBlank
    @Size(max = 50)
    private String name;

    @NotNull
    @NotBlank
    @Size(max = 100)
    private String description;

    @OneToMany(targetEntity = ComentariosForo.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "publicacion_id", referencedColumnName = "id")
    private List<ComentariosForo> ComentariosForo;

    @ManyToOne(targetEntity = Voluntario.class)
    @JoinColumn(name = "voluntario_id")
    private Voluntario voluntario;

    private Integer ongId;

    @ManyToOne(targetEntity = Topico.class)
    @JoinColumn(name = "topico_id")
    private Topico topico;
}
