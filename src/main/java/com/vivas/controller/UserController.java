package com.vivas.controller;

import com.vivas.dto.ResponseObject;
import com.vivas.dto.User;
import com.vivas.utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

/**
 * Created by duyot on 9/30/2016.
 */
@RestController
@RequestMapping("/userservices")
public class UserController {
    Logger log = LoggerFactory.getLogger(UserController.class);


    @RequestMapping(value = "/findUser/{userId}")
    public User find(@PathVariable("userId") Long userId ){
        log.info("UserId: "+ userId);
        return new User("duyot","123456a@");
    }

    @RequestMapping(value = "/saveUser")
    public @ResponseBody ResponseObject  saveUser(@RequestBody User user){
        log.info("getting User:"+ user.getUsername());
        return new ResponseObject(Constants.STATUS_OK,"SUCCESS");

    }
}
