package com.example.Demo.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Demo.dto.AddressBookDTO;
import com.example.Demo.dto.ResponseDTO;
import com.example.Demo.model.AddressBookData;
import com.example.Demo.service.IAddressBookService;

@RestController
@RequestMapping("/addressbookapp")
public class AddressBookAppController {
	private static final AddressBookDTO addressBookDTO = null;
	@Autowired
	private IAddressBookService addressBookService;

	/*
	 * RequestMapping:use to pass the URL. return:message get call successful.
	 */
	@RequestMapping(value = { "/get" })
	public ResponseEntity<ResponseDTO> getAddressBookData() {
		List<AddressBookData> addressBookList = null;
		addressBookList = addressBookService.getAddressBookData();
		ResponseDTO respDTO = new ResponseDTO("Get call Successful:", addressBookList);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	/*
	 * @GetMapping:passed URL with pinCod return:response which takes the Code and
	 * return city state.
	 */
	@GetMapping("/get/{pinCode}")
	public ResponseEntity<ResponseDTO> getAddressBookData(@PathVariable("pinCode") int pinCode) {
		AddressBookData addressbookData = null;
		addressbookData = addressBookService.getAddressByPinCode(pinCode);
		ResponseDTO respDTO = new ResponseDTO("Get call for pinCode Successful:", addressbookData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	/*
	 * PostMapping : To create Address Data 
	 * return :  the data by taking JSON file.
	 */
	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> addAddressBookData(@Valid @RequestBody AddressBookDTO addressbookDTO) {
		AddressBookData addressbookData = null;
		addressbookData = addressBookService.createAddressBookData(addressbookDTO);
		ResponseDTO respDTO = new ResponseDTO("Create AddressBook Data:", addressbookData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	/*
	 * put method is use to update the data. by passing pinCode.
	 */
	@PutMapping("/update/{pinCode}")
	public ResponseEntity<ResponseDTO> updateAddressBookData(@Valid @PathVariable("pinCode") int pinCode,
			@RequestBody AddressBookDTO addressbookDTO) {
		AddressBookData addressbookData = null;
		addressbookData = addressBookService.updateAddressBookData(pinCode, addressBookDTO);
		ResponseDTO respDTO = new ResponseDTO("Update AddressBook Successful:", addressbookData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);

	}

	/*
	 * return:the message that the data got deleted by using the pinCode.
	 */
	@DeleteMapping("/delete/{pinCode}")
	public ResponseEntity<ResponseDTO> deleteAddressBookData(@PathVariable("pinCode") int pinCode) {
		addressBookService.deleteAddressBookData(pinCode);
		ResponseDTO respDTO = new ResponseDTO("Deleted Successful,Deleted Code:", pinCode);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
}