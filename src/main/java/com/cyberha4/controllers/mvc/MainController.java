package com.cyberha4.controllers.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by admin on 06.03.2017.
 */
@Controller
public class MainController {
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String showBasePage(){
        return "login";
    }


}
