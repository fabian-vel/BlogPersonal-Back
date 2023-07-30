package com.blogPersonal.service;

import com.blogPersonal.dao.UsuarioDAO;
import com.blogPersonal.dto.Usuario;
import com.blogPersonal.exception.CustomException;
import com.blogPersonal.util.MessagesConstant;
import org.springframework.core.codec.CodecException;
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
    public List<Usuario> findAll() throws CustomException {
        List<Usuario> usuarios;
        try {
            usuarios = usuarioDAO.getAll();
        }catch (CustomException e){
            throw e;
        }catch (Exception ex){
            throw new CustomException(ex);
        }
        return usuarios;
    }

    @Override
    public Usuario findOne(int idUsuario) throws CustomException {
        Usuario usuario;
        try {
            usuario = usuarioDAO.getById(idUsuario);
            if (usuario == null){
                throw new CustomException(String.format(MessagesConstant.ENTITY_NOT_EXISTS, "Usuario"));
            }
        }catch (CustomException e){
            throw e;
        }catch (Exception ex){
            throw new CustomException(ex);
        }
        return usuario;
    }

    @Override
    public void insertUsiario(Usuario usuario) throws CustomException {
        Usuario usuarioExistente = usuarioDAO.getById(usuario.getIdusuario());
        if (usuarioExistente != null){
            throw new CustomException(String.format(MessagesConstant.ENTITY_ALREADY_EXISTS, "Usuario"));
        }
        try {
            usuarioDAO.insert(usuario);
        }catch (CustomException e){
            throw e;
        }catch (Exception ex){
            throw new CustomException(ex);
        }
    }

    @Override
    public void updateUsuario(Usuario usuario) throws CustomException {
        Usuario usuarioExistente = usuarioDAO.getById(usuario.getIdusuario());
        if (usuarioExistente == null){
            throw new CodecException(String.format(MessagesConstant.ENTITY_NOT_EXISTS, "Usuario"));
        }
        try {
            usuarioDAO.update(usuario);
        }catch (CustomException e){
            throw e;
        }catch (Exception ex){
            throw new CustomException(ex);
        }
    }

    @Override
    public void deleteUsuario(int idUsuario) throws CustomException {
        Usuario usuarioExistente = usuarioDAO.getById(idUsuario);
        if (usuarioExistente == null){
            throw new CustomException(String.format(MessagesConstant.ENTITY_NOT_EXISTS, "Usuario"));
        }
        try {
            usuarioDAO.delete(idUsuario);
        }catch (CustomException e){
            throw e;
        }catch (Exception ex){
            throw new CustomException(ex);
        }
    }
}
