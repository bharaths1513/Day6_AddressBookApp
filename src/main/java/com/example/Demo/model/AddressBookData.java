package com.example.Demo.model;

import com.example.Demo.dto.AddressBookDTO;

public class AddressBookData {
	public String name;
	public String city;
	public String state;
	public long pinCode;

	public AddressBookData(long pinCode, AddressBookDTO addressbookDTO) {

		
		this.pinCode = pinCode;
		this.state = addressbookDTO.state;
		this.city = addressbookDTO.city;
		this.name = addressbookDTO.name;

	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public long getPinCode() {
		return pinCode;
	}

	public void setPinCode(long pinCode) {
		this.pinCode = pinCode;
	}

}
