package controller;

import bean.Orderform;
import bean.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import service.OrderFormService;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/orderform")
public class orderformController {
    @Autowired
private OrderFormService orderFormService;
    @RequestMapping("/find")
    public  String find(ModelMap map){
        List<Orderform> orderforms = orderFormService.find();
        map.addAttribute("orderforms",orderforms);
        return "order";

    }
    @RequestMapping("/findNonPayment")
    public  String findNonPayment( ModelMap map){
        List<Page>page = orderFormService.findNonPayment();
        map.addAttribute("page",page);
        return "arrearage";
    }
    @RequestMapping("/addredis")
    public String addredis(Orderform orderform){
        Boolean isdate = orderFormService.isdate(orderform);
        if(isdate){
            Date date=new Date();
            orderform.setOrdertime(date);
            orderform.setPayment("N");
            orderFormService.addredis(orderform);
            return "redirect:/orderform/findNonPayment";
        }else {
            return "defeated";
        }

    }
    @RequestMapping("/findorder")
    public String findorder(String uuid){
        Orderform orderform = orderFormService.findbyuuid(uuid);
        orderFormService.delete(uuid);
        orderform.setPayment("y");
        orderFormService.add(orderform);
        return "forward:/orderform/find";

    }
}
