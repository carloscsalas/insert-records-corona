package com.corona.insertrecords.service;

import com.corona.insertrecords.entity.Constants;
import com.corona.insertrecords.entity.RequestDto;
import com.corona.insertrecords.entity.ResponseDto;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

@Service
public class ParametryImpl implements IParametry{


    @Override
    public ResponseDto executeInsertParametries(RequestDto requestDto)  {
        InputStream inputStream = null;
        ResponseDto responseDto = null;
        try(CloseableHttpClient client = HttpClients.createDefault()){
            HttpPost httpPost = new HttpPost(Constants.URI_BASE.concat(Constants.URI_APX));
//        String json = "{"id":1,"name":"John"}";
            StringEntity entity = new StringEntity("json_request_in_string");
            httpPost.setEntity(entity);
            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-Type", "application/json");
            httpPost.setHeader("header-name", "QP06");
            httpPost.setHeader("logical-transaction-code", "PREST002");
            httpPost.setHeader("type-code", "15");
            httpPost.setHeader("subtype-code", "17");
            httpPost.setHeader("version-code", "01");
            httpPost.setHeader("country-code", "PE");
            httpPost.setHeader("entity-code", "0011");
            httpPost.setHeader("branch-code", "0486");
            httpPost.setHeader("workstation-code", "W963");
            httpPost.setHeader("operative-entity-code", "0011");
            httpPost.setHeader("operative-branch-code", "0486");
            httpPost.setHeader("ip-address", "118.222.161.30");
            httpPost.setHeader("channel-code", "01");
            httpPost.setHeader("environ-code", "01");
            httpPost.setHeader("product-code", "0001");
            httpPost.setHeader("language-code", "ES");
            httpPost.setHeader("user-code", "ZG13001");
            httpPost.setHeader("operation-date", "20210105");
            httpPost.setHeader("operation-time", "103000");
            httpPost.setHeader("currency-code", "PEN");
            httpPost.setHeader("secondary-currency-code", "604");
            httpPost.setHeader("request-id", "PREST002-01-PE");
            httpPost.setHeader("service-id", "012345678901234");
            httpPost.setHeader("client-identification-type", "L");
            httpPost.setHeader("client-document", "09313658");
            httpPost.setHeader("contact-identifier", "29071967");
            httpPost.setHeader("authorization-version", "09");
            httpPost.setHeader("authorization-code", "15172027");
            httpPost.setHeader("accounting-terminal", "001");
            httpPost.setHeader("logical-terminal", "01");
            httpPost.setHeader("origin", "Onboarding");
            httpPost.setHeader("agent-user", "p028162");
            httpPost.setHeader("manager-user", "p028162");
            httpPost.setHeader("mac", "E8-6A-64-F7-B007");
            httpPost.setHeader("remaining-time", "235959");

            CloseableHttpResponse response = client.execute(httpPost);
            Arrays.stream(response.getAllHeaders()).forEach(header -> System.out.println("ALLHEADERS - HEADER:: "+header));
            HttpEntity entityhttp = response.getEntity();
            String entityResult = EntityUtils.toString(entityhttp);
            System.out.println("::entityResult:: "+entityResult);

            System.out.println("::entityhttp.getContent:: "+entityhttp.getContent().toString());

            inputStream = entity.getContent();

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"), 8);
            StringBuilder sb = new StringBuilder();

            String line = null;
            while ((line = reader.readLine()) != null)
            {
                sb.append(line + "\n");
            }
            String result = sb.toString();

            System.out.println(":::resultEntityStream:: "+result);
            responseDto = new ResponseDto();
            responseDto.setId(1);
            responseDto.setDescription("Inserción finalizo con exito!");
        }catch (IOException ioe){
            System.out.println("::IOException:: "+ioe.getMessage());
        }

        return responseDto;
    }


    private String processXlsxFileToJson(String fileName){

        return null;
    }
}
