

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;


/**
 * This is a class to create a mapping between Book isbns and associated ids created by mahout
 * Use it because isbn's cannot always be converted to long
 * @author Joseph
 *
 */
public class IDFix {
	private String inputFile;
	private String outputFile;
	private String outputFile2;
	private HashMap<String, Long> isbnToLongMap;
	private long count;
	private long temp;
	
	public IDFix(String inFile, String outFile, String outFile2){
		inputFile = inFile;
		outputFile = outFile;
		outputFile2 = outFile2;
		isbnToLongMap = new HashMap<String, Long>();
		count = 0;
		temp = 0;
		fix();
	}
	
	private void fix(){
		try {
			BufferedReader reader = new BufferedReader(new FileReader(inputFile));
			BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
			BufferedWriter writer2 = new BufferedWriter(new FileWriter(outputFile2));
			
			String line;
			while((line = reader.readLine()) != null){
				line = line.replaceAll("/", "");
				line = line.replaceAll("AND", "");
				String[] isbn = line.split(",");
				if(isbnToLongMap.isEmpty()){
					isbnToLongMap.put(isbn[1], count);
					count++;
					writer.write(isbn[0] + "," + temp + "," + isbn[2] + "\n");
					writer2.write(isbn[1] + "," + count + "\n");
				}
				else if(isbnToLongMap.containsKey(isbn[1])){
					temp = isbnToLongMap.get(isbn[1]);
					writer.write(isbn[0] + "," + temp + "," + isbn[2] + "\n");
				}
				else {
					isbnToLongMap.put(isbn[1], count);
					writer.write(isbn[0] + "," + count + "," + isbn[2] + "\n");
					writer2.write(isbn[1] + "," + count + "\n");
					count++;
				}
			}
			
			reader.close();
			writer.close();
			writer2.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
