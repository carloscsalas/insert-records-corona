package com.corona.insertrecords.service;

import com.corona.insertrecords.entity.*;
import com.google.gson.Gson;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.*;

@Service
@SuppressWarnings({ "deprecation", "unchecked" })
public class ParametryServiceImpl implements IParametryService {


    @Override
    public ResponseDto executeInsertParametries(RequestDto requestDto)  {
        Gson gsonList = new Gson();
        ResponseDto responseDto = null;
        List<RequestMethod> listProcMethod = processXlsxToJson(requestDto.getTable_name());
        System.out.println("::listProcMethod:JSON:: "+gsonList.toJson(listProcMethod));

        for (RequestMethod reqMethod: listProcMethod){
            String response = executionTransaccionAPX(reqMethod);
            System.out.println(":::RESPONSE::: "+response);
        }
        System.out.println("::END:PROCESS:");
            responseDto = new ResponseDto();
            responseDto.setId(1);
            responseDto.setDescription("PROCESO FINALIZADO....");

        return responseDto;
    }

    private List<RequestMethod> processXlsxToJson(String table) {

        System.setProperty("javax.net.ssl.trustStore","app.keystore");
        System.setProperty("javax.net.ssl.trustStorePassword","Ginogn16");

        List sheetData = new ArrayList();

        FileInputStream fis = null;
        try {
            //Se carga el archivo, aqui cambia la direccion para cargar tu archivo
            fis = new FileInputStream("D:\\WORKSPACE\\work\\records_corona.xlsx");

            //Se obtiene el libro de Excel
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            // Se obtiene la hoja del libro donde estan los datos
            XSSFSheet sheet = workbook.getSheetAt(0);

            Iterator rows = sheet.rowIterator();
            //While para recorrer filas
            while (rows.hasNext()) {
                XSSFRow row = (XSSFRow) rows.next();

                Iterator cells = row.cellIterator();
                List data = new ArrayList();
                // While para recorrer celdas
                while (cells.hasNext()) {
                    XSSFCell cell = (XSSFCell) cells.next();
                    data.add(cell);
                }
                //Se agregan al objeto List
                sheetData.add(data);
            }
        } catch (IOException e) {
            System.out.println("Error IOException en leer archivo Service Implement: " + e.getMessage());
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        // Termina try-catch-finally--------------------------------------------------------

        JSONObject innerObj = null;
        JSONObject  objFinal = new JSONObject();
        List<ReferenceDTO> referenceDTOS = null;
        ReferenceDTO referenceDTO = null;
        FormatDTO formatDTO = null;

        List<RequestMethod> methodList = new ArrayList<>();
        RequestMethod requestMethod =null;

        for (int i = 1; i < sheetData.size(); i++) {

            List list = (List) sheetData.get(i);

            for (int j = 0; j < list.size(); j++) {
                Cell cell = (Cell) list.get(j);
                //Se ponen nombres de las propiedades y se le asigna el valor dependiendo del indicador del arreglo
                //if(j==0){innerObj.put("items_comparison_method_type", Double.valueOf(cell.toString()));}
                if(j==0){
                    requestMethod = new RequestMethod();
                    ParameterTypeDTO parameterTypeDTO = new ParameterTypeDTO();
                    parameterTypeDTO.setId("METHOD");
                    requestMethod.setParameterType(parameterTypeDTO);
                    ClassifyTransactionTypeDTO classifyTransactionType = new ClassifyTransactionTypeDTO();
                    classifyTransactionType.setId( cell.toString());
                    requestMethod.setClassifyTransactionType(classifyTransactionType);

                }
                if(j==1){
                    referenceDTOS = new ArrayList<>();
                    referenceDTO = new ReferenceDTO();
                    referenceDTO.setPosition(Double.valueOf(cell.toString()).intValue());
                    //innerObj.put("item_first_ref_star_pos_number", );
                }
                if(j==2){
                    formatDTO = new FormatDTO();
                    formatDTO.setValue(cell.toString());
                    //innerObj.put("item_first_ref_format_desc", cell.toString());
                }
                if(j==3){
                    referenceDTO.setTransactionOrigin(cell.toString());
                    //innerObj.put("item_first_origin_type", cell.toString());
                }
                if(j==4){
                    formatDTO.setSize(Double.valueOf(cell.toString()).intValue());
                    referenceDTO.setFormat(formatDTO);
                    referenceDTOS.add(referenceDTO);
                    //innerObj.put("format_length_number_one", cell.toString());
                }
                if(j==5){
                    referenceDTO = new ReferenceDTO();
                    referenceDTO.setPosition(Double.valueOf(cell.toString()).intValue());
                    //innerObj.put("item_secnd_ref_star_pos_number", cell.toString());
                }
                if(j==6){
                    formatDTO = new FormatDTO();
                    formatDTO.setValue(cell.toString());
                    //innerObj.put("item_second_ref_format_desc", cell.toString());
                }
                if(j==7){
                    referenceDTO.setTransactionOrigin(cell.toString());
                    //innerObj.put("item_second_origin_type", cell.toString());
                }
                if(j==8){
                    formatDTO.setSize(Double.valueOf(cell.toString()).intValue());
                    referenceDTO.setFormat(formatDTO);
                    referenceDTOS.add(referenceDTO);
                    //innerObj.put("format_length_number", cell.toString());
                    requestMethod.setReferences(referenceDTOS);
//                    innerObj.put("references", gson.toJson(referenceDTOS));
                }
                if(j==9){
                    requestMethod.setDescription(cell.toString());
                }
                if(j==10){
                    requestMethod.setValidityDate(cell.toString());
                }

            }
            // Se van agregando todos los objetos JSON que se van generando
//            objFinal.put(String.valueOf(i), innerObj);
            methodList.add(requestMethod);
        }

        return methodList;
    }

    private String executionTransaccionAPX(RequestMethod reqMethod){
        String returnExecution;
        Gson gson = new Gson();
        InputStream inputStream = null;
        try(CloseableHttpClient client = HttpClients.createDefault()){
            HttpPost httpPost = new HttpPost(Constants.URI_BASE_APX_DEV.concat(Constants.URI_APX));
//        String json = "{"id":1,"name":"John"}";
            // String jsonResult = processXlsxFileToJson(requestDto.getTable_name());

            StringEntity entity = new StringEntity(gson.toJson(reqMethod));
            httpPost.setEntity(entity);
            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-Type", "application/json");
            httpPost.setHeader("header-name", "QP06");
            httpPost.setHeader("logical-transaction-code", "PCTXT200");
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
            httpPost.setHeader("channel-code", "CC");
            httpPost.setHeader("environ-code", "01");
            httpPost.setHeader("product-code", "0001");
            httpPost.setHeader("language-code", "PE");
            httpPost.setHeader("user-code", "ZG13001");
            httpPost.setHeader("operation-date", "20210105");
            httpPost.setHeader("operation-time", "103000");
            httpPost.setHeader("currency-code", "PEN");
            httpPost.setHeader("secondary-currency-code", "604");
            httpPost.setHeader("request-id", "PCTXT200-01-PE");
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

//            System.out.println("::httphost:URI: "+httpPost.getURI());
            CloseableHttpResponse response = client.execute(httpPost);
//            Arrays.stream(response.getAllHeaders()).forEach(header -> System.out.println("ALLHEADERS - HEADER:: "+header));
            HttpEntity entityhttp = response.getEntity();
            String entityResult = EntityUtils.toString(entityhttp);
            JSONObject jsonObject = new JSONObject(entityResult);
            System.out.println("::JSONObject::jsonObject:: "+jsonObject);
            if (entityResult.contains("ERROR")){
                JSONArray jsonArray = jsonObject.getJSONArray("messages");
                JSONObject jsonObjectMes = jsonArray.getJSONObject(0);
                returnExecution = jsonObjectMes.getString("message");
            }else{
                returnExecution = "REGISTRO REALIZADO CON EXITO";
            }
            /**
            System.out.println(":[Parametry]:: returnExecution:: "+returnExecution);
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
            */

        }catch (Exception ioe){
            System.out.println("::IOException:: "+ioe);
            returnExecution = "ERROR-EXCEPTION";
        }

        return returnExecution;
    }
}
