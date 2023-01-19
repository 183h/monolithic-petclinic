/*
 * Copyright 2012-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.samples.petclinic.vets;


import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.equalTo;

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
class VetApiTests {

  @Autowired
  MockMvc mockMvc;

  @Test
  void shouldReturnListOfVets() throws Exception {
    mockMvc.perform(get("/api/vets"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$[*]", hasSize(6)))
        .andExpect(jsonPath("$[1].id", equalTo(2)))
        .andExpect(jsonPath("$[1].firstName", equalTo("Helen")))
        .andExpect(jsonPath("$[1].lastName", equalTo("Leary")))
        .andExpect(jsonPath("$[1].specialties",  hasSize(1)))
        .andExpect(jsonPath("$[1].specialties[0].id",  equalTo(1)))
        .andExpect(jsonPath("$[1].specialties[0].name",  equalTo("radiology")));
  }

}
