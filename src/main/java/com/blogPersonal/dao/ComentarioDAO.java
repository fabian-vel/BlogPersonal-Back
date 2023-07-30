package com.blogPersonal.dao;

import com.blogPersonal.dto.Comentario;
import com.blogPersonal.exception.CustomException;

import java.util.List;

public interface ComentarioDAO {
    List<Comentario> getAll() throws CustomException;

    Comentario getByPublication(int idPublicacion) throws CustomException;

    void insert(Comentario comentario) throws CustomException;

    void update(Comentario comentario) throws CustomException;

    void delete(int idComentario) throws CustomException;
}
