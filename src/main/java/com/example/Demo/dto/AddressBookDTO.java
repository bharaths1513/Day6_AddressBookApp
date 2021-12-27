package com.example.Demo.dto;

import javax.validation.constraints.NotEmpty;

public class AddressBookDTO {

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
