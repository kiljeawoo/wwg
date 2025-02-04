package com.project.wwg.plan.service;

import com.project.wwg.plan.dao.MybatisSpotsDao;
import com.project.wwg.plan.dao.SpotsDao;
import com.project.wwg.plan.dto.Spot;
import org.apache.ibatis.session.SqlSession;
import org.json.simple.parser.JSONParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@Transactional
class SpotsServiceImplTest {
    private static final Logger logger = LoggerFactory.getLogger(SpotsServiceImplTest.class);
    ApplicationContext ac = new GenericXmlApplicationContext("root-context.xml");

    private SpotsDao spotsDao;
    private final JSONParser parser = new JSONParser();
    private List<Spot> spots;

    @BeforeEach
    void beforeEach() {
        spotsDao = ac.getBean(MybatisSpotsDao.class);
    }

    @Test
    @DisplayName("정상적인 Spot 1개 등록")
    void insertSpot() {
        Spot spot = new Spot("title", "info", 123, 123, "address", "photo", "phone");
        int result = spotsDao.insertSpot(spot);
        assertThat(result).isEqualTo(1);
        logger.debug("Result : {}, Spot : {}", result, spot);
    }

    @Test
    @DisplayName("제목이 없는 Spot 1개 등록은 데이터 무결성 위배 예외가 발생해야 한다")
    void insertNoneTitleSpot() {
        Spot spot = new Spot("", "info", 123, 123, "address", "photo", "phone");
        assertThrows(DataIntegrityViolationException.class, () -> spotsDao.insertSpot(spot));
        logger.debug("Spot : {}", spot);
    }


    @Test
    @DisplayName("정상적인 Spot 여러개 등록")
    void insertSpots() {
        List<Spot> spots = new ArrayList<Spot>();
        spots.add(new Spot("title1", "info", 123, 123, "address", "photo", "phone"));
        spots.add(new Spot("title2", "info", 123, 123, "address", "photo", "phone"));
        spots.add(new Spot("title3", "info", 123, 123, "address", "photo", "phone"));
        int result = spotsDao.insertSpots(spots);
        assertThat(result).isEqualTo(3);
        logger.debug("Result : {}, Spots : {}", result, spots);
    }
}