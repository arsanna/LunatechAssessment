package com.lunatech.assessment.dao;

import com.lunatech.assessment.dto.CountryAirportDto;
import com.lunatech.assessment.dto.TopRunWayIdentsDto;
import com.lunatech.assessment.model.Airport;
import com.lunatech.assessment.model.Country;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.Query;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by User on 05/29/2017.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ReportDaoTest {

    @Autowired
    private TestEntityManager entityManager;

    @TestConfiguration
    static class ReportDaoTestConfiguration {
        @Bean
        public ReportDao reportDao() {
            return new ReportDao();
        }
    }

    @Autowired
    private ReportDao reportDao;

    private final static int GET_MAX_COUNTRY = 10;
    private final static int GET_MIN_COUNTRY = 10;
    private final static int GET_RUNWAY_TYPE = 237;
    private final static int GET_TOP_RUNWAY_IDENTS = 10;

    @Test
    public void getHightestCountry() {
        List<CountryAirportDto> result = reportDao.getHightestCountry();
        assertEquals(GET_MAX_COUNTRY, result.size());
    }

    @Test
    public void getLowestCountry() {
        List<CountryAirportDto> result = reportDao.getLowestCountry();
        assertEquals(GET_MIN_COUNTRY, result.size());
    }

    @Test
    public void getRunwayTypes() {
        Map<Country, List<String>> result = reportDao.getRunwayTypes();
        assertEquals(GET_RUNWAY_TYPE, result.size());
    }

    @Test
    public void getTopRunWayIdents() {
        List<TopRunWayIdentsDto> result = reportDao.getTopRunWayIdents();
        assertEquals(GET_TOP_RUNWAY_IDENTS, result.size());
    }
}