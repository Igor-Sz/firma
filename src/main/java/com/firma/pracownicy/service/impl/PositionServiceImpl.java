package com.firma.pracownicy.service.impl;

import com.firma.pracownicy.domain.Position;
import com.firma.pracownicy.repository.PositionRepository;
import com.firma.pracownicy.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PositionServiceImpl implements PositionService{
    @Autowired
    private PositionRepository positionRepository;

    @Override
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        positionRepository.setJdbcTemplate(jdbcTemplate);
    }

    @Override
    public List<Position> pullPositions() {
        return positionRepository.pullPositions();
    }


}
