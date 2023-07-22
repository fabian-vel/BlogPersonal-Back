package com.blogPersonal.dao;

import com.blogPersonal.dto.Publicacion;
import com.blogPersonal.exception.ExceptionDAO;

import java.util.List;

public interface PublicacionDAO {
    List<Publicacion> getAll() throws ExceptionDAO;

    Publicacion getById(int idPublicacion) throws ExceptionDAO;

    void insert(Publicacion publicacion) throws ExceptionDAO;

    void update(Publicacion publicacion) throws ExceptionDAO;

    void delete(int idPublicacion) throws ExceptionDAO;
}
