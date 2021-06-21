package proyectoSANA.dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import proyectoSANA.model.Municipio;
import proyectoSANA.model.Zona;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ZonaDao {

    private JdbcTemplate jdbcTemplate;
    private AreaDao areaDao;

    // Obté el jdbcTemplate a partir del Data Source
    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /* Afegeix el municipio a la base de dades */
    public void addZona(Zona zona) {
        jdbcTemplate.update("INSERT INTO Zona VALUES(?, ?)",
                zona.getNumero(), zona.getArea());
//        areaDao.getArea(zona.getArea()).setZonaList(areaDao.getArea(zona.getArea()).getZonaList()+","+zona.getNumero());
//        System.out.println(areaDao.getArea(zona.getArea()).getZonaList());
    }

    public void deleteZona(String numero) {
        jdbcTemplate.update("DELETE FROM Zona WHERE numero = ?",
                numero);
    }


    public void deleteZona(Zona zona) {
        jdbcTemplate.update("DELETE FROM Zona WHERE numero = ?",
                zona.getNumero());
    }

    public Zona getZona(String numeroZona) {
        try {
            return jdbcTemplate.queryForObject(
                    "SELECT * FROM Zona WHERE numero =?",
                    new ZonaRowMapper(),
                    numeroZona);
        }
        catch(EmptyResultDataAccessException e) {
            return null;
        }
    }

    public List<Zona> getZonas() {
        try {
            return jdbcTemplate.query("SELECT * FROM Zona", new ZonaRowMapper());
        }
        catch(EmptyResultDataAccessException e) {
            return new ArrayList<>();
        }
    }
}
