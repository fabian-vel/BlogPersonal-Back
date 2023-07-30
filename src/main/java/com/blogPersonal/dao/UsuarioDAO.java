package com.blogPersonal.dao;

import com.blogPersonal.dto.Usuario;
import com.blogPersonal.exception.CustomException;

import java.util.List;

public interface UsuarioDAO {
    List<Usuario> getAll() throws CustomException;

    Usuario getById(int idUsuario) throws CustomException;

    void insert(Usuario usuario) throws CustomException;

    void update(Usuario usuario) throws CustomException;

    void delete(int idUsuario) throws CustomException;
}
