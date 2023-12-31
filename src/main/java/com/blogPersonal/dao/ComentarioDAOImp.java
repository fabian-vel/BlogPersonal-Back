package com.blogPersonal.dao;

import com.blogPersonal.exception.CustomException;
import com.blogPersonal.mapper.ComentarioMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.blogPersonal.dto.Comentario;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class ComentarioDAOImp implements ComentarioDAO {

    private static final String SELECT = "SELECT idcomentario, usuario_idusuario AS idusuario, " +
            "publicacion_idpublicacion AS idpublicacion, categoria_idcategoria AS idcategoria, " +
            "contenido, fechacomentario " +
            "FROM comentario;";
    private static final String SELECTBYPUBLIC = SELECT +" WHERE publicacion_idpublicacion = ?";
    private static final String INSERT = "INSERT INTO comentario(" +
            "usuario_idusuario, publicacion_idpublicacion, categoria_idcategoria, " +
            "contenido, fechacomentario)" +
            "VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE comentario SET usuario_idusuario=?, " +
            "publicacion_idpublicacion=?, categoria_idcategoria=?, " +
            "contenido=?, fechacomentario=? " +
            "WHERE idcomentario=?";
    private static final String DELETE = "DELETE FROM comentario WHERE  idcomentario=?";

    JdbcTemplate jdbcTemplate;

    public ComentarioDAOImp(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Comentario> getAll() throws CustomException {
        List<Comentario> listComentario;
        try {
            listComentario = jdbcTemplate.query(SELECT, new ComentarioMapper());
        }catch (Exception e){
            throw new CustomException(e);
        }
        return listComentario;
    }

    @Override
    public Comentario getByPublication(int idPublicacion) throws CustomException {
        Comentario comentario = new Comentario();
        try {
            comentario = jdbcTemplate.queryForObject(SELECTBYPUBLIC, new ComentarioMapper(), idPublicacion);
        }catch (EmptyResultDataAccessException e){

        }catch (Exception ex){
            throw new CustomException(ex);
        }
        return comentario;
    }

    @Override
    public void insert(Comentario comentario) throws CustomException {
        try {
            jdbcTemplate.update(INSERT,
                    comentario.getIdUsuario(),
                    comentario.getIdPublicacion(),
                    comentario.getContenido(),
                    comentario.getFechaComentario()
            );
        }catch (Exception e){
            throw new CustomException(e);
        }
    }

    @Override
    public void update(Comentario comentario) throws CustomException {
        try {
            jdbcTemplate.update(UPDATE,
                    comentario.getIdUsuario(),
                    comentario.getIdPublicacion(),
                    comentario.getContenido(),
                    comentario.getFechaComentario(),
                    comentario.getIdComentario()
            );
        }catch (Exception e){
            throw new CustomException(e);
        }
    }

    @Override
    public void delete(int idComentario) throws CustomException {
        try {
            jdbcTemplate.update(DELETE, idComentario);
        }catch (Exception e){
            throw new CustomException(e);
        }
    }
}
