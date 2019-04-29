package br.com.aimbra.inspection.controllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.persistence.EntityManager;

import br.com.aimbra.inspection.arguments.InspectionFileRequest;
import br.com.aimbra.inspection.business.FileService;
import br.com.aimbra.inspection.business.FileServiceImpl;

public class CompanyInspectionController {

	private FileService fileService;
	private BufferedReader br;
	private EntityManager em;

	public CompanyInspectionController(EntityManager em) { 
		this.em = em;
		fileService = new FileServiceImpl(em);
	}

	public void readFile() {
		try {
			
			File fileDir = new File("file2.csv");
			br = new BufferedReader(new InputStreamReader(new FileInputStream(fileDir), "utf8"));
			String csvLine = br.readLine();
			
			while ((csvLine = br.readLine()) != null) {
				
				try {
					em.getTransaction().begin();
					InspectionFileRequest inspection = new InspectionFileRequest(csvLine);
					fileService.create(inspection);
					em.getTransaction().commit();					
				} catch (Exception e) {
					em.getTransaction().rollback();
					System.out.println(e.getMessage());
				}
			}
			
			em.close();
			
		} catch (IOException e) {
			System.out.println("Erro ao ler o arquivo");
			System.out.println(e.getMessage());
			return;
		}
	}

}
