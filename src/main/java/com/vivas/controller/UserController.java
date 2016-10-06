package com.vivas.controller;

import com.vivas.dto.ResponseObject;
import com.vivas.dto.User;
import com.vivas.enums.Responses;
import com.vivas.utils.Constants;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by duyot on 9/30/2016.
 */
@RestController
@RequestMapping("/userservices")
public class UserController {
    Logger log = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(value = "/getFile/{fileName:.+}")
    public void find(@PathVariable("fileName") String fileName,HttpServletResponse response){
        log.info("fileName: "+ fileName);
        try {
            InputStream is = getClass().getClassLoader().getResourceAsStream(fileName);
            IOUtils.copy(is,response.getOutputStream());
            response.flushBuffer();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/findUser/{userId}")
    public User find(@PathVariable("userId") Long userId,HttpServletRequest request){
        log.info("UserId: "+ userId);
        log.info("Host: "+ request.getHeader("Host"));
        return new User("duyot","123456a@");
    }

    @RequestMapping(value = "/deleteUser/{userId}")
    public ResponseObject delete(@PathVariable("userId") Long userId ){
        log.info("Deleting : "+ userId);
        return new ResponseObject(Responses.ERROR.getCode(),Responses.ERROR.getName(),userId+"");
    }

    @RequestMapping(value = "/saveUser",produces = "application/json")
    public ResponseObject  saveUser(@RequestBody User user){
        log.info("getting User:"+ user.getUsername());
        return new ResponseObject(Responses.SUCCESS.getCode(),Responses.SUCCESS.getName(),user.getUsername());

    }
}
