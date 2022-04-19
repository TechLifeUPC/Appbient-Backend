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
@Table(name = "ComentariosForo")
public class ComentariosForo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @NotBlank
    @Size(max = 50)
    private String descripcion;

    @ManyToOne(targetEntity=PublicacionForo.class)
    @JoinColumn(name="publicacion_id")
    private PublicacionForo publicacion;

    @OneToMany(targetEntity = RespuestaForo.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "comentario_id", referencedColumnName = "id")
    private List<RespuestaForo> respuestasForo;
}
