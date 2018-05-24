package com.khoubyari.example.api.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import com.khoubyari.example.domain.Car;
import com.khoubyari.example.exception.DataFormatException;
import com.khoubyari.example.service.CarService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * Demonstrates how to set up RESTful API endpoints using Spring MVC. These APIs are currently backed by DynamoDB
 */

@RestController
@RequestMapping(value = "/example/v1/cars")
@Api(tags = {"cars"})
public class CarController extends AbstractRestHandler {

    @Autowired
    private CarService carService;

    @RequestMapping(value = "",
            method = RequestMethod.POST,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create a car resource.", notes = "Returns the URL of the new resource in the Location header.")
    public void createCar(@RequestBody Car car,
                          HttpServletRequest request, HttpServletResponse response) {
        Car createdCar = this.carService.createCar(car);
        response.setHeader("Location", request.getRequestURL().append("/").append(createdCar.getId()).toString());
    }

    @RequestMapping(value = "",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get a paginated list of all cars.", notes = "The list is paginated. You can provide a page number (default 0) and a page size (default 100)")
    public
    @ResponseBody
    Page<Car> getAllCar(@ApiParam(value = "The page number (zero-based)", required = true)
                        @RequestParam(value = "page", required = true, defaultValue = DEFAULT_PAGE_NUM) Integer page,
                        @ApiParam(value = "Tha page size", required = true)
                        @RequestParam(value = "size", required = true, defaultValue = DEFAULT_PAGE_SIZE) Integer size,
                        HttpServletRequest request, HttpServletResponse response) {
        return this.carService.getAllCars(page, size);
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get a single car.", notes = "You have to provide a valid car ID.")
    public
    @ResponseBody
    Car getCar(@ApiParam(value = "The ID of the car.", required = true)
               @PathVariable("id") String id,
               HttpServletRequest request, HttpServletResponse response) throws Exception {
        Car car = this.carService.getCar(id);
        checkResourceFound(car);
        //todo: http://goo.gl/6iNAkz
        return car;
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.PUT,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Update a car resource.", notes = "You have to provide a valid car ID in the URL and in the payload. The ID attribute can not be updated.")
    public void updateCar(@ApiParam(value = "The ID of the existing car resource.", required = true)
                          @PathVariable("id") String id, @RequestBody Car car,
                          HttpServletRequest request, HttpServletResponse response) {
        checkResourceFound(this.carService.getCar(id));
        if (!id.equals(car.getId())) throw new DataFormatException("ID doesn't match!");
        this.carService.updateCar(car);
    }

    //todo: @ApiImplicitParams, @ApiResponses
    @RequestMapping(value = "/{id}",
            method = RequestMethod.DELETE,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Delete a car resource.", notes = "You have to provide a valid car ID in the URL. Once deleted the resource can not be recovered.")
    public void deleteCar(@ApiParam(value = "The ID of the existing car resource.", required = true)
                          @PathVariable("id") String id, HttpServletRequest request,
                          HttpServletResponse response) {
        checkResourceFound(this.carService.getCar(id));
        this.carService.deleteCar(id);
    }
}
