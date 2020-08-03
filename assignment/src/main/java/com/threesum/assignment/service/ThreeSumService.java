package com.threesum.assignment.service;

import com.threesum.assignment.model.ThreeSum;
import java.util.List;
import java.util.Optional;

public interface ThreeSumService {
    List<ThreeSum> getAllRecords();
    String createEntry(ThreeSum threesum);
    Optional<ThreeSum> getAllCalculationsForErrorCode(String errorCode);
    Optional<ThreeSum> getAllRecordsForID(long id);
}
