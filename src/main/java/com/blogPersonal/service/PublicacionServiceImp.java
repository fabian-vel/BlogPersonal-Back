package com.blogPersonal.service;

import com.blogPersonal.dao.PublicacionDAO;
import com.blogPersonal.dto.Publicacion;
import com.blogPersonal.exception.ExceptionDAO;
import com.blogPersonal.exception.ExceptionService;
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
    public List<Publicacion> findAll() throws ExceptionService {
        List<Publicacion> publicacions;
        try {
            publicacions = publicacionDAO.getAll();
        }catch (ExceptionDAO e){
            throw new ExceptionService(e);
        }catch (Exception ex){
            throw new ExceptionService(ex);
        }
        return publicacions;
    }

    @Override
    public Publicacion findOne(int idPublicacion) throws ExceptionService {
        Publicacion publicacion;
        try {
            publicacion = publicacionDAO.getById(idPublicacion);
        }catch (ExceptionDAO e){
            throw new ExceptionService(e);
        }catch (Exception ex){
            throw new ExceptionService(ex);
        }
        return publicacion;
    }

    @Override
    public void insertPublicacion(Publicacion publicacion) throws ExceptionService {
        try {
            publicacionDAO.insert(publicacion);
        }catch (ExceptionDAO e){
            throw new ExceptionService(e);
        }catch (Exception ex){
            throw new ExceptionService(ex);
        }
    }

    @Override
    public void updatePublicacion(Publicacion publicacion) throws ExceptionService {
        try {
            publicacionDAO.update(publicacion);
        }catch (ExceptionDAO e){
            throw new ExceptionService(e);
        }catch (Exception ex){
            throw new ExceptionService(ex);
        }
    }

    @Override
    public void deletePublicacion(int idPublicacion) throws ExceptionService {
        try {
            publicacionDAO.delete(idPublicacion);
        }catch (ExceptionDAO e){
            throw new ExceptionService(e);
        }catch (Exception ex){
            throw new ExceptionService(ex);
        }
    }
}
