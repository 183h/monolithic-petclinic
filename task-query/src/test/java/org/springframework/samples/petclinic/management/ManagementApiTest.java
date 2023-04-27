package org.springframework.samples.petclinic.management;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class ManagementApiTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void shouldReturnListOfYearlyRevenues() throws Exception {
        mockMvc.perform(get("/api/yearly-revenues"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*]",
                        hasSize(1)))
                .andExpect(jsonPath("$[0].year",
                        equalTo(2013)))
                .andExpect(jsonPath("$[0].total",
                        equalTo(650)));
    }
}
