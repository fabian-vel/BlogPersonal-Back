package com.blogPersonal.dao;

import com.blogPersonal.dto.Publicacion;
import com.blogPersonal.exception.CustomException;

import java.util.List;

public interface PublicacionDAO {
    List<Publicacion> getAll() throws CustomException;

    Publicacion getById(int idPublicacion) throws CustomException;

    void insert(Publicacion publicacion) throws CustomException;

    void update(Publicacion publicacion) throws CustomException;

    void delete(int idPublicacion) throws CustomException;
}
