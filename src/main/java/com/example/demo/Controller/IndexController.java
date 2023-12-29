package com.example.demo.Controller;

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

import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/")
public class IndexController {

	@Autowired
	IndexService indexService;

	@GetMapping("")
	public String getHellgatePage() {
	    return "redirect:/start?list=0";
	}
	
	@GetMapping("start")
	public ModelAndView getStartPage(ModelAndView mv, @RequestParam("list") int list) {
		mv.setViewName("client/page/start");
		
		List<Battle> battles = indexService.getBattles();
		mv.addObject("battles", battles);
		
		return mv;
	}
}