package com.blogPersonal.dao;

import com.blogPersonal.dto.Publicacion;
import com.blogPersonal.exception.ExceptionDAO;
import com.blogPersonal.mapper.PublicacionMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class PublicacionDAOImp implements PublicacionDAO {

    private static final String SELECT = "SELECT idpublicacion, usuario_idusuario AS idusuario, " +
            "categoria_idcategoria AS idcategoria, titulo, contenido, fechapublicacion " +
            "FROM publicacion";
    private static final String SELECTBYID = SELECT+" WHERE idpublicacion = ?";
    private static final String INSERT = "INSERT INTO publicacion(" +
            "usuario_idusuario, categoria_idcategoria, titulo, contenido, fechapublicacion) " +
            "VALUES (?, ?, ?, ?, ?);";
    private static final String UPDATE = "UPDATE publicacion " +
            "SET usuario_idusuario=?, categoria_idcategoria=?, titulo=?, contenido=?, fechapublicacion=? " +
            "WHERE idpublicacion=?";
    private static final String DELETE = "DELETE FROM publicacion WHERE idpublicacion=?";

    JdbcTemplate jdbcTemplate;

    public PublicacionDAOImp(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Publicacion> getAll() throws ExceptionDAO {
        List<Publicacion> listPublicacion;
        try {
            listPublicacion = jdbcTemplate.query(SELECT, new PublicacionMapper());
        }catch (Exception e){
            throw new ExceptionDAO(e);
        }
        return listPublicacion;
    }

    @Override
    public Publicacion getById(int idPublicacion) throws ExceptionDAO {
        Publicacion publicacion = null;
        try {
            publicacion = jdbcTemplate.queryForObject(SELECTBYID, new PublicacionMapper(), idPublicacion);
        }catch (EmptyResultDataAccessException e){

        }catch (Exception ex){
            throw new ExceptionDAO(ex);
        }
        return publicacion;
    }

    @Override
    public void insert(Publicacion publicacion) throws ExceptionDAO {
        try {
            jdbcTemplate.update(INSERT,
                    publicacion.getIdUsuario(),
                    publicacion.getIdCategoria(),
                    publicacion.getTitulo(),
                    publicacion.getContenido(),
                    publicacion.getFachaPublicacion()
            );
        }catch (Exception e){
            throw new ExceptionDAO(e);
        }
    }

    @Override
    public void update(Publicacion publicacion) throws ExceptionDAO {
        try {
            jdbcTemplate.update(UPDATE,
                    publicacion.getIdUsuario(),
                    publicacion.getIdCategoria(),
                    publicacion.getTitulo(),
                    publicacion.getContenido(),
                    publicacion.getFachaPublicacion(),
                    publicacion.getIdPublicacion()
            );
        }catch (Exception e){
            throw new ExceptionDAO(e);
        }
    }

    @Override
    public void delete(int idPublicacion) throws ExceptionDAO {
        try {
            jdbcTemplate.update(DELETE, idPublicacion);
        }catch (Exception e){
            throw new ExceptionDAO(e);
        }
    }
}
