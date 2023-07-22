package com.blogPersonal.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Publicacion {
    private int idPublicacion;
    private int idUsuario;
    private int idCategoria;
    private String titulo;
    private String contenido;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fachaPublicacion;
}
