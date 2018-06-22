package com.khoubyari.example.service;

import com.khoubyari.example.domain.Hotel;
import com.khoubyari.example.dao.jpa.HotelRepository;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Metrics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

/*
 * Sample service to demonstrate what the API would use to get things done
 */
@Service
public class HotelService {

    private static final Logger log = LoggerFactory.getLogger(HotelService.class);

    @Autowired
    private HotelRepository hotelRepository;

    public HotelService() {
    }

    public Hotel createHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    public Hotel getHotel(long id) {
        if (hotelRepository.existsById(id)) {
            return hotelRepository.findById(id).get();
        }
        return null;
    }

    public void updateHotel(Hotel hotel) {
        hotelRepository.save(hotel);
    }

    public void deleteHotel(Long id) {
        hotelRepository.deleteById(id);
    }

    //http://goo.gl/7fxvVf
    public Page<Hotel> getAllHotels(Integer page, Integer size) {
        Page pageOfHotels = hotelRepository.findAll(PageRequest.of(page, size));
        Counter largePayloads = Metrics.counter("HotelService.getAll.largePayload");
        // example of adding to the /metrics
        if (size > 50) {
            largePayloads.increment();
        }
        return pageOfHotels;
    }
}
