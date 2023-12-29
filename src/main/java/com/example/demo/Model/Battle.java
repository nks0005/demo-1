package com.example.demo.Model;

import java.sql.Timestamp;
import java.util.List;

import lombok.Data;
import lombok.ToString;


@Data
@ToString
public class Battle {
	
	public int battle_id;
	
	public int totalFame;
	
	public int totalKills;
	
	public int countPlayers;
	
	public List<Team> victory_team;
	
	public List<Team> defeat_team;
	
	public int type;
	
	public Timestamp battle_time;
}
