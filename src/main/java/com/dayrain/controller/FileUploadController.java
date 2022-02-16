package com.dayrain.controller;

import com.dayrain.entity.UploadEntity;
import com.dayrain.service.FileUploadService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

@EnableTransactionManagement
@RestController

@MapperScan("com.dayrain.mapper")
public class FileUploadController {

    @Autowired
    FileUploadService fileUploadService;

    //使用默认路径
    @RequestMapping("/upload")
    public String upload(MultipartFile file) throws  Exception{
        fileUploadService.upload(file,null);

        return null;
    }

    //自定义路径
    @RequestMapping("/upload/template")
    public String uploadPlace(MultipartFile file) throws  Exception{
        fileUploadService.upload(file,"E:\\temp");

        return null;
    }

    //下载
    @GetMapping("/download/file")
    public String downloadFile(HttpServletResponse response) throws IOException {
        fileUploadService.download(response, "上传模板");

        return null;
    }


    //下载
    @RequestMapping("/download")
    public ResponseEntity download() throws Exception
    {
        FileSystemResource file=new FileSystemResource("E:\\temp\\毕设选题.txt");
        HttpHeaders headers=new HttpHeaders();
        headers.add("Content-Disposition","attachment;filename=newfile.txt");
        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(file.contentLength())
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(new InputStreamResource(file.getInputStream()));
    }

    //删除文件信息





}
