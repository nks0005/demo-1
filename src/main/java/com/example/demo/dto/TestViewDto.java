package com.example.demo.dto;

import lombok.Data;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

@Data
@ToString
@Alias("TestViewDto")
public class TestViewDto {
    public String A_name;

    public String B_name;

    public int win_count;
    public int lose_count;
    public int total_count;
}
