// Ref https://www.youtube.com/watch?v=hDC_kNlzz6c
package net.javaguides.sbBE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.google.common.collect.Iterators;

import net.javaguides.sbBE.entity.ArxData;
import net.javaguides.sbBE.entity.Pat;
import net.javaguides.sbBE.repo.ArxRepo;
import net.javaguides.sbBE.repo.PatRepo;


//ARX
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.deidentifier.arx.ARXAnonymizer;
import org.deidentifier.arx.ARXConfiguration;
import org.deidentifier.arx.ARXResult;
import org.deidentifier.arx.AttributeType.Hierarchy;
import org.deidentifier.arx.AttributeType.Hierarchy.DefaultHierarchy;
import org.deidentifier.arx.Data;
import org.deidentifier.arx.Data.DefaultData;
import org.deidentifier.arx.criteria.KAnonymity;


@SpringBootApplication
public class SbBeApplication implements CommandLineRunner {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(SbBeApplication.class, args);
	}

	@Autowired
	private PatRepo patRepo;

	@Autowired
	private ArxRepo arxRepo;

	@Override
	public void run(String... args) throws Exception {
           
		System.out.println("======================  ARX Backend  Start ==========================");
		  
		// final List<List<String>> inputDataArray = new ArrayList<List<String>>();
		// ArrayList<String> inputRowData; 
		// inputRowData = new ArrayList<String>();
		// inputRowData.add("age"); inputRowData.add("gender"); inputRowData.add( "zipcode"); inputDataArray.add(inputRowData);
		// inputRowData = new ArrayList<String>();
		// inputRowData.add("34"); inputRowData.add("male");    inputRowData.add( "81667"); inputDataArray.add(inputRowData);
		// inputRowData = new ArrayList<String>();
		// inputRowData.add("45"); inputRowData.add("female");  inputRowData.add( "81675"); inputDataArray.add(inputRowData);
		// inputRowData = new ArrayList<String>();
		// inputRowData.add("66"); inputRowData.add("male");    inputRowData.add( "81925"); inputDataArray.add(inputRowData);
		// inputRowData = new ArrayList<String>();
		// inputRowData.add("70"); inputRowData.add("female");  inputRowData.add( "81931"); inputDataArray.add(inputRowData);
		// inputRowData = new ArrayList<String>();
		// inputRowData.add("34"); inputRowData.add("female");  inputRowData.add( "81931"); inputDataArray.add(inputRowData);
		// inputRowData = new ArrayList<String>();
		// inputRowData.add("70"); inputRowData.add("male");    inputRowData.add( "81931"); inputDataArray.add(inputRowData);
		// inputRowData = new ArrayList<String>();
		// inputRowData.add("45"); inputRowData.add("male");    inputRowData.add( "81931"); inputDataArray.add(inputRowData);
     
		
		// Define data
		  DefaultData data = Data.create();

		//   String[] inputRowDataTmp;
		//   for (int i = 0; i< inputDataArray.size(); i++ ){
		// 	inputRowDataTmp = new String [inputDataArray.get(i).size()];
		// 	// System.out.println(i + " : " + inputDataArray.get(i));
		// 	for (int j = 0; j< inputRowDataTmp.length; j++ ){
		// 		inputRowDataTmp[j] = inputDataArray.get(i).get(j);

		//     }
		// 	 System.out.println(inputRowDataTmp);
		// 	data.add(inputRowDataTmp);
		//   }
		  data.add("age", "gender", "zipcode");
		  data.add("34", "male", "81667");
		  data.add("45", "female", "81675");
		  data.add("66", "male", "81925");
		  data.add("70", "female", "81931");
		  data.add("34", "female", "81931");
		  data.add("70", "male", "81931");
		  data.add("45", "male", "81931");
  
		  // Print data 
		  System.out.println(" - Input data:");
		  Iterator<String[]> inputDataIterator = data.getHandle().iterator();
		  while (inputDataIterator.hasNext()) {
			  System.out.print("   ");
			  System.out.println(Arrays.toString(inputDataIterator.next()));
		  }
  
		  // Define hierarchies
		  DefaultHierarchy age = Hierarchy.create();
		  age.add("34", "<50", "*");
		  age.add("45", "<50", "*");
		  age.add("66", ">=50", "*");
		  age.add("70", ">=50", "*");
  
		  DefaultHierarchy gender = Hierarchy.create();
		  gender.add("male", "*");
		  gender.add("female", "*");
  
		  // Only excerpts for readability
		  DefaultHierarchy zipcode = Hierarchy.create();
		  zipcode.add("81667", "8166*", "816**", "81***", "8****", "*****");
		  zipcode.add("81675", "8167*", "816**", "81***", "8****", "*****");
		  zipcode.add("81925", "8192*", "819**", "81***", "8****", "*****");
		  zipcode.add("81931", "8193*", "819**", "81***", "8****", "*****");
  
		  data.getDefinition().setAttributeType("age", age);
		  data.getDefinition().setAttributeType("gender", gender);
		  data.getDefinition().setAttributeType("zipcode", zipcode);
  		  
		  // Create an instance of the anonymizer
		  ARXAnonymizer anonymizer = new ARXAnonymizer();
		  ARXConfiguration config = ARXConfiguration.create();
		  config.addPrivacyModel(new KAnonymity(3));
		  config.setSuppressionLimit(0d);
  
		  ARXResult result = anonymizer.anonymize(data, config);
  
  
		//  // Print results
		  System.out.println(" - Transformed data:");
		  Iterator<String[]> transformedDataIterator = result.getOutput(false).iterator();
		  while (transformedDataIterator.hasNext()) {
			  System.out.print("   ");
			  System.out.println(Arrays.toString(transformedDataIterator.next()));
		  }//while 

		System.out.println("======================  ARX Backend  Complete ==========================");


		Pat pat1 = Pat.builder()
					.id(11)
					.name("aaaaa")
					.age(10)	
					.build();	
		patRepo.save(pat1);													

		Pat pat2 = Pat.builder()
					.id(22)
					.name("bbbbb")
					.age(20)	
					.build();									
		patRepo.save(pat2);													
		Pat pat3 = Pat.builder()
					.id(33)
					.name("cccc")
					.age(30)	
					.build();		
		patRepo.save(pat3);		
		
		
    
		// String[] tblHead = new String[] { "aaa","bbb","ccc"};
        // arxData.addRow(tblHead);
        System.out.println(" - Transmitted data:");
		System.out.println(" patRepo: " + patRepo); 
		System.out.println(" arxRepo: " + arxRepo); 

		Iterator<String[]> arxResultIterator = result.getOutput(false).iterator();
		// System.out.println("Number of rows: " +  Iterators.size(arxDataIterator));	
		ArxData arxRow; 
        int i = 1; 
		String rowText;
		String rowTextArray [];

		while (arxResultIterator.hasNext()) {
			rowText =  "";
			rowTextArray  = arxResultIterator.next();
			// System.out.println("number oe elements : " + rowTextArray.length);
			for (int j = 0 ; j< rowTextArray.length; j++){
				rowText = rowText + rowTextArray[j] + " , ";
			}
			System.out.println(i + " : " + rowText);

			arxRow = ArxData.builder()
					.id(i)
					.rowData(rowText)
					.build();				
			arxRepo.save(arxRow);
			i ++; 
		}//while 



		System.out.println(" ================= Arx complete : ================" );									

	}
	

}
