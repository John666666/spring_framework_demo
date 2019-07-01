package com.john.spring.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller
public class UploadController {

    @RequestMapping("/upload")
    @ResponseBody
    public String upload3(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        String fileName = file.getOriginalFilename();
        try {
            file.transferTo(new File(request.getServletContext().getRealPath("/upload"), fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileName + "上传成功";
    }

}
