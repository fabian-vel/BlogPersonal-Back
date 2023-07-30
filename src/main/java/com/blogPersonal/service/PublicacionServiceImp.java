package com.blogPersonal.service;

import com.blogPersonal.dao.PublicacionDAO;
import com.blogPersonal.dto.Publicacion;
import com.blogPersonal.exception.CustomException;
import com.blogPersonal.util.MessagesConstant;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PublicacionServiceImp implements PublicacionService {

    private final PublicacionDAO publicacionDAO;

    public PublicacionServiceImp(PublicacionDAO publicacionDAO) {
        this.publicacionDAO = publicacionDAO;
    }

    @Override
    public List<Publicacion> findAll() throws CustomException {
        List<Publicacion> publicacions;
        try {
            publicacions = publicacionDAO.getAll();
        }catch (CustomException e){
            throw e;
        }catch (Exception ex){
            throw new CustomException(ex);
        }
        return publicacions;
    }

    @Override
    public Publicacion findOne(int idPublicacion) throws CustomException {
        Publicacion publicacion;
        try {
            publicacion = publicacionDAO.getById(idPublicacion);
            if(publicacion == null){
                throw new CustomException(String.format(MessagesConstant.ENTITY_NOT_EXISTS, "Publicacion"));
            }
        }catch (CustomException e){
            throw e;
        }catch (Exception ex){
            throw new CustomException(ex);
        }
        return publicacion;
    }

    @Override
    public void insertPublicacion(Publicacion publicacion) throws CustomException {
        Publicacion publicacionExistente = publicacionDAO.getById(publicacion.getIdPublicacion());
        if (publicacionExistente != null){
            throw new CustomException(String.format(MessagesConstant.ENTITY_ALREADY_EXISTS, "Publicacion"));
        }
        try {
            publicacionDAO.insert(publicacion);
        }catch (CustomException e){
            throw e;
        }catch (Exception ex){
            throw new CustomException(ex);
        }
    }

    @Override
    public void updatePublicacion(Publicacion publicacion) throws CustomException {
        Publicacion publicacionExistente = publicacionDAO.getById(publicacion.getIdPublicacion());
        if (publicacionExistente == null){
            throw new CustomException(String.format(MessagesConstant.ENTITY_NOT_EXISTS, "Publicacion"));
        }
        try {
            publicacionDAO.update(publicacion);
        }catch (CustomException e){
            throw e;
        }catch (Exception ex){
            throw new CustomException(ex);
        }
    }

    @Override
    public void deletePublicacion(int idPublicacion) throws CustomException {
        Publicacion publicacionExistente = publicacionDAO.getById(idPublicacion);
        if (publicacionExistente == null){
            throw new CustomException(String.format(MessagesConstant.ENTITY_NOT_EXISTS, "Publicacion"));
        }
        try {
            publicacionDAO.delete(idPublicacion);
        }catch (CustomException e){
            throw e;
        }catch (Exception ex){
            throw new CustomException(ex);
        }
    }
}
