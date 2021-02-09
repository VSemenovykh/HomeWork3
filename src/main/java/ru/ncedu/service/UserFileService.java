package ru.ncedu.service;

import org.springframework.stereotype.Service;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * This class UserFileService for service
 * @version 1.0, 2 Feb 2021
 * @author Vladislav Semenovykh
 */
@Service
public class UserFileService {
    private List<String> listInformation;
    private Path path;

    /**
     * Procedure for determination field {@link #path}
     * @param path
     */
    public void setPath(Path path){
        this.path=path;
    }

    /**
     * Method to get field {@link #path}
     * @return path
     */
    public Path getPath(){
        return this.path;
    }

    /**
     * Method to get field {@link #listInformation}
     * @return listInformation
     */
    public List<String> getListInformation(){
        this.listInformation = new ArrayList<String>();
        try {
            BufferedReader in = new BufferedReader(new FileReader( new File(getPath().getFileName().toString())));
            try {
                String s;
                while ((s = in.readLine()) != null) {
                    this.listInformation.add(new String(s.replace(",","")));
                }
            } finally {
                in.close();
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
        return  this.listInformation;
    }
}
