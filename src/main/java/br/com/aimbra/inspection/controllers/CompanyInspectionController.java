package br.com.aimbra.inspection.controllers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import br.com.aimbra.inspection.arguments.InspectionFileRequest;

public class CompanyInspectionController {
	
	public void readFile() {
		try {
			
			Reader reader = Files.newBufferedReader(
					Paths.get("companies.csv")
					);
			
			CSVReader csvReader = new CSVReaderBuilder(reader)
                    .withSkipLines(1) //para o caso do CSV ter cabeçalho.
                    .build();

			
			List<String[]> linhas = csvReader.readAll();
			
			InspectionFileRequest inspectionFileRequest = new InspectionFileRequest();
			for (String[] linha : linhas) {					
				for (String coluna : linha) {
					String[] datas = coluna.split(";");
					inspectionFileRequest.setCnpj(datas[2]);
					inspectionFileRequest.setCompanyName(datas[3]);
					inspectionFileRequest.setStreet(datas[4]);
//					inspectionFileRequest.setCep(datas[5]);
//					inspectionFileRequest.setCity(datas[6]);
//					inspectionFileRequest.setUf(datas[7]);
					
					
				}
				System.out.println(inspectionFileRequest);				
				System.out.println();
				
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
