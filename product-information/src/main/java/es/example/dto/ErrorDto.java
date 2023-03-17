package es.example.dto;

import lombok.Builder;
import lombok.Data;

/**
 * Error object to return in an exception.
 * 
 * @project product-information
 * @package es.example.dto
 * @date 20123-03-17
 * @author Fco Javier Redondo Martín
 * @version 1.1
 */
@Data
@Builder
public class ErrorDto {

	private String code;
	private String message;
}
