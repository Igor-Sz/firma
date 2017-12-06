package com.firma.pracownicy.repository.impl;

import com.firma.pracownicy.domain.Employee;
import com.firma.pracownicy.domain.Position;
import com.firma.pracownicy.repository.PositionRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PositionRepositoryImpl implements PositionRepository{

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Position> pullPositions() {
        String sqlquery="SELECT E.POSNO, COUNT(E.POSNO), P.POSNAME FROM POS P INNER JOIN EMP E USING (POSNO) GROUP BY E.POSNO order by E.POSNO";
        List<Position> listPosition = jdbcTemplate.query(sqlquery, new RowMapper<Position>() {

            public Position mapRow(ResultSet result, int rowNum) throws SQLException {
                Position pos = new Position();
                pos.setID((result.getInt(1)));
                pos.setName(result.getString(3));
                pos.setPeople(result.getInt(2));
                return pos;
            }
        });
        return listPosition;
    }
}
