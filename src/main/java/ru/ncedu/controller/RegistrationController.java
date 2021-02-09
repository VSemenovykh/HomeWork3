package ru.ncedu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.validation.Errors;
import org.springframework.ui.Model;
import ru.ncedu.model.Registration;
import ru.ncedu.service.ListInformationUserService;

import javax.validation.Valid;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

/**
 * This class RegistrationController for controller
 * @version 1.0, 2 Feb 2021
 * @author Vladislav Semenovykh
 */
@Controller
public class RegistrationController{
    @Autowired
    private ListInformationUserService listInformationUserService;
    /**
     * This controller for processing request GET
     * @param model
     * @return registration.html
     */
    @RequestMapping(value="/registration", method= RequestMethod.GET)
    public String registrationForm(Model model) {
        model.addAttribute("registration", new Registration());
        return "registration";
    }

    /**
     * This controller for  processing request POST
     * The method are registration user and writing data about it to a file
     * @param registration
     * @param errors
     * @param model
     * @return result.html if  all entered correctly, otherwise registration.html
     */
    @RequestMapping(value="/registration", method=RequestMethod.POST)
    public String ragistrationSubmit(@ModelAttribute @Valid Registration registration, Errors errors, Model model) {
        if(null != errors && errors.getErrorCount() > 0){
            return "registration";
        }else{
            model.addAttribute("registration", registration);

            StringBuffer outText = new StringBuffer();
            outText.append(registration.getLastName());
            outText.append(", " + registration.getFirstName());
            outText.append(", " + registration.getMiddleName());
            outText.append(", " + registration.getAge());
            outText.append(", " + registration.getEmail());
            outText.append(", " + registration.getSalary());
            outText.append(", " + registration.getWorkPlace());

            String nameFile = "registration.txt";

            File file = new File(nameFile);

            //Write to file
            try(BufferedWriter br = new BufferedWriter(new FileWriter(file,true))){          
                br.write(outText.toString() + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "result";
        }
    }
}
