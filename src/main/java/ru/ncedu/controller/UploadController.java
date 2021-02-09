package ru.ncedu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.ncedu.service.UserFileService;
import org.springframework.ui.Model;
import ru.ncedu.model.User;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * This class UploadController for controller
 * @version 1.0, 2 Feb 2021
 * @author Vladislav Semenovykh
 */
@Controller
public class UploadController {
    @Autowired
    private UserFileService userFileService;

    /**
     * This controller for  processing request GET
     * @param model
     * @return upload.html
     */
    @RequestMapping(value="/upload", method= RequestMethod.GET)
    public String uploadForm(Model model) {
        model.addAttribute("user", new User());
        return "upload";
    }

    /**
     * This controller for  processing request POST
     * The method are upload an external file with additional information about of user
     * and display this information
     * @param user
     * @param file
     * @param model
     * @return uploadStatus.html where get out message "You successfully uploaded" if file upload,
     *         otherwise get out message "Please select a file to upload"
     */
    @RequestMapping(value="/upload", method=RequestMethod.POST)
    public String singleFileUploadSubmit(@ModelAttribute User user, @RequestParam("file") MultipartFile file,
                                         Model model) {
        if (file.isEmpty()) {
            model.addAttribute("message", "Please select a file to upload");
            return "uploadStatus";
        }

        String lastFirst = (user.getLastName() + " " + user.getFirstName());

        try {
            //Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get( file.getOriginalFilename() + "-" + lastFirst.toString());
            Files.write(path, bytes);

            //Write last name and first name to the file
            BufferedWriter out = new BufferedWriter(new FileWriter(path.getFileName().toString(), true));
            out.newLine();
            out.write(new StringBuilder().append(lastFirst).toString());
            out.close();

            userFileService.setPath(path);

            //Display
            model.addAttribute("lastName", user.getLastName());
            model.addAttribute("firstName", user.getFirstName());
            model.addAttribute("listInformation", userFileService.getListInformation());
            model.addAttribute("message",   "You successfully uploaded '" + file.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "uploadStatus";
    }
}