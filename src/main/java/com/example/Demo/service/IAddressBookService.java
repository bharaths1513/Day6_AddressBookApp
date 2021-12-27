package com.example.Demo.service;

import java.util.List;

import com.example.Demo.dto.AddressBookDTO;
import com.example.Demo.model.AddressBookData;



public interface IAddressBookService {

	List<AddressBookData> getAddressBookData();

	AddressBookData getAddressByPinCode(int pinCode);

	AddressBookData createAddressBookData(AddressBookDTO addressbookDTO);

	AddressBookData updateAddressBookData(int pinCode, AddressBookDTO addressbookdto);

	void deleteAddressBookData(int pinCode);

	
}