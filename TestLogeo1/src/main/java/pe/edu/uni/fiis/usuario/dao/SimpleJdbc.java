package pe.edu.uni.fiis.usuario.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Created by furiusus on 6/27/17.
 */
public class SimpleJdbc {
    @Autowired
    @Qualifier(value="dataSource")
    private DataSource dataSource;
    @Autowired
    @Qualifier(value="jdbcTemplate")
    private JdbcTemplate jdbcTemplate;
    public SimpleJdbc(DataSource dataSource,JdbcTemplate jdbcTemplate){
        this.dataSource=dataSource;
        this.jdbcTemplate=jdbcTemplate;
        this.jdbcTemplate.setDataSource(dataSource);
    }

    public SimpleJdbc() {

    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}