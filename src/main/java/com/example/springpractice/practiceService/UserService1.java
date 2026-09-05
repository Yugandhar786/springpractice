package com.example.springpractice.practiceService;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService1 {

    Map<Integer, String> userDetails = new HashMap<>();

    public UserService1() {
        userDetails.put(1001, "Yuga1");
        userDetails.put(1002, "Yuga2");
        userDetails.put(1003, "Yuga3");
        userDetails.put(1004, "Yuga4");
        userDetails.put(1005, "Yuga5");

    }

    public String getUserId(Integer id) {



//        return  userDetails.entrySet()
//                .stream()
//                .filter(n -> n.getKey().equals(id))
//                .map(Map.Entry::getValue)
//                .findFirst()
//                .orElse("User Not found");
        return userDetails.get(id);
    }

}
