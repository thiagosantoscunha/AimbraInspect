package br.com.aimbra.inspection.main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String csvArquivo="file.csv";
		BufferedReader conteudoCSV=null;
		String linha="";
		String csvSeparadorCampo= ";";
		try {
			conteudoCSV = new BufferedReader(new FileReader(csvArquivo));
			
			while((linha = conteudoCSV.readLine()) !=null) {
				
				String[] fiscalizacao =linha.split(csvSeparadorCampo);
				
				System.out.println(
						"Ano="+fiscalizacao[0]
						+""+" Data Termino="+fiscalizacao[1]
						+""+" CNPJ="+fiscalizacao[2]
						+""+" Razao Social="+fiscalizacao[3]
						+""+" Logradouro="+fiscalizacao[4]
						+""+" CEP="+fiscalizacao[5]
						+""+" Bairro="+fiscalizacao[6]
						+""+" Cidade="+fiscalizacao[7]
						+""+" UF="+fiscalizacao[8]
						);				
			}		
			
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado: \n"+e.getMessage());
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("IndexOutOfBounds: \n"+e.getMessage());
		}catch (IOException e) {
			System.out.println("IO Erro: \n"+e.getMessage());
		}finally {
			if(conteudoCSV !=null) {
				try {
					conteudoCSV.close();
				} catch (IOException e) {
					System.out.println("IO Erro: \n"+e.getMessage());
				}
				
			}
		}
		

	}
}
