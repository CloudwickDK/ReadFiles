import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class ReadCSV {

	private String[][] data;
	/*
	 * public void read1() { String csvFile = "files/data.csv"; BufferedReader
	 * br = null; String separator = ","; String line; data = null;
	 * 
	 * try { br = new BufferedReader(new FileReader(csvFile)); while ((line =
	 * br.readLine()) != null) { String[] words = line.split(",");
	 * System.out.println(words[0] + "" + words[1]); } } catch (IOException e) {
	 * e.printStackTrace(); } finally { if (br != null) { try { br.close(); }
	 * catch (IOException e) { e.printStackTrace(); } }
	 * 
	 * } }
	 */

	/**
	 * 
	 * @param reader
	 * @return -1 fail, 0 success, 1 other
	 * @throws IOException
	 */
	public int read(Reader reader) throws IOException {
		final CSVParser parser;
		this.data = null; // clean the data
		long record_number;
		List<CSVRecord> records;
		Map<String, Integer> headerMap;

		parser = new CSVParser(reader, CSVFormat.EXCEL.withHeader());
		headerMap = parser.getHeaderMap();
		records = parser.getRecords();
		data = new String[(int) records.size()][headerMap.size()];
		for (String columnName : headerMap.keySet()) {
			int colID = headerMap.get(columnName);
			for (final CSVRecord record : records) {
				record_number = parser.getRecordNumber();
				data[(int) record_number - 1][colID] = record.get(columnName);
			}
		}
		parser.close();
		return 0;
	}

	public void print() {
		try {
			final Appendable out;
			// final CSVPrinter printer = CSVFormat.DEFAULT.withHeader("name",
			// "email").print(out);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}