package com.example.appbient.api.domain.model.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@With
@Table(name = "RespuestasForo")
public class RespuestaForo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @NotBlank
    @Size(max = 50)
    private String descripcion;

    @ManyToOne(targetEntity = ComentariosForo.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "comentario_id")
    private ComentariosForo comentario;
}
