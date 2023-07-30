package com.blogPersonal.dao;

import com.blogPersonal.dto.Usuario;
import com.blogPersonal.exception.CustomException;
import com.blogPersonal.mapper.UsuarioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class UsuarioDAOImp implements UsuarioDAO{
    private static final String SELECT = "SELECT idusuario, nombre, correo, rutaimagen FROM usuario";
    private static final String SELECTBYID = SELECT + " WHERE idusuario = ?";
    private static final String INSERT = "INSERT INTO usuario(nombre, correo, rutaimagen) VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE usuario SET nombre = ?, correo = ?, rutaimagen = ? WHERE idusuario = ?";
    private static final String DELETE = "DELETE FROM usuario WHERE idusuario = ?";

    JdbcTemplate jdbcTemplate;

    @Autowired
    public UsuarioDAOImp(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Usuario> getAll() throws CustomException {
        List<Usuario> listUsuarios;
        try {
            listUsuarios = jdbcTemplate.query(SELECT, new UsuarioMapper());
        }catch (Exception e){
            throw new CustomException(e);
        }
        return listUsuarios;
    }

    @Override
    public Usuario getById(int idUsuario) throws CustomException {
        Usuario usuario = null;
        try {
            usuario = jdbcTemplate.queryForObject(SELECTBYID, new UsuarioMapper(), idUsuario);
        }catch (EmptyResultDataAccessException e){

        }
        catch (Exception ex){
            throw new CustomException(ex);
        }
        return usuario;
    }

    @Override
    public void insert(Usuario usuario) throws CustomException {
        try {
            jdbcTemplate.update(INSERT,
                    usuario.getNombre(),
                    usuario.getCorreo(),
                    usuario.getRutaimagen()
            );
        }catch (Exception e){
            throw new CustomException(e);
        }

    }

    @Override
    public void update(Usuario usuario) throws CustomException {
        try {
            jdbcTemplate.update(UPDATE,
                    usuario.getNombre(),
                    usuario.getCorreo(),
                    usuario.getRutaimagen(),
                    usuario.getIdusuario()
            );
        }catch (Exception e){
            throw new CustomException(e);
        }
    }

    @Override
    public void delete(int idUsuario) throws CustomException {
        try {
            jdbcTemplate.update(DELETE, idUsuario);
        }catch (Exception e){
            throw new CustomException(e);
        }
    }
}
