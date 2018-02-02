package Macaw;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Map;

import com.csvreader.CsvWriter;

public class Simulator {

	public static void main(String[] args) throws IOException {
		
//		String csvFilePath = "D://Aloha.csv";
//		String csvFilePath2 = "D://Macaw.csv";  
		String csvFilePath3 = "D://Tdma.csv";  
//        // 创建CSV写对象 例如:CsvWriter(文件路径，分隔符，编码格式);  
//        CsvWriter csvWriter = new CsvWriter(csvFilePath, ',', Charset.forName("UTF-8"));  
//        CsvWriter csvWriter2 = new CsvWriter(csvFilePath2, ',', Charset.forName("UTF-8"));  
		 CsvWriter csvWriter3 = new CsvWriter(csvFilePath3, ',', Charset.forName("UTF-8"));  
//        // 写内容  
//        for (int i = 1; i < 1000; i++) {
//        	Aloha aloha = new Aloha();  
//        	aloha.setNum(i);
//    		Map<String,String> map = aloha.GetStatus();
//    		System.out.println(map.get("throughout"));
//    		System.out.println(map.get("load"));
//			String[] csvContent = {map.get("load"), map.get("throughout")};  
//            csvWriter.writeRecord(csvContent);  
//        }  
//        csvWriter.close();  
//        System.out.println("--------alohaCSV文件已经写入--------");
//        for (int i = 1; i < 1000; i++) {
//        	Macaw macaw = new Macaw();  
//        	macaw.setNum(i);
//    		Map<String,String> map = macaw.GetStatus();
//    		System.out.println(map.get("throughout"));
//    		System.out.println(map.get("load"));
//			String[] csvContent2 = {map.get("load"), map.get("throughout")};  
//            csvWriter2.writeRecord(csvContent2);  
//        }  
//        csvWriter2.close();  
//        System.out.println("--------macawCSV文件已经写入--------");  
        for (int i = 1; i < 1000; i++) {
        	Tdma tdma = new Tdma();  
        	tdma.setNum(i);
    		Map<String,String> map = tdma.GetStatus();
    		System.out.println(map.get("throughout"));
			String[] csvContent3 = {String.valueOf(i), map.get("throughout")};  
            csvWriter3.writeRecord(csvContent3);  
        }  
        csvWriter3.close();  
        System.out.println("--------tdmaCSV文件已经写入--------");  
    } 
    } 
			