package com.example.Demo.dto;

public class AddressBookDTO {
	
	public String name;
	public String state;
	public String city;

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
