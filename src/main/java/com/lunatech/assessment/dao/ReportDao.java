package com.lunatech.assessment.dao;

import com.lunatech.assessment.dto.CountryAirportDto;
import com.lunatech.assessment.dto.CountryRunwayTypesDto;
import com.lunatech.assessment.dto.TopRunWayIdentsDto;
import com.lunatech.assessment.model.Country;
import org.apache.log4j.spi.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by User on 05/28/2017.
 */
@Component
public class ReportDao {

    private final static Logger logger = org.slf4j.LoggerFactory.getLogger(ReportDao.class);

    private static final String queryHighest =
            "SELECT c, COUNT(c) FROM Airport a JOIN a.country c " +
            "GROUP BY c ORDER BY COUNT(c) DESC";

    private static final String queryLowest =
            "SELECT c,COUNT(c) FROM Airport a JOIN a.country c " +
            "GROUP BY c ORDER BY COUNT(c) ASC";

    private static final String queryRunwayTypes =
            "SELECT DISTINCT c, r.surface FROM Airport a " +
            "JOIN a.country c " +
            "JOIN a.runways r ";

    private static final String queryRunwayIdents =
            "SELECT r.le_ident, count(1) FROM RunWay r " +
            "GROUP BY r.le_ident " +
            "ORDER BY COUNT(1) DESC";

    private static final int RESULTSET_MAX = 10;

    @Autowired
    private EntityManager entityManager;

    public List<CountryAirportDto> getHightestCountry(){
        Query query = entityManager.createQuery(queryHighest);
        List<Object[]> resultJpa = (List<Object[]>)query.setMaxResults(RESULTSET_MAX).getResultList();
        List<CountryAirportDto> result = resultJpa.stream().map(item -> {
            return new CountryAirportDto((Country) item[0], (Long)item[1]);
        }).collect(Collectors.toList());

        logger.info(String.format("getHightestCountry: %d records selected", result.size()));

        return result;
    }

    public List<CountryAirportDto> getLowestCountry(){
        Query query = entityManager.createQuery(queryLowest);
        List<Object[]> resultJpa = (List<Object[]>)query.setMaxResults(RESULTSET_MAX).getResultList();
        List<CountryAirportDto> result = resultJpa.stream().map(item -> {
            return new CountryAirportDto((Country) item[0], (Long)item[1]);
        }).collect(Collectors.toList());

        logger.info(String.format("getLowestCountry: %d records selected", result.size()));

        return result;
    }

    public Map<Country,List<String>> getRunwayTypes(){
        Query query = entityManager.createQuery(queryRunwayTypes);
        List<Object[]> resultJpa = (List<Object[]>)query.getResultList();

        Map<Country,List<String>> result = new HashMap<>();
        for (Object[] item : resultJpa) {
            Country country = (Country) item[0];
            List<String> runways = result.get(country);
            if (runways == null) {
                runways = new LinkedList<>();
                result.put(country, runways);
            }
            runways.add((String)item[1]);
        }

        logger.info(String.format("getRunwayTypes: %d records selected", result.size()));

        return result;
    }

    public List<TopRunWayIdentsDto> getTopRunWayIdents(){
        Query query = entityManager.createQuery(queryRunwayIdents);
        List<Object[]> resultJpa = (List<Object[]>)query.setMaxResults(RESULTSET_MAX).getResultList();
        List<TopRunWayIdentsDto> result = resultJpa.stream().map(item -> {
            return new TopRunWayIdentsDto((String) item[0], (Long)item[1]);
        }).collect(Collectors.toList());

        logger.info(String.format("getTopRunWayIdents: %d records selected", result.size()));

        return result;
    }

}
