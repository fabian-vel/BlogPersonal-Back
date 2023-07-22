package com.blogPersonal.service;

import com.blogPersonal.dto.Publicacion;
import com.blogPersonal.exception.ExceptionService;

import java.util.List;

public interface PublicacionService {
    List<Publicacion> findAll() throws ExceptionService;

    Publicacion findOne(int idPublicacion) throws ExceptionService;

    void insertPublicacion(Publicacion publicacion) throws ExceptionService;

    void updatePublicacion(Publicacion publicacion) throws ExceptionService;

    void deletePublicacion(int idPublicacion) throws ExceptionService;
}
