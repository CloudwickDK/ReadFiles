package readJson;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class ReadJson {
	

	public List<Employee> read(Reader reader){
		
		Gson gson = new GsonBuilder().create();
	    //Employee employee  = gson.fromJson(reader, Employee.class);
	    
		TypeToken token = new TypeToken<List<Employee>>(){};    
		List<Employee> employee = gson.fromJson(reader, token.getType());
	    return employee;
		}
	public int write(Writer writer, Employee employee){
		
		Gson gson = new Gson();
		String json = gson.toJson(employee);
		try{
			writer.write(json);
			writer.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		
		return 0;
	}
}