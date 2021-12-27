package com.example.Demo.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class AddressBookDTO {
	
	/**
	 * @Pattern : name pattern is given if it not valid then message is returned 
	 * @NotEmpty : name should not be empty
	 */
	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\$]{2,}$",message = "name is Invalid")
	@NotEmpty(message="Name Should not be Empty")
	public String name;
	
	@NotEmpty(message="City name Should not be null")
	public String city;
	
	@NotEmpty(message="State name Should not be Empty")
	public String state;
	
	public AddressBookDTO(String name, String state, String city) {

		this.name = name;
		this.state = state;
		this.city = city;
	}

	@Override
	public String toString() {
		return "AddressBookDTO [state=" + state + ", city=" + city + "]";
	}

}
