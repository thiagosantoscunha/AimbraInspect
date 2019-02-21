package fiscalizacao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.aimbra.inspection.arguments.FederateUnitRequest;
import br.com.aimbra.inspection.arguments.FederateUnitResponse;
import br.com.aimbra.inspection.connection.JPAUtil;
import br.com.aimbra.inspection.controllers.FederateUnitController;

public class FederateUnitControllerTest {
	
	private static final EntityManager em = JPAUtil.getEntityManager();;
	private FederateUnitController ufController;
	private FederateUnitRequest ufRequest;
	private FederateUnitResponse ufResponse;
	
	public FederateUnitControllerTest() {
	}
	
	@Before
	public void setUp() throws Exception {
		ufController = new FederateUnitController(em);
	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	@After
	public void tearDown() throws Exception {
		ufRequest = null;
		ufResponse = null;
	}

	@Test
	public void createMinasTest() {
		ufRequest = new FederateUnitRequest("Minas Gerais");
		ufResponse = ufController.create(ufRequest);
		assertEquals(ufResponse.getInitials(), "MG");
	}
	
	@Test
	public void createFederateUnitNameIsNullTest() {
		ufRequest = new FederateUnitRequest(null);
		ufResponse = ufController.create(ufRequest);
		assertEquals(null, ufResponse);
	}
	
	@Test
	public void createFederateUnitNameIsEmptyTest() {
		ufRequest = new FederateUnitRequest("");
		ufResponse = ufController.create(ufRequest);
		assertEquals(null, ufResponse);
	}
	
	@Test
	public void createFederateUnitIsNullTest() {
		ufRequest = null;
		ufResponse = ufController.create(ufRequest);
		assertEquals(null, ufResponse);
	}
	
	@Test
	public void findByIdIsSuccessMGTest() {
		ufResponse = ufController.findById(1L);
		assertEquals(ufResponse.getInitials(), "MG");
	}
	
	@Test
	public void findByIdNullParammTest() {
		assertEquals(null, ufController.findById(null));
	}
	
	@Test
	public void findAllNotNullTest() {
		List<FederateUnitResponse> ufs = ufController.findAll();
		assertEquals(5, ufs.size());
	}
	
	@Test
	public void updateSuccessTest() {
		ufRequest = new FederateUnitRequest("Minas Gerais", "MG", 1L);
		FederateUnitResponse uf = ufController.update(ufRequest);
		assertEquals(uf.getInitials(), "MG");
	}

}
