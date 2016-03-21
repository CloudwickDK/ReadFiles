import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import readJson.ReadJson;
import readcsv.ReadCSV;

public class Main {

	public static void main(String[] args) {

		ReadCSV csv_obj = new ReadCSV();
		ReadJson json_obj = new ReadJson();

		Reader csv_reader = null;
		Reader json_reader = null;
		Writer writer = null;
		try {
			// readers
			csv_reader = new FileReader("files/data.csv");
			json_reader = new FileReader("files/data.json");
			// writers
			writer = new FileWriter("files/written_data.json");
			// read the files
			csv_obj.read(csv_reader);
			List<readJson.Employee> employee = json_obj.read(json_reader);

			// write
			//System.out.println(employee);
			 json_obj.write(writer, employee);

			Gson gson = new GsonBuilder().create();
			System.out.println(gson.toJson(employee));

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try { // close the readers
				if (csv_reader != null) {
					csv_reader.close();
				}
				if (json_reader != null) {
					json_reader.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Done");
	}
}
