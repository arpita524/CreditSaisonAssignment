//package com.threesum.assignment.service;
//
//import com.threesum.assignment.model.ThreeSum;
//import com.threesum.assignment.repository.ThreeSumRepository;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//import static org.junit.Assert.assertEquals;
//import static org.mockito.Mockito.*;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//public class service_test {
//
//    @Mock
//    private ThreeSumRepository Repository;
//
//    @InjectMocks
//    private ThreeSumServiceImpl Service;
//
//    @Before
//    public void setup() {
//        MockitoAnnotations.initMocks(this);
//    }
//
//    @Test
//    public void testGetAllToDo() {
//        List<ThreeSum> threeSums = new ArrayList<>();
//        threeSums.add(new ThreeSum(1L, Arrays.asList("1","2","3"), 6, Arrays.asList("1","2","3"), "200"));
//        when(Repository.findAll()).thenReturn(threeSums);
//        List<ThreeSum> result = Service.getAllRecords();
//        assertEquals(1, result.size());
//    }
//
//    @Test
//    public void testGetToDoById() {
//        ThreeSum ts = new ThreeSum(1L, Arrays.asList("1","2","3"), 6, Arrays.asList("1","2","3"), "200");
//        when(Repository.findById(1L)).thenReturn(Optional.of(ts));
//        Optional<ThreeSum> resultOpt = Service.getAllRecordsForID(1L);
//        ThreeSum result = resultOpt.get();
//        assertEquals(1, result.getId());
//        assertEquals(6, result.getNumber());
//        assertEquals("200", result.getErrorCode());
//    }
//
//    @Test
//    public void testGetToDoByError() {
//        ThreeSum ts = new ThreeSum(1L, Arrays.asList("1","2","3"), 6, Arrays.asList("1","2","3"), "200");
//        when(Repository.getAllCalculationsForErrorCode("200")).thenReturn(Optional.of(ts));
//        Optional<ThreeSum> resultOpt = Service.getAllCalculationsForErrorCode("200");
//        ThreeSum result = resultOpt.get();
//        assertEquals(1, result.getId());
//        assertEquals(6, result.getNumber());
//        assertEquals("200", result.getErrorCode());
//    }
//
//    @Test
//    public void saveToDo() {
//        ThreeSum ts = new ThreeSum(1L, Arrays.asList("1","2","3"), 6, Arrays.asList("1","2","3"), "200");
//        when(Repository.save(ts)).thenReturn(ts);
//        String result = Service.createEntry(ts);
//        assertEquals("", result);
//    }
//}