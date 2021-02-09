package ru.ncedu.service;

import org.springframework.stereotype.Service;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static java.nio.file.Files.exists;

/**
 * This class ListInformationUserService for service
 * @version 1.0, 2 Feb 2021
 * @author Vladislav Semenovykh
 */
@Service
public class ListInformationUserService {
    /**
     * This field for last name and first name pattern
     */
    private final String FIRSTLAST_PATTERN = "([A-Za-z-]+\\s[A-Za-z-]+)";

    /**
     * This field for information of user pattern
     */
    private final String INFO_PATTERN = "([A-Za-z-]+\\s)"+"([A-Za-z-]+\\s)"+"([A-Za-z-]+\\s)"
                                     + "(\\d+\\s+)"
                                     + "([A-Za-z-]{1,1}\\.)([A-Za-z-]+@[A-Za-z-]+\\.)([A-Za-z-]{2,}\\s)"
                                     + "([0123456789]+\\.[0]+\\s)"
                                     + "([\\w+\\s*]*)";

    private List<String> listUser;
    private Map<String,String> informationAboutUser;

    /**
     * The method to get field {@link #listUser}
     * @return listUser
     */
    public List<String> getListUser(){
        StringBuilder sb = new StringBuilder();
        this.listUser = new ArrayList<String>();
        this.informationAboutUser = new HashMap<String, String>();

        exists(Paths.get("registration.txt"));
        try {
            BufferedReader in = new BufferedReader(new FileReader(new File("registration.txt")));
            try {
                String s;
                Pattern pattern = Pattern.compile(FIRSTLAST_PATTERN);
                while ((s = in.readLine()) != null) {
                    Matcher matcher = pattern.matcher(s.replace(",",""));
                    while (matcher.find()){
                        this.listUser.add(matcher.group());
                        this.informationAboutUser.put(matcher.group(), s.replace(",",""));
                    }
                }
            } finally {
                in.close();
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
        return listUser;
    }

    /**
     * The method to get field {@link #informationAboutUser}
     * @return informationAboutUser
     */
    public Map<String,String> getInformationAboutUser(){
        getListUser();
        return this.informationAboutUser;
    }

    /**
     * The method to get last name
     * @return last name
     */
    public String getLastName(String key){
        Pattern pattern = Pattern.compile(INFO_PATTERN);
        Matcher matcher = pattern.matcher(getInformationAboutUser().get(key));
        while (matcher.find()){
            return matcher.group(1);
        }
        return null;
    }

    /**
     * The method to get first name
     * @return first name
     */
    public String getFirstName(String key){
        Pattern pattern = Pattern.compile(INFO_PATTERN);
        Matcher matcher = pattern.matcher(getInformationAboutUser().get(key));
        while (matcher.find()){
            return matcher.group(2);
        }
        return null;
    }

    /**
     * The method to get middle name
     * @return middle name
     */
    public String getMiddleName(String key){
        Pattern pattern = Pattern.compile(INFO_PATTERN);
        Matcher matcher = pattern.matcher(getInformationAboutUser().get(key));
        while (matcher.find()){
            return matcher.group(3);
        }
        return null;
    }

    /**
     * The method to get age
     * @return age
     */
    public String getAge(String key){
        Pattern pattern = Pattern.compile(INFO_PATTERN);
        Matcher matcher = pattern.matcher(getInformationAboutUser().get(key));
        while (matcher.find()){
             return matcher.group(4);
        }
        return null;
    }

    /**
     * The method to get email
     * @return email
     */
    public String getEmail(String key){
        Pattern pattern = Pattern.compile(INFO_PATTERN);
        Matcher matcher = pattern.matcher(getInformationAboutUser().get(key));
        while (matcher.find()){
            return (matcher.group(5) + matcher.group(6) +  matcher.group(7));
        }
        return null;
    }

    /**
     * The method to get salary
     * @return salary
     */
    public String getSalary(String key){
        Pattern pattern = Pattern.compile(INFO_PATTERN);
        Matcher matcher = pattern.matcher(getInformationAboutUser().get(key));
        while (matcher.find()){
           return matcher.group(8);
        }
        return null;
    }

    /**
     * The method to get work place
     * @return work place
     */
    public String getWorkPlace(String key){
        Pattern pattern = Pattern.compile(INFO_PATTERN);
        Matcher matcher = pattern.matcher(getInformationAboutUser().get(key));
        while (matcher.find()){
            return  matcher.group(9);
        }
        return null;
    }
}
