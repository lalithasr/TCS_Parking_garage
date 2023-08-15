package com.tcs.natd.springhandson.parkinggarage.repository;

import com.tcs.natd.springhandson.parkinggarage.entity.Make;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MakeRepository extends JpaRepository<Make, Long> {
}
