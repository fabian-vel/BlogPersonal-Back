package com.blogPersonal.dao;

import com.blogPersonal.dto.Usuario;
import com.blogPersonal.exception.ExceptionDAO;

import java.util.List;

public interface UsuarioDAO {
    List<Usuario> getAll() throws ExceptionDAO;

    Usuario getById(int idUsuario) throws ExceptionDAO;

    void insert(Usuario usuario) throws ExceptionDAO;

    void update(Usuario usuario) throws ExceptionDAO;

    void delete(int idUsuario) throws ExceptionDAO;
}
