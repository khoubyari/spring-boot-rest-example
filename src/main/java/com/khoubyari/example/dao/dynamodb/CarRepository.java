package com.khoubyari.example.dao.dynamodb;

import com.khoubyari.example.domain.Car;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.socialsignin.spring.data.dynamodb.repository.EnableScanCount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@EnableScan
@EnableScanCount  // ok for small collections / low volume services. otherwise research the performance implications
@Repository
public interface CarRepository extends PagingAndSortingRepository<Car, String> {

    Page findAll(Pageable pageable);

}
