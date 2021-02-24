package com.org.hu.controller;

import com.org.hu.config.CaptchaConfig;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;

@RestController
public class CaptchaController {

    @ApiOperation("图形验证码")
    @GetMapping(value = "/captcha",produces = "image/jpeg")
    public void captcha(HttpServletRequest request, HttpServletResponse response){
        String verifyCode = CaptchaConfig.generateVerifyCode(4);
        HttpSession session=request.getSession();
        session.setAttribute("captcha",verifyCode);
        System.out.println(verifyCode);
        int w=150;
        int h=80;
        OutputStream outputStream=null;
        try {
            outputStream=response.getOutputStream();
            CaptchaConfig.outputImage(w, h, outputStream, verifyCode);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(null!=outputStream){
                try {
                    outputStream.close();
                }catch (IOException e1){
                    e1.printStackTrace();
                }
            }
        }
    }
}
