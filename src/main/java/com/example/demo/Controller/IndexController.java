package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.dto.TestViewDto;
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


    @GetMapping("statistics")
    public ModelAndView getStatisticsPage(ModelAndView mv, @RequestParam("type") int type,
                                          @RequestParam("list") int list) {

        int offset_list = 0;
        if(list > 100) list = 100;
        if (list < 0)
            offset_list = 0;
        else if (list != 0)
            offset_list = list * 10;


        List<TestViewDto> test_views = indexService.getTestViews(offset_list);


        mv.addObject("comps", test_views);

        // make button : previousPageURL, nextPageURL
        String tmpNext = "/statistics?type=" + type + "&list=" + (list + 1);
        mv.addObject("nextPageURL", tmpNext);

        if (list != 0) {
            String tmpPrev = "/statistics?type=" + type + "&list=" + (list - 1);
            mv.addObject("previousPageURL", tmpPrev);
        }

        mv.setViewName("client/page/statistics");
        return mv;
    }

    @GetMapping("start")
    public ModelAndView getStartPage(ModelAndView mv, @RequestParam("list") int list) {
        mv.setViewName("client/page/start");

        int offset_list = 0;
        if(list > 100) list = 100;
        if (list < 0)
            offset_list = 0;
        else if (list != 0)
            offset_list = list * 10;

        List<Battle> battles = indexService.getBattles(offset_list);
        mv.addObject("battles", battles);

        // make button : previousPageURL, nextPageURL
        String tmpNext = "/start?list=" + (list + 1);
        mv.addObject("nextPageURL", tmpNext);

        if (list != 0) {
            String tmpPrev = "/start?list=" + (list - 1);
            mv.addObject("previousPageURL", tmpPrev);
        }
        return mv;
    }

    @GetMapping("start/type")
    public ModelAndView getStartPage(ModelAndView mv, @RequestParam("list") int list, @RequestParam("type") int type) {
        mv.setViewName("client/page/start");

        int offset_list = 0;
        if(list > 100) list = 100;
        if (list < 0)
            offset_list = 0;
        else if (list != 0)
            offset_list = list * 10;

        List<Battle> battles = indexService.getBattlesInType(offset_list, type);
        mv.addObject("battles", battles);

        // make button : previousPageURL, nextPageURL
        String tmpNext = "/start/type?type=" + type + "&list=" + (list + 1);
        mv.addObject("nextPageURL", tmpNext);

        if (list != 0) {
            String tmpPrev = "/start/type?type=" + type + "&list=" + (list - 1);
            mv.addObject("previousPageURL", tmpPrev);
        }
        return mv;
    }

    @GetMapping("/detail")
    public ModelAndView getHellgateDetailPage(ModelAndView mv, @RequestParam("id") int id) {

        Battle battle = indexService.getBattleById(id);
        mv.addObject("battle", battle);

        mv.setViewName("client/page/hellgates");
        return mv;
    }
}