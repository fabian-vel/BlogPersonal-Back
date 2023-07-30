package com.blogPersonal.service;

import com.blogPersonal.dto.Publicacion;
import com.blogPersonal.exception.CustomException;

import java.util.List;

public interface PublicacionService {
    List<Publicacion> findAll() throws CustomException;

    Publicacion findOne(int idPublicacion) throws CustomException;

    void insertPublicacion(Publicacion publicacion) throws CustomException;

    void updatePublicacion(Publicacion publicacion) throws CustomException;

    void deletePublicacion(int idPublicacion) throws CustomException;
}
