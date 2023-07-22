package com.blogPersonal.service;

import com.blogPersonal.dao.UsuarioDAO;
import com.blogPersonal.dto.Usuario;
import com.blogPersonal.exception.ExceptionDAO;
import com.blogPersonal.exception.ExceptionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UsuarioServiceImp implements UsuarioService {

    private final UsuarioDAO usuarioDAO;

    public UsuarioServiceImp(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    @Override
    public List<Usuario> findAll() throws ExceptionService {
        List<Usuario> usuarios;
        try {
            usuarios = usuarioDAO.getAll();
        }catch (ExceptionDAO e){
            throw new ExceptionService(e);
        }catch (Exception ex){
            throw new ExceptionService(ex);
        }
        return usuarios;
    }

    @Override
    public Usuario findOne(int idUsuario) throws ExceptionService {
        Usuario usuario;
        try {
            usuario = usuarioDAO.getById(idUsuario);
        }catch (ExceptionDAO e){
            throw new ExceptionService(e);
        }catch (Exception ex){
            throw new ExceptionService(ex);
        }
        return usuario;
    }

    @Override
    public void insertUsiario(Usuario usuario) throws ExceptionService {
        try {
            usuarioDAO.insert(usuario);
        }catch (ExceptionDAO e){
            throw new ExceptionService(e);
        }catch (Exception ex){
            throw new ExceptionService(ex);
        }
    }

    @Override
    public void updateUsuario(Usuario usuario) throws ExceptionService {
        try {
            usuarioDAO.update(usuario);
        }catch (ExceptionDAO e){
            throw new ExceptionService(e);
        }catch (Exception ex){
            throw new ExceptionService(ex);
        }
    }

    @Override
    public void deleteUsuario(int idUsuario) throws ExceptionService {
        try {
            usuarioDAO.delete(idUsuario);
        }catch (ExceptionDAO e){
            throw new ExceptionService(e);
        }catch (Exception ex){
            throw new ExceptionService(ex);
        }
    }
}
