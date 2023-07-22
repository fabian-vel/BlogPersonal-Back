package com.blogPersonal.dto;

import lombok.Data;

@Data
public class Usuario {
    private int idUsuario;
    private String nombre;
    private String correo;
    private String rutaImagen;
}
