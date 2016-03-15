import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ReadJson {

	public void read(){
		String csvFile = "files/data.json";
		Writer writer = null;
		try{
			writer = new FileWriter(csvFile);

	        Gson gson = new GsonBuilder().create();
	        gson.toJson("Hello", writer);
	        gson.toJson(123, writer);
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			try{
				writer.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		

        
	}
}
