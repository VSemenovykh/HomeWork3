package ru.ncedu;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * This class SpringBootMyApplication for run spring boot application
 * @version 1.0, 2 Feb 2021
 * @author Vladislav Semenovykh
 */
@SpringBootApplication
@ServletComponentScan
public class SpringBootMyApplication {
    private int maxUploadSizeInMb = 10 * 1024 * 1024; // 10 MB

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMyApplication.class, args);
    }
}
