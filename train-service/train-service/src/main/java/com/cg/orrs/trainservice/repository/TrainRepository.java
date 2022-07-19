package com.cg.orrs.trainservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.orrs.trainservice.entity.Train;

@Repository
public interface TrainRepository extends JpaRepository<Train, Long>{

}
