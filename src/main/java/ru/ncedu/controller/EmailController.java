package ru.ncedu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import ru.ncedu.service.EmailService;
import ru.ncedu.model.Email;
import ru.ncedu.model.User;


/**
 * This class EmailController for controller
 * @version 1.0, 5 Feb 2021
 * @author Vladislav Semenovykh
 */
@Controller
public class EmailController {
    @Autowired
    private EmailService emailService;

    /**
     * This controller for processing request GET
     * @param model
     * @param email
     * @return emailForm.html
     */
   @RequestMapping(value="/emailForm", method= RequestMethod.GET)
    public String sendEmailForm(Model model, Email email) {
        model.addAttribute("email", new Email());
        return "emailForm";
    }

    /**
     * This controller for processing request POST
     * The method is sending a message to the mail
     * @param email
     * @param model
     * @return emailSent.html
     */
    @RequestMapping(value="/emailForm", method=RequestMethod.POST)
    public String sendMessangeSubmit(@ModelAttribute Email email, Model model) {
       emailService.sendMail(email.getToEmail(), email.getSubject(), email.getMessage());
       return "emailSent";
    }
}