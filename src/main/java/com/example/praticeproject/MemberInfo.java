package com.example.praticeproject;

import com.example.praticeproject.protocol.Buffer;
import lombok.Data;

@Data
public class MemberInfo {
    private String memberId;
    private String bufferStatus;
    private Buffer buffer;
    private Long balance;
}
