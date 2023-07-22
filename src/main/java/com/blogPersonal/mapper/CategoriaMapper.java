package com.blogPersonal.mapper;

import com.blogPersonal.dto.Categoria;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoriaMapper implements RowMapper<Categoria> {

    @Override
    public Categoria mapRow(ResultSet rs, int rowNum) throws SQLException {
        Categoria categoria = new Categoria();
        categoria.setIdCategoria(rs.getInt("idcategoria"));
        categoria.setNombre(rs.getString("nombre"));
        return categoria;
    }
}
