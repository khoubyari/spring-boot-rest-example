package com.khoubyari.example.dao.dynamodb;

import com.khoubyari.example.domain.Car;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableScan
@Repository
public interface CarRepository extends CrudRepository<Car, String> {

    List<Car> findByName(String lastName);
}
