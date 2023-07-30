package com.blogPersonal.dao;

import com.blogPersonal.dto.Categoria;
import com.blogPersonal.exception.CustomException;
import com.blogPersonal.mapper.CategoriaMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class CategoriaDAOImp implements CategoriaDAO{

    private static final String SELECT = "SELECT idcategoria, nombre FROM public.categoria";
    private static final String SELECTBYID = SELECT + " WHERE idcategoria = ?";

    JdbcTemplate jdbcTemplate;

    public CategoriaDAOImp(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Categoria> getAll() throws CustomException {
        List<Categoria> listCategoria;
        try {
            listCategoria = jdbcTemplate.query(SELECT, new CategoriaMapper());
        }catch (Exception e){
            throw new CustomException(e);
        }
        return listCategoria;
    }

    @Override
    public Categoria getById(int idCategoria) throws CustomException {
        Categoria categoria = null;
        try {
            categoria = jdbcTemplate.queryForObject(SELECTBYID, new CategoriaMapper(), idCategoria);
        } catch (EmptyResultDataAccessException ex) {

        } catch (Exception e){
            throw new CustomException(e);
        }
        return categoria;
    }
}
