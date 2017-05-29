package com.lunatech.assessment.dao;

import com.lunatech.assessment.model.Airport;
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

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by User on 05/29/2017.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class QueryDaoTest {

    @Autowired
    private TestEntityManager entityManager;

    @TestConfiguration
    static class QueryDaoTestConfiguration {
        @Bean
        public QueryDao queryDao() {
            return new QueryDao();
        }
    }

    @Autowired
    private QueryDao queryDao;

    private final static int GET_ALL_AIRPORTS_DATA_SIZE = 59;

    @Test
    public void testGetAllAirports() {
        List<Airport> result = queryDao.getAllAirports("AO", "");
        assertEquals(GET_ALL_AIRPORTS_DATA_SIZE, result.size());
    }

}