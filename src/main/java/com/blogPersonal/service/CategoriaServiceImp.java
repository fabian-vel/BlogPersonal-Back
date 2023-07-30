package com.blogPersonal.service;

import com.blogPersonal.dao.CategoriaDAO;
import com.blogPersonal.dto.Categoria;
import com.blogPersonal.exception.CustomException;
import com.blogPersonal.util.MessagesConstant;
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
    public List<Categoria> findAll() throws CustomException {
        List<Categoria> categorias;
        try {
            categorias = categoriaDAO.getAll();
        }catch (CustomException e){
            throw e;
        }catch (Exception ex){
            throw new CustomException(ex);
        }
        return categorias;
    }

    @Override
    public Categoria findOne(int idCategoria) throws CustomException {
        Categoria categoria;
        try {
            categoria = categoriaDAO.getById(idCategoria);
            if (categoria == null){
                throw new CustomException(String.format(MessagesConstant.ENTITY_NOT_EXISTS, "Categoria"));
            }
        }catch (CustomException e){
            throw e;
        }catch (Exception ex){
            throw new CustomException(ex);
        }
        return categoria;
    }
}
