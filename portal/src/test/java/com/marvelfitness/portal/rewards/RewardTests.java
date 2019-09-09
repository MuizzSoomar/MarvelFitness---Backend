package com.marvelfitness.portal.rewards;

import com.marvelfitness.portal.PortalApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Class to test Reward functionality in Reward Service that is exposed by Reward Controller
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=PortalApplication.class)
@ActiveProfiles("test")
public class RewardTests {
    @InjectMocks
    RewardController controller;

    @Autowired
    WebApplicationContext context;

    private MockMvc mvc;

    /**
     * Method to set up a MockMvc before running the tests
     */
    @Before
    public void initTests() {
        MockitoAnnotations.initMocks(this);
        mvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    /**
     * Method to test that the correct Reward is returned when a valid reward id is provided
     * @throws Exception when the request fails
     */
    @Test
    public void shouldGetAReward() throws Exception {
        int reward_id = 1;
        mvc.perform(get("/rewards/" + reward_id).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.reward_id", is(reward_id)))
                .andExpect(jsonPath("$.value", is(5)))
                .andExpect(jsonPath("$.name", is("$5")))
                .andExpect(jsonPath("$.description", is("$5 off your next visit!")))
                .andReturn();
    }
}
