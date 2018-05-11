package com.khoubyari.example.dao.jpa;

import com.khoubyari.example.domain.Car;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

@EnableScan
public interface CarRepository extends PagingAndSortingRepository<Car, String> {

    List<Car> findByName(String lastName);
}
