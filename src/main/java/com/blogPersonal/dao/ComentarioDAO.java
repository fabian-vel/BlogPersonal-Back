package com.blogPersonal.dao;

import com.blogPersonal.dto.Comentario;
import com.blogPersonal.exception.ExceptionDAO;

import java.util.List;

public interface ComentarioDAO {
    List<Comentario> getAll() throws ExceptionDAO;

    Comentario getByPublication(int idPublicacion) throws ExceptionDAO;

    void insert(Comentario comentario) throws ExceptionDAO;

    void update(Comentario comentario) throws ExceptionDAO;

    void delete(int idComentario) throws ExceptionDAO;
}
