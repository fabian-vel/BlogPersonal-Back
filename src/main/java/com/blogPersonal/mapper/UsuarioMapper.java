package com.blogPersonal.mapper;

import com.blogPersonal.dto.Usuario;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioMapper implements RowMapper<Usuario> {
    @Override
    public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(rs.getInt("idUsuario"));
        usuario.setNombre(rs.getString("nombre"));
        usuario.setCorreo(rs.getString("correo"));
        usuario.setRutaImagen(rs.getString("rutaImagen"));
        return usuario;
    }
}
