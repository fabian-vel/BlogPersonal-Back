package com.blogPersonal.service;

import com.blogPersonal.dao.ComentarioDAO;
import com.blogPersonal.dto.Comentario;
import com.blogPersonal.exception.CustomException;
import com.blogPersonal.util.MessagesConstant;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ComentarioServiceImp implements ComentarioService {

    private final ComentarioDAO comentarioDAO;

    public ComentarioServiceImp(ComentarioDAO comentarioDAO) {
        this.comentarioDAO = comentarioDAO;
    }

    @Override
    public List<Comentario> findAll() throws CustomException {
        List<Comentario> comentarios;
        try {
            comentarios = comentarioDAO.getAll();
        }catch (CustomException e){
            throw e;
        }catch (Exception ex){
            throw new CustomException(ex);
        }
        return comentarios;
    }

    @Override
    public Comentario findOne(int idPublicacion) throws CustomException {
        Comentario comentario;
        try {
            comentario = comentarioDAO.getByPublication(idPublicacion);
            if(comentario == null) {
                throw new CustomException(String.format(MessagesConstant.ENTITY_NOT_EXISTS,"Usuario"));
            }
        }catch (CustomException e){
            throw e;
        }catch (Exception ex){
            throw new CustomException(ex);
        }
        return comentario;
    }

    @Override
    public void insertComentario(Comentario comentario) throws CustomException {
        Comentario comentarioExistente = comentarioDAO.getByPublication(comentario.getIdPublicacion());
        if (comentarioExistente != null){
            throw new CustomException(String.format(MessagesConstant.ENTITY_ALREADY_EXISTS, "Comentario"));
        }
        try {
            comentarioDAO.insert(comentario);
        }catch (CustomException e){
            throw e;
        }catch (Exception ex){
            throw new CustomException(ex);
        }
    }

    @Override
    public void updateComentario(Comentario comentario) throws CustomException {
        Comentario comentarioExistente = comentarioDAO.getByPublication(comentario.getIdPublicacion());
        if (comentarioExistente == null){
            throw new CustomException(String.format(MessagesConstant.ENTITY_NOT_EXISTS, "Comentario"));
        }
        try {
            comentarioDAO.update(comentario);
        }catch (CustomException e){
            throw e;
        }catch (Exception ex){
            throw new CustomException(ex);
        }
    }

    @Override
    public void deleteComentario(int idCometario) throws CustomException {
        Comentario comentarioExistente = comentarioDAO.getByPublication(idCometario);
        if (comentarioExistente == null){
            throw new CustomException(String.format(MessagesConstant.ENTITY_NOT_EXISTS, "Comentario"));
        }
        try {
            comentarioDAO.delete(idCometario);
        }catch (CustomException e){
            throw e;
        }catch (Exception ex){
            throw new CustomException(ex);
        }
    }
}
