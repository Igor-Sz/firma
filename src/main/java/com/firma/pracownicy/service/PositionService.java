package com.firma.pracownicy.service;

import com.firma.pracownicy.domain.Position;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.*;

public interface PositionService {

    public List<Position> pullPositions();
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate);
}
