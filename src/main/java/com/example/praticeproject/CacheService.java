package com.example.praticeproject;

import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Data
public class CacheService {
    private Map<String,MemberInfo> memberInfoMap = new HashMap<>();

}
