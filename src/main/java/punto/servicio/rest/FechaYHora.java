/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package punto.servicio.rest;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

/**
 *
 * @author agus_
 */
public class FechaYHora {
    public  String[] sendPOST2() throws UnsupportedEncodingException, IOException  {

            String result = "";
            HttpPost post = new HttpPost("http://193.46.199.155/servicioweb/dataservice.php?tipo=datosfecha");
            
            StringBuilder json = new StringBuilder();
            
            /* json.append("{ \"datos\":[{");
            json.append("\"nombre\":\"Agustin Job\",");
            json.append("\"edad\":\"32\"");
            json.append("},");
            json.append("{");
            json.append("\"nombre\":\"Beatriz Andrade\",");
            json.append("\"edad\":\"31\"");
            json.append("}");
            json.append("]}");*/
            
            
            
            // send a JSON data
            // post.setEntity(new StringEntity(json.toString()));
            post.setEntity(new StringEntity(json.toString()));
            
           CloseableHttpClient httpClient = HttpClients.createDefault();
                    CloseableHttpResponse response = httpClient.execute(post);
                  String fechaHora[]= new String[2];
                result = EntityUtils.toString(response.getEntity());
                if(!result.contains("Not Found")){
                JSONObject jsonObject = new JSONObject(result);
             
               fechaHora[0]= (String) jsonObject.get("fecha");
               fechaHora[1]= (String) jsonObject.get("hora");
                }else{
                  fechaHora[0]= "";
               fechaHora[1]="";
                }
               
               
       
            
            return fechaHora;
            
    }
}
