package com.marvelfitness.portal.user;

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
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import org.json.*;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Class to test User functionality in User Service that is exposed by User Controller
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=PortalApplication.class)
@ActiveProfiles("test")
public class UserTests {
    @InjectMocks
    UserController controller;

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
     * Method to test that the correct Customer is returned when a valid customer id is provided
     * @throws Exception when the request fails
     */
    @Test
    public void shouldGetAValidCustomer() throws Exception {
        int user_id = 1;
        mvc.perform(get("/customers/" + user_id).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.user_id", is(user_id)))
                .andExpect(jsonPath("$.name", is("Tony Stark")))
                .andExpect(jsonPath("$.username", is("iron.man@mailinator.com")))
                .andExpect(jsonPath("$.phone_number", is("1234567890")))
                .andExpect(jsonPath("$.street_one", is("1 Stark Tower")))
                .andExpect(jsonPath("$.street_two", isEmptyOrNullString()))
                .andExpect(jsonPath("$.city", is("Malibu")))
                .andExpect(jsonPath("$.state", is("CA")))
                .andExpect(jsonPath("$.zip", is("12345")))
                .andExpect(jsonPath("$.customer", is(true)));
    }

    /**
     * Method to test that a NOT_FOUND HTTP Status occurs when an invalid customer id is provided
     * @throws Exception when the request fails
     */
    @Test
    public void shouldNotGetAnInvalidCustomer() throws Exception {
        int user_id = 4;
        mvc.perform(get("/customers/" + user_id)).andExpect(status().isNotFound());
    }

    /**
     * Method to test that the correct Employee is returned when a valid employee id is provided
     * @throws Exception when the request fails
     */
    @Test
    public void shouldGetAValidEmployee() throws Exception {
        int user_id = 4;
        mvc.perform(get("/employees/" + user_id).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.user_id", is(user_id)))
                .andExpect(jsonPath("$.name", is("Mysterio")))
                .andExpect(jsonPath("$.username", is("quentin.beck@mailinator.com")))
                .andExpect(jsonPath("$.phone_number", isEmptyOrNullString()))
                .andExpect(jsonPath("$.rewards_balance", is(0)))
                .andExpect(jsonPath("$.street_one", isEmptyOrNullString()))
                .andExpect(jsonPath("$.street_two", isEmptyOrNullString()))
                .andExpect(jsonPath("$.city", isEmptyOrNullString()))
                .andExpect(jsonPath("$.state", isEmptyOrNullString()))
                .andExpect(jsonPath("$.zip", isEmptyOrNullString()))
                .andExpect(jsonPath("$.customer", is(false)));
    }

    /**
     * Method to test that a NOT_FOUND HTTP Status occurs when an invalid employee id is provided
     * @throws Exception when the request fails
     */
    @Test
    public void shouldNotGetAnInvalidEmployee() throws Exception {
        int user_id = 1;
        mvc.perform(get("/employees/" + user_id)).andExpect(status().isNotFound());
    }

    /**
     * Method to test that a Customer's rewards balance updates correctly when a valid customer id is provided
     * @throws Exception when the request fails
     */
    @Test
    public void shouldUpdateCustomerBalance() throws Exception {
        int user_id = 1;
        MvcResult result = mvc.perform(get("/customers/" + user_id)).andReturn();
        JSONObject json = new JSONObject(result.getResponse().getContentAsString());
        int balance = json.getInt("rewards_balance");
        mvc.perform(post("/customers/update_balance/" + user_id + "?new_balance=" + 5))
                .andExpect(status().isOk());
        mvc.perform(get("/customers/" + user_id))
                .andExpect(jsonPath("$.rewards_balance", is(5)));
        mvc.perform(post("/customers/update_balance/" + user_id + "?new_balance=" + balance))
                .andExpect(status().isOk());
        mvc.perform(get("/customers/" + user_id))
                .andExpect(jsonPath("$.rewards_balance", is(balance)));
    }

    /**
     * Method to test that a NOT_FOUND HTTP Status occurs when an invalid customer id is provided
     * @throws Exception when the request fails
     */
    @Test
    public void shouldNotUpdateInvalidCustomerBalance() throws Exception {
        int user_id = 4;
        mvc.perform(post("/customers/update_balance/" + user_id + "?new_balance=0"))
                .andExpect(status().isNotFound());
    }
}

