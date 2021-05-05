package com.example.springbootdemo.service;

import com.example.springbootdemo.model.Address;

import java.util.List;

public interface AddressService {

    Address getAddress(int id);
    List<Address> getAddress();
    void addAddress(Address address);
    void updateAddress(Address address);
    void deleteAddress(int id);
    Address isAddressExist(String address);

}
