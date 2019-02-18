package br.com.aimbra.inspection.business;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

import br.com.aimbra.inspection.arguments.InspectionFileRequest;
import br.com.aimbra.inspection.entities.City;
import br.com.aimbra.inspection.entities.Company;
import br.com.aimbra.inspection.entities.District;
import br.com.aimbra.inspection.entities.FederateUnit;
import br.com.aimbra.inspection.entities.Inspection;
import br.com.aimbra.inspection.entities.InspectionLineError;
import br.com.aimbra.inspection.repositories.CityRepository;
import br.com.aimbra.inspection.repositories.CityRepositoryImpl;
import br.com.aimbra.inspection.repositories.CompanyRepository;
import br.com.aimbra.inspection.repositories.CompanyRepositoryImpl;
import br.com.aimbra.inspection.repositories.DistrictRepository;
import br.com.aimbra.inspection.repositories.DistrictRepositoryImpl;
import br.com.aimbra.inspection.repositories.FederateUnitRepository;
import br.com.aimbra.inspection.repositories.FederateUnitRepositoryImpl;
import br.com.aimbra.inspection.repositories.InspectionLineErrorRepository;
import br.com.aimbra.inspection.repositories.InspectionLineErrorRepositoryImpl;
import br.com.aimbra.inspection.repositories.InspectionRepository;
import br.com.aimbra.inspection.repositories.InspectionRepositoryImpl;
import br.com.aimbra.inspection.utils.FederateUnitSelection;
import br.com.aimbra.inspection.utils.RegexValidators;
import br.com.aimbra.inspection.utils.ToLocalDateLibrary;

public class FileServiceImpl implements FileService {
	
	private FederateUnitRepository federateUnitRepository;
	private CityRepository cityRepository;
	private DistrictRepository districtRepository;
	private CompanyRepository companyRepository;
	private InspectionRepository inspectionRepository;
	private InspectionLineErrorRepository inspectionLineErrorRepository;
	private final ModelMapper modelMapper;
	
	public FileServiceImpl() {		
		federateUnitRepository = new FederateUnitRepositoryImpl();
		cityRepository = new CityRepositoryImpl();
		districtRepository = new DistrictRepositoryImpl();
		companyRepository = new CompanyRepositoryImpl();
		inspectionRepository = new InspectionRepositoryImpl();
		inspectionLineErrorRepository = new InspectionLineErrorRepositoryImpl();
		modelMapper = new ModelMapper();
	}
	
	@Override
	public void create(List<InspectionFileRequest> requests) {
		
		for (InspectionFileRequest req : requests) {
			
			InspectionLineError ilError = modelMapper.map(req, InspectionLineError.class);
			
			FederateUnit uf = FederateUnitSelection.getFederateUnitInstance(req.getUf());
			if (uf == null) {
				ilError = inspectionLineErrorRepository.create(ilError);
				continue;
			}
			if (!federateUnitRepository.exist(uf)) uf = federateUnitRepository.create(uf);
			else uf = federateUnitRepository.findByInitials(uf);
			
			
			City city = new City();
			if (req.getCity() == null) {
				ilError = inspectionLineErrorRepository.create(ilError);
				continue;
			}
			city.setName(req.getCity());
			city.setFederationUnit(uf);
			if (!cityRepository.existOnFederalUnit(city, uf)) city = cityRepository.create(city); 
			else city = cityRepository.findByName(city);
		
			
			District district = new District();
			if(req.getDistrict() == null || req.getDistrict().equals("Sem Informação")) {
				ilError = inspectionLineErrorRepository.create(ilError);
				continue;
			}
			district.setName(req.getDistrict());
			district.setCity(city);
			if (!districtRepository.existOnCity(district, city)) district = districtRepository.create(district);
			else district = districtRepository.findByNameAndCity(district, city);
			
			Company company = new Company();
			if (req.getCompanyName() == null) {
				ilError = inspectionLineErrorRepository.create(ilError);
				continue;
			}
			company.setFederateUnit(uf);
			company.setCity(city);
			company.setDistrict(district);
			company.setName(req.getCompanyName());
			company.setStreet(req.getStreet());
			if (!RegexValidators.ZipCodeValidator(req.getCep(), "pt_br")) {
				ilError = inspectionLineErrorRepository.create(ilError);
				continue;
			}
			company.setZipCode(req.getCep());
			
			if(!RegexValidators.CnpjValidator(req.getCnpj()) || req.getCnpj() == null) {
				ilError = inspectionLineErrorRepository.create(ilError);
				continue;
			}
			company.setCnpj(req.getCnpj());
			if (!companyRepository.exist(company)) company = companyRepository.create(company);
			else company = companyRepository.findByCnpj(company);
			
			Inspection inspection = new Inspection();
			inspection.setCompany(company);
			inspection.setFederateUnit(uf);
			inspection.setCity(city);
			inspection.setDistrict(district);
			inspection.setNameCompany(req.getCompanyName());
			inspection.setPublicPlace(req.getStreet());
			inspection.setZipCode(req.getCep());
			inspection.setDate(
					ToLocalDateLibrary.StringToFirstDateOfMouth(
							req.getEndMouthYearInspect()
							)
					);
			
			inspection = inspectionRepository.create(inspection);
			System.out.println("Adicionado com sucesso!");
			System.out.println(inspection);
		}
		
	}
	
	

}