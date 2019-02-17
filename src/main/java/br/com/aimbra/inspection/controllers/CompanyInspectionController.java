package br.com.aimbra.inspection.controllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.aimbra.inspection.arguments.InspectionFileRequest;

public class CompanyInspectionController {

	private List<InspectionFileRequest> inspections;
	private InspectionFileRequest inspection;
	List<InspectionFileRequest> requests;

	public CompanyInspectionController() {
		inspections = new ArrayList<>();
		requests = new ArrayList<>();
	}

	
	public void readFile() {
		try {
			File fileDir = new File("file.csv");

			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileDir), "utf8"));

			String linha = br.readLine();

			while ((linha = br.readLine()) != null) {

				String[] fiscalizacao = linha.split(";");
				
				InspectionFileRequest inspection = new InspectionFileRequest();
				inspection.setEndYearInspect(fiscalizacao[0]);
				inspection.setEndMouthYearInspect(fiscalizacao[1]);
				inspection.setCnpj(fiscalizacao[2]);
				inspection.setCompanyName(fiscalizacao[3]);
				inspection.setStreet(fiscalizacao[4]);
				inspection.setCep(fiscalizacao[5]);
				inspection.setDistrict(fiscalizacao[6]);
				inspection.setCity(fiscalizacao[7]);
				inspection.setUf(fiscalizacao[8]);
				
				requests.add(inspection);
				
			}
			
			System.out.println(requests);

		} catch (IOException e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
		}
	}

}
