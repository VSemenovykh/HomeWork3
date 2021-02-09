package ru.ncedu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import ru.ncedu.model.Email;

/**
 * This class MainPageController for controller
 * @version 1.0, 2 Feb 2021
 * @author Vladislav Semenovykh
 */
@Controller
public class MainPageController {
    /**
     * This controller for processing request GET
     * @return index.html
     */
    @RequestMapping(value= "/", method= RequestMethod.GET)
    public String sendmail() {
        return "index";
    }
}
