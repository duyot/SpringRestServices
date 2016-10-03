package com.vivas.clienttest;

import com.vivas.dto.ResponseObject;
import com.vivas.dto.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * Created by duyot on 10/3/2016.
 */
public class ClientTest {
    public static final String TEST__PARAMS_URI = "http://localhost:8080//SpringRestServices/services/userservices/findUser/{id}";
    public static final String TEST__POST_OBJECT_URI = "http://localhost:8080//SpringRestServices/services/userservices/saveUser";

    public static void main(String[] args) {
        ClientTest.testSendObject(new User("sdf","sdf"));
    }

    /*
        test send params through uri
     */
    public static void testFindUser(String id){
        RestTemplate restTemplate = new RestTemplate();
        User responseEntity = restTemplate.getForObject(TEST__PARAMS_URI, User.class,2);

        System.out.println(responseEntity.getUsername());
    }

    /*
        test submit object
     */
    public static void testSendObject(User requestUser){
        RestTemplate restTemplate = new RestTemplate();
        ResponseObject reponseUser = restTemplate.postForObject(TEST__POST_OBJECT_URI,requestUser,ResponseObject.class);
        System.out.println(reponseUser.getStatusCode());
    }
}
