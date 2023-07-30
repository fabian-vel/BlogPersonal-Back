package com.blogPersonal.service;

import com.blogPersonal.dto.Usuario;
import com.blogPersonal.exception.CustomException;

import java.util.List;

public interface UsuarioService {
    List<Usuario> findAll() throws CustomException;

    Usuario findOne(int idUsuario) throws CustomException;

    void insertUsiario(Usuario usuario) throws CustomException;

    void updateUsuario(Usuario usuario) throws  CustomException;

    void deleteUsuario(int idUsuario) throws CustomException;
}
