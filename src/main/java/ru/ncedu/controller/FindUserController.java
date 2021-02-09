package ru.ncedu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import ru.ncedu.service.ListInformationUserService;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import ru.ncedu.model.User;

import java.nio.file.Paths;
import java.util.Date;

import static java.nio.file.Files.exists;

/**
 * This class FindUserController for controller
 * @version 1.0, 2 Feb 2021
 * @author Vladislav Semenovykh
 */
@Controller
public class FindUserController {
    @Autowired
    private ListInformationUserService listInformationUserService;

    /**
     * This controller for processing request GET
     * @param model
     * @return findInformationByName.html
     */
    @RequestMapping(value="/findInformationByName", method= RequestMethod.GET)
    public String findForm(Model model) {
        model.addAttribute("user", new User());
        return "findInformationByName";
    }

    /**
     * This controller for processing request POST
     * The method is searching a user by first and last name.
     * As well as displaying  information about user, time and browser name.
     * @param user
     * @param model
     * @param request
     * @return informationAboutUser.html if user is found, otherwise errorNotFindUserByName.html
     */
    @RequestMapping(value="/findInformationByName", method=RequestMethod.POST)
    public String findSubmit(@ModelAttribute User user, Model model, HttpServletRequest request) throws IOException {
        StringBuffer sb = new StringBuffer();
        sb.append(user.getLastName() + " " + user.getFirstName());

        //Current time and browser name
        HttpSession session = request.getSession(true);
        Date creationTime = new Date(session.getCreationTime());
        Date lastAccessedTime = new Date(session.getLastAccessedTime());
        String userAgentStr = request.getHeader("User-Agent");

        //Search user by last name and first name. And display result search
        for(int i = 0; i< listInformationUserService.getListUser().size(); i++){
            if(listInformationUserService.getListUser().get(i).equals(sb.toString())){
                //Display
                model.addAttribute("first", listInformationUserService.getLastName(sb.toString()));
                model.addAttribute("last", listInformationUserService.getFirstName((sb.toString())));
                model.addAttribute("middle", listInformationUserService.getMiddleName(sb.toString()));
                model.addAttribute("age", listInformationUserService.getAge(sb.toString()));
                model.addAttribute("email", listInformationUserService.getEmail(sb.toString()));
                model.addAttribute("salary", listInformationUserService.getSalary(sb.toString()));
                model.addAttribute("workPlace", listInformationUserService.getWorkPlace(sb.toString()));

                model.addAttribute("creationTime", creationTime);
                model.addAttribute("lastAccessTime", lastAccessedTime);
                model.addAttribute("userAgentStr", userAgentStr);

                return "informationAboutUser";
            }
        }
        return "errorNotFoundUserByName";
    }
}
