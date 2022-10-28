package com.corona.insertrecords;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class InsertRecordsCoronaApplication {

    public static void main(String[] args) {
        SpringApplication.run(InsertRecordsCoronaApplication.class, args);
    }

}
