package es.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.example.entity.Price;

/**
 * Repository to query the database.
 * 
 * @project product-information
 * @package es.example.repository
 * @date 20123-03-17
 * @author Fco Javier Redondo Martín
 * @version 1.1
 */
public interface Repository extends JpaRepository<Price, Long> {
	
	/**
	 * Make query filtering by product id and brand id.
	 * 
	 * return A list of objects from the prices table.
	 */
	List<Price> findByProductIdAndBrandId(String productId, String brandId);

}