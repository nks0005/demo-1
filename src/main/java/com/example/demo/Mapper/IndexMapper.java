package com.example.demo.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.dto.BattlesDto;

@Mapper
public interface IndexMapper {

	BattlesDto getBattleById(@Param("id") int id);

	List<BattlesDto> getBattles(@Param("offset") int offset);
	List<BattlesDto> getBattlesInType(@Param("offset") int offset, @Param("type") int type);

}
