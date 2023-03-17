package es.example.service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.example.dto.DataDto;
import es.example.entity.Price;
import es.example.repository.Repository;

/**
 * Implementation of our services to bring us the data from the database
 * 
 * @project product-information
 * @package es.example.service
 * @date 20123-03-17
 * @author Fco Javier Redondo Martín
 * @version 1.1
 */
@Service
public class ProductServiceImp implements ProductService {
	
	@Autowired
	private Repository repository;
	
	/**
	 * A list is obtained with a find from the repository to later obtain a price object in another method and create the final object that is requested.
	 * 
	 * @return An object with the product identifier, string identifier, rate to apply, dates to apply, and final price to apply.
	 */
	public DataDto getProductInformation(LocalDateTime dateTime, String productId, String brandId) {
		
		List<Price> priceList = repository.findByProductIdAndBrandId(productId, brandId);

		Price price = findByDateByOrderByPriority(priceList, dateTime);
		
		return new DataDto(price);
	}
	
	/**
	 * Through a stream, it filters the price list by start and end date and sorts it by descending order of priority.
	 * 
	 * @return A price object, from where we will get the data for our final object.
	 */
	public Price findByDateByOrderByPriority(List<Price> priceList, LocalDateTime dateTime) {
		
		Optional<Price> price = priceList.stream()
				.filter(x -> dateTime.isAfter(x.getStartDate()) && dateTime.isBefore(x.getEndDate()))
				.sorted(Comparator.comparingInt(Price::getPriority).reversed()).findFirst();
		
		//If the optional has no value, throw the exception.
		if(!price.isPresent()) {
			throw new RuntimeException("No data for that date");
		}
		return price.get();
	}

}
