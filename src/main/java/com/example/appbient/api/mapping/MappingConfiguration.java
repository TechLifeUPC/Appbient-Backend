package com.example.appbient.api.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration("FortlomMappingConfiguration")
public class MappingConfiguration {

    @Bean
    public VoluntarioMapper voluntarioMapper() {
        return new VoluntarioMapper();
    }

    @Bean
    public TopicoMapper topicoMapper() {
        return new TopicoMapper();
    }

    @Bean
    public PublicacionForoMapper publicacionForoMapper() {
        return new PublicacionForoMapper();
    }

    @Bean
    public RespuestaForoMapper respuestaForoMapper() {
        return new RespuestaForoMapper();
    }

    @Bean
    public ComentarioForoMapper comentarioForoMapper() {
        return new ComentarioForoMapper();
    }




}
