import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoeda {

     public Moeda consultaMoeda(String base_code, String target_code,double amount) throws IOException, InterruptedException {
         String key = "8cf87be311d9ee3e93df2d53";

         //double amount = 100.0;

         //https://v6.exchangerate-api.com/v6/8cf87be311d9ee3e93df2d53/pair/BRL/USD/20.0
         URI url_str = URI.create("https://v6.exchangerate-api.com/v6/"+key+"/pair/"+ base_code+"/"+target_code+"/"+amount);
         HttpClient client = HttpClient.newHttpClient();
         HttpRequest request = HttpRequest.newBuilder()
                 .uri(url_str)
                 .build();


         HttpResponse<String> response = client
                 .send(request,HttpResponse.BodyHandlers.ofString());


         String json = response.body();
         Gson gson = new Gson();

         Moeda moedaExChangeRate = gson.fromJson(json,Moeda.class);
         //System.out.println(moedaExChangeRate);

         return moedaExChangeRate;
     }



}




