package com.blogPersonal.mapper;

import com.blogPersonal.dto.Publicacion;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PublicacionMapper implements RowMapper<Publicacion> {
    @Override
    public Publicacion mapRow(ResultSet rs, int rowNum) throws SQLException {
        Publicacion publicacion = new Publicacion();
        publicacion.setIdPublicacion(rs.getInt("idPublicacion"));
        publicacion.setIdUsuario(rs.getInt("idUsuario"));
        publicacion.setIdCategoria(rs.getInt("idCategoria"));
        publicacion.setTitulo(rs.getString("titulo"));
        publicacion.setContenido(rs.getString("contenido"));
        publicacion.setFachaPublicacion(rs.getDate("fachaPublicacion"));
        return publicacion;
    }
}
