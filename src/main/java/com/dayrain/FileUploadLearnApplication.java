package com.dayrain;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.dayrain.mapper")
public class FileUploadLearnApplication {

    public static void main(String[] args) {

        SpringApplication.run(FileUploadLearnApplication.class, args);
    }

}
