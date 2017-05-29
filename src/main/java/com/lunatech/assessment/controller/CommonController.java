package com.lunatech.assessment.controller;

import com.lunatech.assessment.dao.QueryDao;
import com.lunatech.assessment.dao.ReportDao;
import com.lunatech.assessment.dto.CountryAirportDto;
import com.lunatech.assessment.dto.TopRunWayIdentsDto;
import com.lunatech.assessment.model.Airport;
import com.lunatech.assessment.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * Created by User on 05/27/2017.
 */
@Controller
public class CommonController {
    @Autowired
    private ReportDao reportDao;

    @Autowired
    private QueryDao queryDao;

    @RequestMapping("/")
    public String welcome(){
        return "index";
    }

    @RequestMapping(value = "/reports", method = RequestMethod.GET)
    public ModelAndView countryAirports() {
        List<CountryAirportDto> countryAirportsTopHighest = reportDao.getHightestCountry();
        List<CountryAirportDto> countryAirportsTopLowest = reportDao.getLowestCountry();
        Map<Country,List<String>> countryRunWayTypes = reportDao.getRunwayTypes();
        List<TopRunWayIdentsDto> topRunWayIdents = reportDao.getTopRunWayIdents();

        ModelAndView reports = new ModelAndView("reports");
        reports.addObject("countryAirportsTopHighest", countryAirportsTopHighest);
        reports.addObject("countryAirportsTopLowest", countryAirportsTopLowest);
        reports.addObject("countryRunWayTypes", countryRunWayTypes);
        reports.addObject("topRunWayIdents", topRunWayIdents);

        return reports;
    }

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public ModelAndView airportRunWaysQuery() {
        ModelAndView reports = new ModelAndView("query");
        return reports;
    }

    @RequestMapping(value = "/query", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<List<Airport>> airportRunWays(@RequestParam("code") String code, @RequestParam("name") String name) {
        List<Airport> airports = queryDao.getAllAirports(code, name);
        return ResponseEntity.ok().body(airports);
    }

}
