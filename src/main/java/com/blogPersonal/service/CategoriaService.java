package com.blogPersonal.service;

import com.blogPersonal.dto.Categoria;
import com.blogPersonal.exception.CustomException;

import java.util.List;

public interface CategoriaService {
    List<Categoria> findAll() throws CustomException;

    Categoria findOne(int idCategoria) throws CustomException;
}
