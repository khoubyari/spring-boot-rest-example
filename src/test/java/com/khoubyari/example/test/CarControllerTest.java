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

import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class CarControllerTest extends TestBase {

    protected static final String RESOURCE_LOCATION_PATTERN = "http://localhost/example/v1/cars/[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}";

    @Autowired
    CarRepository carRepository;

    @Test
    public void shouldCreateRetrieveDelete() throws Exception {

        // remove everything first
        carRepository.deleteAll();

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

    @Test
    public void shouldCreateAndUpdateAndDelete() throws Exception {

        // remove everything first
        carRepository.deleteAll();

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

        Car r2 = mockCar("shouldCreateAndUpdate2");
        r2.setId(id); // id should match when we are updating
        byte[] r2Json = toJson(r2);

        //UPDATE
        result = mvc.perform(put("/example/v1/cars/" + id)
                .content(r2Json)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent())
                .andReturn();

        //RETRIEVE updated
        mvc.perform(get("/example/v1/cars/" + id)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is((id))))
                .andExpect(jsonPath("$.name", is(r2.getName())))
                .andExpect(jsonPath("$.year", is(r2.getYear())));

        //DELETE
        mvc.perform(delete("/example/v1/cars/" + id))
                .andExpect(status().isNoContent());
    }


    private Car mockCar(String prefix) {
        int min = 1900;
        int max = 2019;
        Car r = new Car();
        r.setYear(ThreadLocalRandom.current().nextInt(min, max + 1));
        r.setName(prefix + "_" + new Date().getTime());
        return r;
    }

    protected String getResourceIdFromUrl(String locationUrl) {
        String[] parts = locationUrl.split("/");
        return parts[parts.length - 1];
    }

}
