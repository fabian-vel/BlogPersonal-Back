package com.blogPersonal.service;

import com.blogPersonal.dto.Categoria;
import com.blogPersonal.exception.ExceptionService;

import java.util.List;

public interface CategoriaService {
    List<Categoria> findAll() throws ExceptionService;

    Categoria findOne(int idCategoria) throws ExceptionService;
}
