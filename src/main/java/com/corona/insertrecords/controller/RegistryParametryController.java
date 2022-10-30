package com.corona.insertrecords.controller;

import com.corona.insertrecords.entity.RequestDto;
import com.corona.insertrecords.entity.ResponseDto;
import com.corona.insertrecords.service.IParametryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class RegistryParametryController {

    @Autowired
    IParametryService parametryService;

    @PostMapping(value = "/create-parametry")
    public ResponseEntity<?> create(@RequestBody RequestDto requestDto){
        System.out.println("[CONTROLLER]:::requestDto:: "+requestDto);
        Map<String, Object> response = new HashMap<>();
        ResponseDto responseDto=null;
        try {
            responseDto = parametryService.executeInsertParametries(requestDto);
            System.out.println("[CONTROLLER]:::responseDto:: "+responseDto);
            if (responseDto.getId().equals(1)){
//                response.put("mensaje","Proceso de registro finalizado con exitó");
                response.put("parametria", responseDto);
            }else{
//                response.put("mensaje","Proceso de registro finalizado sin exitó");
                response.put("parametria", responseDto);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

}
