package es.example.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import es.example.dto.DataDto;
import es.example.service.ProductServiceImp;

/**
 * Controller where get requests are made to get the product information.
 * 
 * @project product-information
 * @package es.example.controller
 * @date 2023-03-17
 * @author Fco Javier Redondo Martín
 * @version 1.1
 */
@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductServiceImp service;
	
	/**
	 * Method that calls our service to obtain the information of the specific product.
	 * 
	 * @return An object with the product identifier, string identifier, rate to apply, dates to apply, and final price to apply.
	 */
	@ResponseBody
	@GetMapping(value = "/information")
	public DataDto productInformation(
			@RequestParam(value = "dateTime", required = true) 
			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateTime,
			@RequestParam(value = "productId", required = true) String productId,
			@RequestParam(value = "brandId", required = true) String brandId) {
		
		return service.getProductInformation(dateTime, productId, brandId);
	}
}
