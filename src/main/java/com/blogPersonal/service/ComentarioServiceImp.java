package com.blogPersonal.service;

import com.blogPersonal.dao.ComentarioDAO;
import com.blogPersonal.dto.Comentario;
import com.blogPersonal.exception.ExceptionDAO;
import com.blogPersonal.exception.ExceptionService;
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
    public List<Comentario> findAll() throws ExceptionService {
        List<Comentario> comentarios;
        try {
            comentarios = comentarioDAO.getAll();
        }catch (ExceptionDAO e){
            throw new ExceptionService(e);
        }catch (Exception ex){
            throw new ExceptionService(ex);
        }
        return comentarios;
    }

    @Override
    public Comentario findOne(int idPublicacion) throws ExceptionService {
        Comentario comentario;
        try {
            comentario = comentarioDAO.getByPublication(idPublicacion);
        }catch (ExceptionDAO e){
            throw new ExceptionService(e);
        }catch (Exception ex){
            throw new ExceptionService(ex);
        }
        return comentario;
    }

    @Override
    public void insertComentario(Comentario comentario) throws ExceptionService {
        try {
            comentarioDAO.insert(comentario);
        }catch (ExceptionDAO e){
            throw new ExceptionService(e);
        }catch (Exception ex){
            throw new ExceptionService(ex);
        }
    }

    @Override
    public void updateComentario(Comentario comentario) throws ExceptionService {
        try {
            comentarioDAO.update(comentario);
        }catch (ExceptionDAO e){
            throw new ExceptionService(e);
        }catch (Exception ex){
            throw new ExceptionService(ex);
        }
    }

    @Override
    public void deleteComentario(int idCometario) throws ExceptionService {
        try {
            comentarioDAO.delete(idCometario);
        }catch (ExceptionDAO e){
            throw new ExceptionService(e);
        }catch (Exception ex){
            throw new ExceptionService(ex);
        }
    }
}
