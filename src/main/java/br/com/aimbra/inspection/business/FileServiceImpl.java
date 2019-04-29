package br.com.aimbra.inspection.business;

import javax.persistence.EntityManager;

import org.modelmapper.ModelMapper;

import br.com.aimbra.inspection.arguments.FederateUnitRequest;
import br.com.aimbra.inspection.arguments.FederateUnitResponse;
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
import br.com.aimbra.inspection.utils.CnpjValidator;
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
	
	private FederateUnitService federateUnitService;

	public FileServiceImpl(EntityManager em) {
		federateUnitRepository = new FederateUnitRepositoryImpl(em);
		cityRepository = new CityRepositoryImpl(em);
		districtRepository = new DistrictRepositoryImpl(em);
		companyRepository = new CompanyRepositoryImpl(em);
		inspectionRepository = new InspectionRepositoryImpl(em);
		inspectionLineErrorRepository = new InspectionLineErrorRepositoryImpl(em);
		modelMapper = new ModelMapper();
		
		
		federateUnitService = new FederateUnitServiceImpl(em);
	}

	@Override
	public void create(InspectionFileRequest req) {

		InspectionLineError ilError = modelMapper.map(req, InspectionLineError.class);
		
		//Trata Federate Unit
		FederateUnit uf = new FederateUnit();
		uf.setName(req.getUf());
		FederateUnitRequest ufRequest = modelMapper.map(uf, FederateUnitRequest.class);
		FederateUnitResponse ufResponse = federateUnitService.create(ufRequest);
		if (ufResponse == null) {
			ilError = inspectionLineErrorRepository.create(ilError);
			return;
		}

		//Trata o City
		City city = new City();
		if (req.getCity() == null) {
			ilError = inspectionLineErrorRepository.create(ilError);
			return;
		}
		city.setName(req.getCity());
		city.setFederationUnit(uf);
		if (!cityRepository.existOnFederalUnit(city.getName(), uf))
			city = cityRepository.create(city);
		else
			city = cityRepository.findByName(city.getName());

		//Trata o bairro
		District district = new District();
		if (req.getDistrict() == null || req.getDistrict().equals("Sem Informação")) {
			ilError = inspectionLineErrorRepository.create(ilError);
			return;
		}
		district.setName(req.getDistrict());
		district.setCity(city);
		if (!districtRepository.existOnCity(district.getName(), city))
			district = districtRepository.create(district);
		else
			district = districtRepository.findByNameOnCity(district.getName(), city);

		//Trata a empresa
		Company company = new Company();
		if (req.getCompanyName() == null) {
			ilError = inspectionLineErrorRepository.create(ilError);
			return;
		}
		company.setFederateUnit(uf);
		company.setCity(city);
		company.setDistrict(district);
		company.setName(req.getCompanyName());
		company.setStreet(req.getStreet());
		if (!RegexValidators.isZipCode(req.getCep(), "pt_br") || req.getCep() == null) {
			ilError = inspectionLineErrorRepository.create(ilError);
			return;
		}
		company.setZipCode(req.getCep());
		
		CnpjValidator cnpjValidator = new CnpjValidator(req.getCnpj()); 
		if (req.getCnpj() == null || !cnpjValidator.isCNPJ()) {
			ilError = inspectionLineErrorRepository.create(ilError);
			return;
		}
		company.setCnpj(req.getCnpj());
		if (!companyRepository.exist(company))
			company = companyRepository.create(company);
		else
			company = companyRepository.findByCnpj(company.getCnpj());

		//Trata a fiscalização
		Inspection inspection = new Inspection();
		inspection.setCompany(company);
		inspection.setFederateUnit(uf);
		inspection.setCity(city);
		inspection.setDistrict(district);
		inspection.setNameCompany(req.getCompanyName());
		inspection.setPublicPlace(req.getStreet());
		inspection.setZipCode(req.getCep());
		inspection.setDate(ToLocalDateLibrary.StringToFirstDateOfMouth(req.getEndMouthYearInspect()));

		inspection = inspectionRepository.create(inspection);

	}

}
