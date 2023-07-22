package com.blogPersonal.service;

import com.blogPersonal.dao.CategoriaDAO;
import com.blogPersonal.dto.Categoria;
import com.blogPersonal.exception.ExceptionDAO;
import com.blogPersonal.exception.ExceptionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CategoriaServiceImp implements CategoriaService {

    private CategoriaDAO categoriaDAO;

    public CategoriaServiceImp(CategoriaDAO categoriaDAO) {
        this.categoriaDAO = categoriaDAO;
    }

    @Override
    public List<Categoria> findAll() throws ExceptionService {
        List<Categoria> categorias;
        try {
            categorias = categoriaDAO.getAll();
        }catch (ExceptionDAO e){
            throw new ExceptionService(e);
        }catch (Exception ex){
            throw new ExceptionService(ex);
        }
        return categorias;
    }

    @Override
    public Categoria findOne(int idCategoria) throws ExceptionService {
        Categoria categoria;
        try {
            categoria = categoriaDAO.getById(idCategoria);
        }catch (ExceptionDAO e){
            throw new ExceptionService(e);
        }catch (Exception ex){
            throw new ExceptionService(ex);
        }
        return categoria;
    }
}
