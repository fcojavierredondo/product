package es.example.entity;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import jakarta.persistence.*;

/**
 * Prices table entity.
 * 
 * @project product-information
 * @package es.example.entity
 * @date 2023-03-17
 * @author Fco Javier Redondo Martín
 * @version 1.1
 */
@Entity
@Getter
@Setter
@ToString
@Table(name="prices")
public class Price {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "brand_id", nullable = false, length = 10)
	private Integer brandId;
	
	@Column(name = "start_date")
	private LocalDateTime startDate;
	
	@Column(name = "end_date")
	private LocalDateTime endDate;
	
	@Column(name = "price_list")
	private Integer priceList;
	
	@Column(name = "product_id")
	private Integer productId;
	
	@Column(name = "priority")
	private Integer priority;
	
	@Column(name = "price")
	private double price;
	
	@Column(name = "curr")
	private String curr;

//	public Integer getId() {
//		return id;
//	}
//	public void setId(Integer id) {
//		this.id = id;
//	}
//	public Integer getBrandId() {
//		return brandId;
//	}
//	public void setBrandId(Integer brandId) {
//		this.brandId = brandId;
//	}
//	public LocalDateTime getStartDate() {
//		return startDate;
//	}
//	public void setStartDate(LocalDateTime startDate) {
//		this.startDate = startDate;
//	}
//	public LocalDateTime getEndDate() {
//		return endDate;
//	}
//	public void setEndDate(LocalDateTime endDate) {
//		this.endDate = endDate;
//	}
//	public Integer getPriceList() {
//		return priceList;
//	}
//	public void setPriceList(Integer priceList) {
//		this.priceList = priceList;
//	}
//	public Integer getProductId() {
//		return productId;
//	}
//	public void setProductId(Integer productId) {
//		this.productId = productId;
//	}
//	public Integer getPriority() {
//		return priority;
//	}
//	public void setPriority(Integer priority) {
//		this.priority = priority;
//	}
//	public double getPrice() {
//		return price;
//	}
//	public void setPrice(double price) {
//		this.price = price;
//	}
//	public String getCurr() {
//		return curr;
//	}
//	public void setCurr(String curr) {
//		this.curr = curr;
//	}
	public Price() {
		
	}
}

