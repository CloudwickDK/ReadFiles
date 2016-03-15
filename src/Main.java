import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Main {

	public static void main(String[] args) {

		Readcsv csv_obj = new Readcsv();
		// ReadJson json_obj = new ReadJson();
		Reader reader = null;
		try {
			reader = new FileReader("files/data.csv");
			csv_obj.read(reader);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// json_obj.read();
	}
}
