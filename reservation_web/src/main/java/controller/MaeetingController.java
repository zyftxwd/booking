package controller;

import bean.Meetingroom;
import bean.Orderform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import service.MeetingRoomService;
import service.OrderFormService;

import java.util.List;

@Controller
@RequestMapping("/meeting")
public class MaeetingController {
    @Autowired
    private OrderFormService orderFormService;
    @Autowired
    private MeetingRoomService meetingRoomService;
    @RequestMapping("/findall")
    public String findall(ModelMap modelMap){
        List<Meetingroom> meetingrooms = meetingRoomService.findall();
        modelMap.addAttribute("meetingrooms",meetingrooms);
        return "meetingroom";
    }
    @RequestMapping("/update")
    public  String update(Meetingroom meetingroom){
        meetingRoomService.update(meetingroom);
        return "forward:/meeting/findall";
    }
    @RequestMapping("/findById")
    public  String findById( int id, ModelMap modelMap){
        List<Orderform> orderformList = orderFormService.findByMid(id);
        modelMap.addAttribute("list",orderformList);
        Meetingroom meetingroom = meetingRoomService.findById(id);
        modelMap.addAttribute("meetingroom",meetingroom);
        return "addorder";

    }
}
