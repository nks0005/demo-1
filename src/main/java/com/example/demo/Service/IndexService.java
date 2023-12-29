package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Mapper.IndexMapper;
import com.example.demo.Model.Battle;
import com.example.demo.Model.Team;
import com.example.demo.dto.BattlesDto;

@Service
public class IndexService {

	@Autowired
	IndexMapper indexMapper;

	public BattlesDto getBattle() {
		return indexMapper.getBattle();
	}
	
	public Battle getBattleById(int id) {
		
		BattlesDto battle_log = indexMapper.getBattleById(id);
		Battle filter_battle = new Battle();
		
		filter_battle.victory_team = new ArrayList<>();
		filter_battle.defeat_team = new ArrayList<>();
		
		filter_battle.battle_id = battle_log.battle_id;
		filter_battle.totalFame = battle_log.totalFame;
		filter_battle.totalKills = battle_log.totalKills;
		filter_battle.countPlayers = battle_log.countPlayers;
		
		String[] splitted_vitory_team = battle_log.victory_team.split(", ");
		for(String str : splitted_vitory_team) {
			String[] splitted_name_weapon = str.split("\\.");
			
			Team tmp_team = new Team();
			tmp_team.name = splitted_name_weapon[0];
			tmp_team.weapon = splitted_name_weapon[1];
			
			filter_battle.victory_team.add(tmp_team);
		}
		
		String[] splitted_defeat_team = battle_log.defeat_team.split(", ");
		for(String str : splitted_defeat_team) {
			String[] splitted_name_weapon = str.split("\\.");
			
			Team tmp_team = new Team();
			tmp_team.name = splitted_name_weapon[0];
			tmp_team.weapon = splitted_name_weapon[1];
			
			filter_battle.defeat_team.add(tmp_team);
		}
		
		filter_battle.type = battle_log.type;
		filter_battle.battle_time = battle_log.battle_time;
		
		
		return filter_battle;
	}
	
	public List<Battle> getBattles() {
		List<BattlesDto> tmp = indexMapper.getBattles();
		List<Battle> filter_battle = new ArrayList<>();
		
		for(BattlesDto battle : tmp) {
			// battle.victory_team = battle.victory_team + "hello";
			
			Battle filter_tmp = new Battle();
			
			filter_tmp.victory_team = new ArrayList<>();
			filter_tmp.defeat_team = new ArrayList<>();
			
			filter_tmp.battle_id = battle.battle_id;
			filter_tmp.totalFame = battle.totalFame;
			filter_tmp.totalKills = battle.totalKills;
			filter_tmp.countPlayers = battle.countPlayers;
			
			String[] splitted_vitory_team = battle.victory_team.split(", ");
			for(String str : splitted_vitory_team) {
				//System.out.println("str : " + str);
				String[] splitted_name_weapon = str.split("\\.");
				
				//System.out.println("splitted_name_weapon : " + splitted_name_weapon[0]);
				//System.out.println("splitted_name_weapon : " + splitted_name_weapon[1]);
				
				Team tmp_team = new Team();
				tmp_team.name = splitted_name_weapon[0];
				tmp_team.weapon = splitted_name_weapon[1];
				
				filter_tmp.victory_team.add(tmp_team);
			}
			
			String[] splitted_defeat_team = battle.defeat_team.split(", ");
			for(String str : splitted_defeat_team) {
				String[] splitted_name_weapon = str.split("\\.");
				
				//System.out.println("splitted_name_weapon : " + splitted_name_weapon[0]);
				//System.out.println("splitted_name_weapon : " + splitted_name_weapon[1]);
				
				Team tmp_team = new Team();
				tmp_team.name = splitted_name_weapon[0];
				tmp_team.weapon = splitted_name_weapon[1];
				
				filter_tmp.defeat_team.add(tmp_team);
			}
			
			filter_tmp.type = battle.type;
			filter_tmp.battle_time = battle.battle_time;
			
			filter_battle.add(filter_tmp);
		}
		
		return filter_battle;
	}
}