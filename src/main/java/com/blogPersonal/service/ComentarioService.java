package com.blogPersonal.service;

import com.blogPersonal.dto.Comentario;
import com.blogPersonal.exception.ExceptionService;

import java.util.List;

public interface ComentarioService {
    List<Comentario> findAll() throws ExceptionService;

    Comentario findOne(int idPublicacion) throws ExceptionService;

    void insertComentario(Comentario comentario) throws ExceptionService;

    void updateComentario(Comentario comentario) throws ExceptionService;

    void deleteComentario(int idCometario) throws ExceptionService;
}
