package com.blogPersonal.dao;

import com.blogPersonal.dto.Categoria;
import com.blogPersonal.exception.CustomException;

import java.util.List;

public interface CategoriaDAO {
    List<Categoria> getAll() throws CustomException;

    Categoria getById(int idCategoria) throws CustomException;
}
