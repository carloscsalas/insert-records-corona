package com.corona.insertrecords;

import com.corona.insertrecords.entity.RequestDto;
import com.corona.insertrecords.entity.ResponseDto;
import com.corona.insertrecords.service.IParametryService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.Assert;

import java.io.IOException;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class InsertRecordsCoronaApplicationTests {

    @Autowired
    IParametryService parametry;

    @Test
    void contextLoads() throws IOException {

        RequestDto requestDto = new RequestDto();
        requestDto.setTable_name("T_PCTX_CONDITION_PARAMETRY");

        //ResponseDto responseDto = parametry.executeInsertParametries(requestDto);

        Assert.notNull(requestDto,"null");

    }

}
