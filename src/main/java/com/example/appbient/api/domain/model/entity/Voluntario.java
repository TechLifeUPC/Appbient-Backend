package com.example.appbient.api.domain.model.entity;

import com.sun.istack.NotNull;
import jdk.jfr.Timestamp;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@With
@Table(name = "Voluntarios")
public class Voluntario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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
    //created_at
    @CreationTimestamp
    private Date createdAt;
    @Size(max = 100)
    private String email;

    @OneToMany(targetEntity = PublicacionForo.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "voluntario_id", referencedColumnName = "id")
    private List<PublicacionForo> publicacionesForo;

}
