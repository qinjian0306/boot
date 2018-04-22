package com.qj.springboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

/**
 * 文件上传
 */
@RestController
public class FileUploadController {

    @Value("${filepath}")
    private String filepath;

    @RequestMapping("/upload")
    public String fileUpload(MultipartFile file)throws Exception{
        // aaa.jpg --->  .jpg
        String extName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        String nowFileName = UUID.randomUUID().toString().replace("-","").substring(0,6) + extName;
        // 上传
        FileCopyUtils.copy(file.getInputStream(),new FileOutputStream(new File(filepath + nowFileName)));
        return "fileupload success";
    }
}
