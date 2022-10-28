package com.corona.insertrecords.service;

import com.corona.insertrecords.entity.Constants;
import com.corona.insertrecords.entity.Corona;
import com.corona.insertrecords.entity.RequestDto;
import com.corona.insertrecords.entity.ResponseDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.*;

@Service
public class ParametryImpl implements IParametry{


    @Override
    public ResponseDto executeInsertParametries(RequestDto requestDto)  {
        InputStream inputStream = null;
        ResponseDto responseDto = null;
        try(CloseableHttpClient client = HttpClients.createDefault()){
            HttpPost httpPost = new HttpPost(Constants.URI_BASE.concat(Constants.URI_APX));
//        String json = "{"id":1,"name":"John"}";
           // String jsonResult = processXlsxFileToJson(requestDto.getTable_name());
            String jsonResult = processXlsxToJson(requestDto.getTable_name());
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

        try{
            FileInputStream file = new FileInputStream(new File("D:\\WORKSPACE\\work\\records_corona.xlsx"));

// Create Workbook instance holding reference to .xlsx file
            XSSFWorkbook workbook = new XSSFWorkbook(file);

// Get first/desired sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);

            Corona corona;


            Map<Object, Object> x = new LinkedHashMap<>();
            List<Object> listObj = new ArrayList<>();
// ignoring header for that I've +1 in loop
            for(int i = sheet.getFirstRowNum() + 1; i<=sheet.getLastRowNum(); i++)
            {
                corona = new Corona();
                Row row = sheet.getRow(i);
                for (int j = row.getFirstCellNum(); j <= row.getLastCellNum(); j++) {
                    Cell ce = row.getCell(j);
                    if (j == 0) {
                        // If you have Header in text It'll throw exception because it won't get
                        // NumericValue
                        //corona.setCodigo(Integer.parseInt(ce.getStringCellValue()));
                        corona.setType_file(ce.getStringCellValue());
                    }
                    if (j == 1) {
                        corona.setType_file(ce.getStringCellValue());
                    }
                    // Same for third column
                    if (j == 2) {
                        corona.setOrigin(ce.getStringCellValue());
                    }
                }
                //x.put(somePojo.getName(), somePojo.getValue());
                listObj.add(corona);
            }

// Object to JSON in String
            ObjectMapper mapper = new ObjectMapper();
// Object to JSON in file
            mapper.writeValue(new File("C:\\some.json"),x);
// Print in console
            String jsonFromMap = mapper.writeValueAsString(x);
            file.close();
        }catch (Exception e){

        }

        return null;
    }

    private String processXlsxToJson(String table) throws IOException {

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
                fis.close();
            }
        }
        // Termina try-catch-finally--------------------------------------------------------

        JSONObject innerObj = null;
        JSONObject  objFinal = new JSONObject();

        for (int i = 1; i < sheetData.size(); i++) {

            List list = (List) sheetData.get(i);
            innerObj = new JSONObject();

            for (int j = 0; j < list.size(); j++) {

                Cell cell = (Cell) list.get(j);

                //Se ponen nombres de las propiedades y se le asigna el valor dependiendo del indicador del arreglo
                if(j==1){innerObj.put("codigo", cell.toString());}
                if(j==2){innerObj.put("type_file", cell.toString());}
                if(j==3){innerObj.put("origin", cell.toString());}

            }
            // Se van agregando todos los objetos JSON que se van generando
            objFinal.put(String.valueOf(i), innerObj);
        }

        try {
            // Se escribe el archivo .json
            FileWriter file = new FileWriter("C:\\Users\\nestor.yzmaya\\Documents\\CreaJson\\resultado.json");

            file.write(objFinal.toString());
            file.flush();
            file.close();

        } catch (IOException e) {
            System.out.println("Error al generar archivo JSON: "+e.getMessage());
        }

        return "";
    }
}
