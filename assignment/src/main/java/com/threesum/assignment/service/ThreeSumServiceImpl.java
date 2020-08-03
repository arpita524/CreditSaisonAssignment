package com.threesum.assignment.service;

import com.threesum.assignment.exception.ResourceNotFoundException;
import com.threesum.assignment.exception.UserServiceException;
import com.threesum.assignment.model.ThreeSum;
import com.threesum.assignment.repository.ThreeSumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class ThreeSumServiceImpl implements ThreeSumService{
    @Autowired
    ThreeSumRepository threesumrepo;

    @Override
    public List<ThreeSum> getAllRecords() {
        return threesumrepo.findAll();
    }

    @Override
    public String createEntry(ThreeSum threesum) {
        StringBuilder result=new StringBuilder();
        Set<String> errorList=new HashSet<>();
        if(threesum.getList().size() < 3) {
            errorList.add("101");
        }else{
            List<Integer> newList = threesum.getList().stream()
                    .map(s -> Integer.parseInt(s))
                    .collect(Collectors.toList());
            List<Integer> ans = find3Numbers(newList, threesum.getNumber());
            if(ans.size() < 3) {
                throw new UserServiceException("No combination exists for the given input");
            }
            List<String> strList = ans.stream()
                    .map(s -> String.valueOf(s))
                    .collect(Collectors.toList());
            threesum.setAnswer(strList);
            threesum.setErrorCode("200");
            threesumrepo.save(threesum);
        }

        if(errorList.size()>0)
        {
            threesum.setErrorCode(errorList.toString());
            result.insert(0, "Error Code:");
            result.append(errorList.toString());
        }
        return result.toString();
    }

    @Override
    public Optional<ThreeSum> getAllCalculationsForErrorCode(String errorCode) {
        return threesumrepo.getAllCalculationsForErrorCode(errorCode);
    }

    @Override
    public Optional<ThreeSum> getAllRecordsForID(long id) {
        return threesumrepo.findById(id);
    }

    public static List<Integer> find3Numbers(List<Integer> A, int sum){
        int arr_size = A.size();
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < arr_size - 2; i++) {
            HashSet<Integer> s = new HashSet<>();
            int curr_sum = sum - A.get(i);
            for (int j = i + 1; j < arr_size; j++) {
                if (s.contains(curr_sum - A.get(j))) {
                    ans.add(A.get(i));
                    ans.add(A.get(j));
                    ans.add(curr_sum - A.get(j));
                    return ans;
                }
                s.add(A.get(j));
            }
        }
        return ans;
    }
}
