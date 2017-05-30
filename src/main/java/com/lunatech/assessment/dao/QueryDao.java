package com.lunatech.assessment.dao;

import com.lunatech.assessment.model.Airport;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Collections;
import java.util.List;

/**
 * Created by User on 05/28/2017.
 */
@Component
public class QueryDao {
    private final static Logger logger = org.slf4j.LoggerFactory.getLogger(QueryDao.class);

    private static final String QUERY_INITIAL =
            "SELECT distinct a FROM Airport a " +
                    "JOIN a.country c " +
                    "LEFT JOIN a.runways r " +
                    "WHERE 1=1 ";

    @Autowired
    private EntityManager entityManager;

    public List<Airport> getAllAirports(String countryCode, String countryName) {
        if (StringUtils.isEmpty(countryCode) && StringUtils.isEmpty(countryName))
            return Collections.emptyList();

        StringBuilder queryText = new StringBuilder(QUERY_INITIAL);

        if (!StringUtils.isEmpty(countryCode)) {
            queryText.append("AND c.code = :code ");
        }

        if (!StringUtils.isEmpty(countryName)) {
            queryText.append("AND upper(c.name) like upper(:name)");
        }

        Query query = entityManager.createQuery(queryText.toString());

        if (!StringUtils.isEmpty(countryCode)) {
            query.setParameter("code", countryCode);
        }

        if (!StringUtils.isEmpty(countryName)) {
            query.setParameter("name", countryName + "%");
        }

        List<Airport> result = (List<Airport>) query.getResultList();

        logger.info(String.format("getAllAirports: %d records selected", result.size()));

        return result;
    }
}
