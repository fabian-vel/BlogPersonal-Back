package com.blogPersonal.service;

import com.blogPersonal.dto.Usuario;
import com.blogPersonal.exception.ExceptionService;

import java.util.List;

public interface UsuarioService {
    List<Usuario> findAll() throws ExceptionService;

    Usuario findOne(int idUsuario) throws ExceptionService;

    void insertUsiario(Usuario usuario) throws ExceptionService;

    void updateUsuario(Usuario usuario) throws ExceptionService;

    void deleteUsuario(int idUsuario) throws ExceptionService;
}
