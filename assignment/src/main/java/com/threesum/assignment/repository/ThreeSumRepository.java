package com.threesum.assignment.repository;

import com.threesum.assignment.model.ThreeSum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ThreeSumRepository extends JpaRepository<ThreeSum, Long> {
    @Query(value="SELECT * from threesum where error_code=:error_code",nativeQuery = true)
    Optional<ThreeSum> getAllCalculationsForErrorCode(@Param("error_code") String error_code);

}