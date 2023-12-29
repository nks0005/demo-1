package com.example.demo.Controller;

/*
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.Model.Battle;
import com.example.demo.Service.IndexService;
import com.example.demo.dto.BattlesDto;

@Controller
@RequestMapping("/battle")
public class BattleController {

	@Autowired
	IndexService indexService;

	@GetMapping("/detail")
	public ModelAndView getHellgateDetailPage(ModelAndView mv, @RequestParam("id") int id) {

		Battle battle = indexService.getBattleById(id);
		mv.addObject("battle", battle);
		
		mv.setViewName("client/page/hellgates");
		return mv;
	}

}

*/