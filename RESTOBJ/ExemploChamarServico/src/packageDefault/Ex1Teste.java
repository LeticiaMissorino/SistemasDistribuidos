package packageDefault;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Ex1Teste {

	public static void main (String[] args){
		imprimirText("Turma!");
		somar(20,3);
		
	}
	
	public static void imprimirText(String texto){
		try {
			URL url = new URL("http://localhost:8082/RestExemplo/rest/helloworld/show=" + texto);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
		
			if(conn.getResponseCode() != 200){
				throw new RuntimeException("Erro:" + conn.getResponseCode());
			}
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String output;
		  System.out.println("Saida : \n");
		  while((output = br.readLine()) != null){
			  
			   System.out.println(output);
		  }
		  conn.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void somar(int a, int b){
		
		try {
			URL url = new URL("http://localhost:8082/RestExemplo/rest/helloworld/somar/"+ a +"/"+b+"");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
		
			if(conn.getResponseCode() != 200){
				throw new RuntimeException("Erro:" + conn.getResponseCode());
			}
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String output;
		  System.out.println("Saida : \n");
		  while((output = br.readLine()) != null){
			  
			   System.out.println(output);
		  }
		  conn.disconnect();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
