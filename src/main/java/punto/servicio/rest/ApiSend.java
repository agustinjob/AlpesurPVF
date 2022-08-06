package punto.servicio.rest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import com.google.gson.Gson;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ContentType;
import punto.venta.configuracion.Configuracion;
import punto.venta.modelo.ConfiguracionModelo;
import punto.venta.modelo.CorteModelo;
import punto.venta.modelo.Usuario;
import punto.venta.modelo.response.AreaResponse;
import punto.venta.modelo.response.ClienteResponse;
import punto.venta.modelo.response.CreditoResponse;
import punto.venta.modelo.response.MovimientosExtrasResponse;
import punto.venta.modelo.response.MovimientosInvResponse;
import punto.venta.modelo.response.ProductoResponse;
import punto.venta.modelo.response.ProductoUtilidadResponse;
import punto.venta.modelo.response.ResponseGeneral;
import punto.venta.modelo.response.SucursalResponse;
import punto.venta.modelo.response.TicketResponse;
import punto.venta.modelo.response.UsuarioResponse;
import punto.venta.modelo.response.VentasResponse;

/**
 *
 * @author agus_
 */
public class ApiSend {

    /*public static void main(String[] args) {

        try {
              Usuario u= new Usuario();
              
        u.setNombre("XXX Agustin Job");
        u.setPassword("123");
        u.setUsername("username");
        u.setTipoUsuario("Administrador");
        u.setDireccion("Oriente 2 No 38 colonia centro");
            String result = usarAPI("http://localhost/administracion/logic/api/usuariosapi.php?tipo=registrar",u,"POST");
            System.out.println("Este es el resultado = " + result);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
     */
    public TicketResponse usarAPITicket(String url, Object obj) {
         ContentType contentType = ContentType.APPLICATION_JSON;
        TicketResponse res = new TicketResponse();

        HttpPost envio = new HttpPost(url);
            Gson gson = new Gson();
            // System.out.println(url);
            System.out.println(gson.toJson(obj));
            envio.setEntity(new StringEntity(gson.toJson(obj), contentType));

            try ( CloseableHttpClient httpClient = HttpClients.createDefault();  CloseableHttpResponse response = httpClient.execute(envio)) {

                res = gson.fromJson(EntityUtils.toString(response.getEntity()), TicketResponse.class);

            } catch (IOException ex) {
                Logger.getLogger(ApiSend.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            return res;
        
    }
    
    public ResponseGeneral usarAPI(String url, Object obj, String tipo) {
        ContentType contentType = ContentType.APPLICATION_JSON;
        ResponseGeneral res = new ResponseGeneral();
        if (tipo.equalsIgnoreCase("POST")) {
            HttpPost envio = new HttpPost(url);
            Gson gson = new Gson();
            // System.out.println(url);
            System.out.println(gson.toJson(obj));
            envio.setEntity(new StringEntity(gson.toJson(obj), contentType));

            try ( CloseableHttpClient httpClient = HttpClients.createDefault();  CloseableHttpResponse response = httpClient.execute(envio)) {

                res = gson.fromJson(EntityUtils.toString(response.getEntity()), ResponseGeneral.class);

            } catch (IOException ex) {
                Logger.getLogger(ApiSend.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (tipo.equalsIgnoreCase("PUT")) {
            HttpPut envio = new HttpPut(url);
            Gson gson = new Gson();

            // StringBuilder json = new StringBuilder();
            envio.setEntity(new StringEntity(gson.toJson(obj), contentType));

            try ( CloseableHttpClient httpClient = HttpClients.createDefault();  CloseableHttpResponse response = httpClient.execute(envio)) {

                res = gson.fromJson(EntityUtils.toString(response.getEntity()), ResponseGeneral.class);

            } catch (IOException ex) {
                Logger.getLogger(ApiSend.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (tipo.equalsIgnoreCase("DELETE")) {

            HttpDelete envio = new HttpDelete(url);
            Gson gson = new Gson();
            try ( CloseableHttpClient httpClient = HttpClients.createDefault();  CloseableHttpResponse response = httpClient.execute(envio)) {

                res = gson.fromJson(EntityUtils.toString(response.getEntity()), ResponseGeneral.class);

            } catch (IOException ex) {
                Logger.getLogger(ApiSend.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (tipo.equalsIgnoreCase("GET")) {
            HttpGet envio = new HttpGet(url);
            Gson gson = new Gson();

            try ( CloseableHttpClient httpClient = HttpClients.createDefault();  CloseableHttpResponse response = httpClient.execute(envio)) {

                res = gson.fromJson(EntityUtils.toString(response.getEntity()), ResponseGeneral.class);

            } catch (IOException ex) {
                Logger.getLogger(ApiSend.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return res;
    }

    public UsuarioResponse getUsuarios(String url) {
        HttpGet envio = new HttpGet(url);
        Gson gson = new Gson();
        UsuarioResponse pro = new UsuarioResponse();

        try ( CloseableHttpClient httpClient = HttpClients.createDefault();  CloseableHttpResponse response = httpClient.execute(envio)) {
            pro = gson.fromJson(EntityUtils.toString(response.getEntity()), UsuarioResponse.class);

        } catch (IOException ex) {
            Logger.getLogger(ApiSend.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pro;
    }
    
       public ConfiguracionModelo getConfiguracion(String url) {
        HttpGet envio = new HttpGet(url);
        Gson gson = new Gson();
        ConfiguracionModelo pro = new ConfiguracionModelo();

        try ( CloseableHttpClient httpClient = HttpClients.createDefault();  CloseableHttpResponse response = httpClient.execute(envio)) {
            pro = gson.fromJson(EntityUtils.toString(response.getEntity()), ConfiguracionModelo.class);

        } catch (IOException ex) {
            Logger.getLogger(ApiSend.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pro;
    }
         public TicketResponse getTicket(String url) {
        HttpGet envio = new HttpGet(url);
        Gson gson = new Gson();
        TicketResponse pro = new TicketResponse();

        try ( CloseableHttpClient httpClient = HttpClients.createDefault();  CloseableHttpResponse response = httpClient.execute(envio)) {
            pro = gson.fromJson(EntityUtils.toString(response.getEntity()), TicketResponse.class);

        } catch (IOException ex) {
            Logger.getLogger(ApiSend.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pro;
    }
    
        public SucursalResponse getSucursales(String url) {
        HttpGet envio = new HttpGet(url);
        Gson gson = new Gson();
        SucursalResponse pro = new SucursalResponse();

        try ( CloseableHttpClient httpClient = HttpClients.createDefault();  CloseableHttpResponse response = httpClient.execute(envio)) {
             pro = gson.fromJson(EntityUtils.toString(response.getEntity()), SucursalResponse.class);

        } catch (IOException ex) {
            Logger.getLogger(ApiSend.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pro;
    }

    public String getDato(String url) {
        HttpGet envio = new HttpGet(url);
        Gson gson = new Gson();
        String pro = "";

        try ( CloseableHttpClient httpClient = HttpClients.createDefault();  CloseableHttpResponse response = httpClient.execute(envio)) {
            pro = gson.fromJson(EntityUtils.toString(response.getEntity()), String.class);

        } catch (IOException ex) {
            Logger.getLogger(ApiSend.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pro;
    }

    public ClienteResponse getClientes(String url) {
        HttpGet envio = new HttpGet(url);
        Gson gson = new Gson();
        ClienteResponse pro = new ClienteResponse();

        try ( CloseableHttpClient httpClient = HttpClients.createDefault();  CloseableHttpResponse response = httpClient.execute(envio)) {
            pro = gson.fromJson(EntityUtils.toString(response.getEntity()), ClienteResponse.class);

        } catch (IOException ex) {
            Logger.getLogger(ApiSend.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pro;
    }

    public CreditoResponse getCredito(String url) {
        HttpGet envio = new HttpGet(url);
        Gson gson = new Gson();
        CreditoResponse pro = new CreditoResponse();

        try ( CloseableHttpClient httpClient = HttpClients.createDefault();  CloseableHttpResponse response = httpClient.execute(envio)) {
            pro = gson.fromJson(EntityUtils.toString(response.getEntity()), CreditoResponse.class);

        } catch (IOException ex) {
            Logger.getLogger(ApiSend.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pro;
    }

    public MovimientosInvResponse getMovimientosInv(String url) {
        HttpGet envio = new HttpGet(url);
        Gson gson = new Gson();
        MovimientosInvResponse pro = new MovimientosInvResponse();

        try ( CloseableHttpClient httpClient = HttpClients.createDefault();  CloseableHttpResponse response = httpClient.execute(envio)) {
            pro = gson.fromJson(EntityUtils.toString(response.getEntity()), MovimientosInvResponse.class);

        } catch (IOException ex) {
            Logger.getLogger(ApiSend.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pro;
    }

    public MovimientosExtrasResponse getMovimientosExtras(String url, Object obj) {
        ContentType contentType = ContentType.APPLICATION_JSON;
        MovimientosExtrasResponse pro = new MovimientosExtrasResponse();

        HttpPost envio = new HttpPost(url);
        Gson gson = new Gson();
        // System.out.println(url);

        envio.setEntity(new StringEntity(gson.toJson(obj), contentType));

        try ( CloseableHttpClient httpClient = HttpClients.createDefault();  CloseableHttpResponse response = httpClient.execute(envio)) {

            pro = gson.fromJson(EntityUtils.toString(response.getEntity()), MovimientosExtrasResponse.class);

        } catch (IOException ex) {
            Logger.getLogger(ApiSend.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pro;
    }

    public MovimientosExtrasResponse getMovimientosExtrasGET(String url) {

        MovimientosExtrasResponse pro = new MovimientosExtrasResponse();

        HttpGet envio = new HttpGet(url);
        Gson gson = new Gson();
        try ( CloseableHttpClient httpClient = HttpClients.createDefault();  CloseableHttpResponse response = httpClient.execute(envio)) {

            pro = gson.fromJson(EntityUtils.toString(response.getEntity()), MovimientosExtrasResponse.class);

        } catch (IOException ex) {
            Logger.getLogger(ApiSend.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pro;
    }
    
       public CorteModelo getCorteModeloGET(String url) {

        CorteModelo pro = new CorteModelo();

        HttpGet envio = new HttpGet(url);
        Gson gson = new Gson();
        try ( CloseableHttpClient httpClient = HttpClients.createDefault();  CloseableHttpResponse response = httpClient.execute(envio)) {

            pro = gson.fromJson(EntityUtils.toString(response.getEntity()), CorteModelo.class);

        } catch (IOException ex) {
            Logger.getLogger(ApiSend.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pro;
    }

    public VentasResponse getVentas(String url) {
        HttpGet envio = new HttpGet(url);
        Gson gson = new Gson();
        VentasResponse pro = new VentasResponse();

        try ( CloseableHttpClient httpClient = HttpClients.createDefault();  CloseableHttpResponse response = httpClient.execute(envio)) {
            pro = gson.fromJson(EntityUtils.toString(response.getEntity()), VentasResponse.class);

        } catch (IOException ex) {
            Logger.getLogger(ApiSend.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pro;
    }

    public VentasResponse getVentas(String url, Object obj) {
        HttpPost envio = new HttpPost(url);
        Gson gson = new Gson();
        ContentType contentType = ContentType.APPLICATION_JSON;
        VentasResponse res = new VentasResponse();
        // System.out.println(url);

        envio.setEntity(new StringEntity(gson.toJson(obj), contentType));

        try ( CloseableHttpClient httpClient = HttpClients.createDefault();  CloseableHttpResponse response = httpClient.execute(envio)) {

            res = gson.fromJson(EntityUtils.toString(response.getEntity()), VentasResponse.class);

        } catch (IOException ex) {
            Logger.getLogger(ApiSend.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    public ProductoResponse getProductos(String url) {
        HttpGet envio = new HttpGet(url);
        Gson gson = new Gson();
        ProductoResponse pro = new ProductoResponse();

        try ( CloseableHttpClient httpClient = HttpClients.createDefault();  CloseableHttpResponse response = httpClient.execute(envio)) {
            pro = gson.fromJson(EntityUtils.toString(response.getEntity()), ProductoResponse.class);

        } catch (IOException ex) {
            Logger.getLogger(ApiSend.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pro;
    }

    public ProductoUtilidadResponse getProductosUtilidad(String url) {
        HttpGet envio = new HttpGet(url);
        Gson gson = new Gson();
        ProductoUtilidadResponse pro = new ProductoUtilidadResponse();

        try ( CloseableHttpClient httpClient = HttpClients.createDefault();  CloseableHttpResponse response = httpClient.execute(envio)) {
            pro = gson.fromJson(EntityUtils.toString(response.getEntity()), ProductoUtilidadResponse.class);

        } catch (IOException ex) {
            Logger.getLogger(ApiSend.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pro;
    }

    public AreaResponse getAreas(String url) {
        HttpGet envio = new HttpGet(url);
        Gson gson = new Gson();
        AreaResponse pro = new AreaResponse();

        try ( CloseableHttpClient httpClient = HttpClients.createDefault();  CloseableHttpResponse response = httpClient.execute(envio)) {
            pro = gson.fromJson(EntityUtils.toString(response.getEntity()), AreaResponse.class);

        } catch (IOException ex) {
            Logger.getLogger(ApiSend.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pro;
    }

    /*
        public ProductoPacienteResponse getProductoPacientes(String url){
     HttpGet envio = new HttpGet(url);
         Gson gson= new Gson();
         ProductoPacienteResponse pro = new ProductoPacienteResponse();

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(envio)) {
        
            
          pro= gson.fromJson(EntityUtils.toString(response.getEntity()), ProductoPacienteResponse.class);  
         
        } catch (IOException ex) {
            Logger.getLogger(ApiSend.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pro;
    }
     */
}
