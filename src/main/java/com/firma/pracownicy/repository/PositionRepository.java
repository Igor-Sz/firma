package com.firma.pracownicy.repository;

import com.firma.pracownicy.domain.Position;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public interface PositionRepository {

    public List<Position> pullPositions();
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate);
}
