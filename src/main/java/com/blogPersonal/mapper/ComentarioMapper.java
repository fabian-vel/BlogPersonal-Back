package com.blogPersonal.mapper;

import com.blogPersonal.dto.Comentario;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ComentarioMapper implements RowMapper<Comentario> {
    @Override
    public Comentario mapRow(ResultSet rs, int rowNum) throws SQLException {
        Comentario comentario = new Comentario();
        comentario.setIdComentario(rs.getInt("idComentario"));
        comentario.setIdUsuario(rs.getInt("idUsuario"));
        comentario.setIdPublicacion(rs.getInt("idPublicacion"));
        comentario.setContenido(rs.getString("contenido"));
        comentario.setFechaComentario(rs.getDate("fechaComentario"));
        return comentario;
    }
}
