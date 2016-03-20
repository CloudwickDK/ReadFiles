package readcsv;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class ReadCSV {

	private String[][] data;
	Map<String, Integer> headerMap;
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
		reset();
		long record_number;
		List<CSVRecord> records;

		parser = new CSVParser(reader, CSVFormat.EXCEL.withHeader());
		this.headerMap = parser.getHeaderMap();
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

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(toStringMap());
		for (int record = 0; record < data.length; record++) {
			for (int column = 0; column < 1;) {

			}
		}

		return null;
	}

	private String toStringMap() {
		Set<String> colNames = headerMap.keySet();
		StringBuilder sb = new StringBuilder();
		Iterator<String> pop = colNames.iterator();
		
 		for (;pop.hasNext();){
			sb.append(pop.next().toString());
 			if(!pop.hasNext()){
				return sb.toString();
			}
			sb.append(", ");
		}
 		return null;
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

	private void reset() {
		this.data = null; // clean the data
		this.headerMap = null;
	}
}