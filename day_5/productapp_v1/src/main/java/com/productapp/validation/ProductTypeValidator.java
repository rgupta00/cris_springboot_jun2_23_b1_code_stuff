package com.productapp.validation;

import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Service;
@Service
public class ProductTypeValidator implements ConstraintValidator<ProductTypeValidation, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		List<String> productTypes = Arrays.asList("IT", "BOOK","FMCG");
		return productTypes.contains(value);
		
	}

}
