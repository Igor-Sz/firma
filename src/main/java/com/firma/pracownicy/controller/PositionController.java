package com.firma.pracownicy.controller;

import java.sql.SQLException;
import java.util.*;

import com.firma.pracownicy.domain.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.firma.pracownicy.service.PositionService;


@Controller
public class PositionController {
    @Autowired
    private PositionService positionService;

    @RequestMapping(value = "/positions", method = RequestMethod.GET)
    public @ResponseBody List<Position> pullEmployees() throws SQLException{
        return positionService.pullPositions();
    }
}