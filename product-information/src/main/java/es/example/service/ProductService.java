package es.example.service;

import java.time.LocalDateTime;
import java.util.List;

import es.example.dto.DataDto;
import es.example.entity.Price;

/**
 * Methods to implement in the service.
 * 
 * @project product-information
 * @package es.example.service
 * @date 2023-03-17
 * @author Fco Javier Redondo Martín
 * @version 1.1
 */
public interface ProductService {
	
	public DataDto getProductInformation(LocalDateTime dateTime, Integer productId, Integer brandId);
	
	public Price findByDateByOrderByPriority(List<Price> priceList, LocalDateTime dateTime);

}