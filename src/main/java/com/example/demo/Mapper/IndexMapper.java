package com.example.demo.Mapper;

import java.util.List;

import com.example.demo.dto.TestViewDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.dto.BattlesDto;

@Mapper
public interface IndexMapper {

	BattlesDto getBattleById(@Param("id") int id);

	List<BattlesDto> getBattles(@Param("offset") int offset);
	List<BattlesDto> getBattlesInType(@Param("offset") int offset, @Param("type") int type);


	List<TestViewDto> getTestViews(@Param("offset") int offset);
}
