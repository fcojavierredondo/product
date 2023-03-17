package es.example.dto;

import java.time.LocalDateTime;

import es.example.entity.Price;
import lombok.Data;

/**
 * Final object to return.
 * 
 * @project product-information
 * @package es.example.dto
 * @date 2023-03-17
 * @author Fco Javier Redondo Martín
 * @version 1.1
 */
@Data
public class DataDto {
	
	private Integer productId;
	private Integer brandId;
	private Integer priceList;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private double price;
    
    public DataDto(Price price) {
        this.productId = price.getProductId();
        this.brandId = price.getBrandId();
        this.priceList = price.getPriceList();
        this.startDate = price.getStartDate();
        this.endDate = price.getEndDate();
        this.price = price.getPrice();
    }
}