package com.lunatech.assessment.controller;

import com.lunatech.assessment.controller.CommonController;
import com.lunatech.assessment.dao.QueryDao;
import com.lunatech.assessment.dao.ReportDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * Created by User on 05/29/2017.
 */
@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@WebMvcTest(CommonController.class)
public class CommonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ReportDao reportDao;

    @MockBean
    private QueryDao queryDao;

    @Test
    public void testIndex() throws Exception {
        mockMvc.perform(get("/")).andExpect(view().name("index"));
    }

    @Test
    public void testReport() throws Exception {
        mockMvc.perform(get("/reports")).andExpect(view().name("reports"));
    }

    @Test
    public void testQuery() throws Exception {
        mockMvc.perform(get("/query")).andExpect(view().name("query"));
    }

}
