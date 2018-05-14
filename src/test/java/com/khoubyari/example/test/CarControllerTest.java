package com.khoubyari.example.test;

import com.khoubyari.example.dao.dynamodb.CarRepository;
import com.khoubyari.example.domain.Car;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.*;

import java.util.concurrent.ThreadLocalRandom;

public class CarControllerTest extends TestBase {

    protected static final String RESOURCE_LOCATION_PATTERN = "http://localhost/example/v1/cars/[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}";

    @Autowired
    CarRepository carRepository;

    @Test
    public void shouldCreateRetrieveDelete() throws Exception {
        Car r1 = mockCar("shouldCreateRetrieveDelete");
        byte[] r1Json = toJson(r1);

        //CREATE
        MvcResult result = mvc.perform(post("/example/v1/cars")
                .content(r1Json)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(redirectedUrlPattern(RESOURCE_LOCATION_PATTERN))
                .andReturn();
        String id = getResourceIdFromUrl(result.getResponse().getRedirectedUrl());

        //RETRIEVE
        mvc.perform(get("/example/v1/cars/" + id)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(id)))
                .andExpect(jsonPath("$.name", is(r1.getName())))
                .andExpect(jsonPath("$.year", is(r1.getYear())));

        //DELETE
        mvc.perform(delete("/example/v1/cars/" + id))
                .andExpect(status().isNoContent());

        //RETRIEVE should fail
        mvc.perform(get("/example/v1/cars/" + id)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
        
    }

    private Car mockCar(String prefix) {
        int min = 1900;
        int max = 2019;
        Car r = new Car();
        r.setYear(ThreadLocalRandom.current().nextInt(min, max + 1));
        r.setName(prefix + "_name");
        return r;
    }

    protected String getResourceIdFromUrl(String locationUrl) {
        String[] parts = locationUrl.split("/");
        return parts[parts.length - 1];
    }

}
