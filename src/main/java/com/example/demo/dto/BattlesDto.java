package com.example.demo.dto;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Alias("BattlesDto")
public class BattlesDto {
	
	public int battle_id;
	
	public int totalFame;
	
	public int totalKills;
	
	public int countPlayers;
	
	public String victory_team;
	
	public String defeat_team;
	
	public int type;
	
	public Timestamp battle_time;
}
