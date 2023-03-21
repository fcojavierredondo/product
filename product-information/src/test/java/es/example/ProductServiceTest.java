package es.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import es.example.dto.DataDto;
import es.example.entity.Price;
import es.example.repository.Repository;
import es.example.service.ProductServiceImp;

@DataJpaTest
@RunWith(SpringRunner.class)
public class ProductServiceTest {

	@Mock
	private Repository repository;
	
	@InjectMocks
	private ProductServiceImp productServiceImp;
	
	private List<Price> priceList;
	
	private Price price1;
	private Price price2;
	private Price price3;
	private Price price4;
	
    private static final Integer TESTBRANDID = 1;
    private static final Integer TESTPRODUCTID = 35455;
    private static final String TESTCURR = "EUR";
    private static final String TEST1DATE = "2020-06-14T10:00";
    private static final String TEST2DATE = "2020-06-14T16:00";
    private static final String TEST3DATE = "2020-06-14T21:00";
    private static final String TEST4DATE = "2020-06-15T10:00";
    private static final String TEST5DATE = "2020-06-16T21:00";
	
	@BeforeEach
	public void setUp() {
		
		// Initialize mockito.
		MockitoAnnotations.openMocks(this);
		
        // Create test objects
		price1 = createPriceEntity(1L, LocalDateTime.parse("2020-06-14T00:00"), LocalDateTime.parse("2020-12-31T23:59:59"), 1, 0, 35.5);
		price2 = createPriceEntity(2L, LocalDateTime.parse("2020-06-14T15:00"), LocalDateTime.parse("2020-06-14T18:30"), 2, 1, 25.45);
		price3 = createPriceEntity(3L, LocalDateTime.parse("2020-06-15T00:00"), LocalDateTime.parse("2020-06-15T11:00"), 3, 1, 30.5);
		price4 = createPriceEntity(4L, LocalDateTime.parse("2020-06-15T16:00"), LocalDateTime.parse("2020-12-31T23:59:59"), 4, 1, 38.95);

		// Create test list
		priceList = Lists.newArrayList(price1, price2, price3, price4); 
		
	}
	
	// Test for the request at 10:00 on June 14 of product 35455 for brand 1.
    @Test
    public void test1() {
	    	
		LocalDateTime dateTime = LocalDateTime.parse(TEST1DATE);
		
		// Returns a list for this repository condition.
		when(repository.findByProductIdAndBrandId(TESTPRODUCTID, TESTBRANDID)).thenReturn(priceList);

		// Verifies that the returned object is equal to the one we expect.
		assertEquals(price1, productServiceImp.findByDateByOrderByPriority(priceList, dateTime));
		
		DataDto data = productServiceImp.getProductInformation(dateTime, TESTPRODUCTID, TESTBRANDID);
		
		// The price object created is equal to what we expect.
		assertEquals(data, new DataDto(price1));

    }

	// Test for the request at 16:00 on June 14 of product 35455 for brand 1.
    @Test
    public void test2() {
    	
    	LocalDateTime dateTime = LocalDateTime.parse(TEST2DATE);
		
		// Returns a list for this repository condition.
		when(repository.findByProductIdAndBrandId(TESTPRODUCTID, TESTBRANDID)).thenReturn(priceList);

		// Verifies that the returned object is equal to the one we expect.
		assertEquals(price2, productServiceImp.findByDateByOrderByPriority(priceList, dateTime));

		DataDto data = productServiceImp.getProductInformation(dateTime, TESTPRODUCTID, TESTBRANDID);
		
		// The price object created is equal to what we expect.
		assertEquals(data, new DataDto(price2));

    }

	// Test for the request at 21:00 on June 14 of product 35455 for brand 1.
    @Test
    public void test3() {
    	
    	LocalDateTime dateTime = LocalDateTime.parse(TEST3DATE);
		
		// Returns a list for this repository condition.
		when(repository.findByProductIdAndBrandId(TESTPRODUCTID, TESTBRANDID)).thenReturn(priceList);

		// Verifies that the returned object is equal to the one we expect.
		assertEquals(price1, productServiceImp.findByDateByOrderByPriority(priceList, dateTime));

		DataDto data = productServiceImp.getProductInformation(dateTime, TESTPRODUCTID, TESTBRANDID);
		
		// The price object created is equal to what we expect.
		assertEquals(data, new DataDto(price1));

    }

	// Test for the request at 10:00 on June 15 of product 35455 for brand 1.
    @Test
    public void test4() {
    	
    	LocalDateTime dateTime = LocalDateTime.parse(TEST4DATE);
		
		// Returns a list for this repository condition.
		when(repository.findByProductIdAndBrandId(TESTPRODUCTID, TESTBRANDID)).thenReturn(priceList);

		// Verifies that the returned object is equal to the one we expect.
		assertEquals(price3, productServiceImp.findByDateByOrderByPriority(priceList, dateTime));

		DataDto data = productServiceImp.getProductInformation(dateTime, TESTPRODUCTID, TESTBRANDID);
		
		// The price object created is equal to what we expect.
		assertEquals(data, new DataDto(price3));

    }

	// Test for the request at 21:00 on June 16 of product 35455 for brand 1.
    @Test
    public void test5() {
    	
    	LocalDateTime dateTime = LocalDateTime.parse(TEST5DATE);
		
		// Returns a list for this repository condition.
		when(repository.findByProductIdAndBrandId(TESTPRODUCTID, TESTBRANDID)).thenReturn(priceList);

		// Verifies that the returned object is equal to the one we expect.
		assertEquals(price4, productServiceImp.findByDateByOrderByPriority(priceList, dateTime));

		DataDto data = productServiceImp.getProductInformation(dateTime, TESTPRODUCTID, TESTBRANDID);
		
		// The price object created is equal to what we expect.
		assertEquals(data, new DataDto(price4));

    }
	
    // Create the entity price. 
	public Price createPriceEntity(Long id, LocalDateTime startDate, LocalDateTime endDate, Integer priceList, Integer priority, double productPrice) {
		
		Price price = new Price();
		price.setId(id);
		price.setBrandId(TESTBRANDID);
		price.setStartDate(startDate);
		price.setEndDate(endDate);
		price.setPriceList(priceList);
		price.setProductId(TESTPRODUCTID);
		price.setPriority(priority);
		price.setPrice(productPrice);
		price.setCurr(TESTCURR);
		return price;
	}
}