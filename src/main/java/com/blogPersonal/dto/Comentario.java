package com.blogPersonal.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Comentario {
    private int idComentario;
    private int idUsuario;
    private int idPublicacion;
    private String contenido;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fechaComentario;
}
