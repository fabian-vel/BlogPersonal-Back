package com.blogPersonal.dao;

import com.blogPersonal.dto.Categoria;
import com.blogPersonal.exception.ExceptionDAO;

import java.util.List;

public interface CategoriaDAO {
    List<Categoria> getAll() throws ExceptionDAO;

    Categoria getById(int idCategoria) throws ExceptionDAO;
}
