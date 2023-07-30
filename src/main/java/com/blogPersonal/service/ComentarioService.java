package com.blogPersonal.service;

import com.blogPersonal.dto.Comentario;
import com.blogPersonal.exception.CustomException;

import java.util.List;

public interface ComentarioService {
    List<Comentario> findAll() throws CustomException;

    Comentario findOne(int idPublicacion) throws CustomException;

    void insertComentario(Comentario comentario) throws CustomException;

    void updateComentario(Comentario comentario) throws CustomException;

    void deleteComentario(int idCometario) throws CustomException;
}
