package com.example.demo.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.BattlesDto;

@Mapper
public interface IndexMapper {
	BattlesDto getBattle();
	
	BattlesDto getBattleById(int id);
	
	List<BattlesDto> getBattles();
}
