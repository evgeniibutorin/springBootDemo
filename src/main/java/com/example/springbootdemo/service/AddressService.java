package com.example.springbootdemo.service;

import com.example.springbootdemo.model.Address;
import com.example.springbootdemo.model.Employee;

import java.util.List;

public interface AddressService {

    Address getAddress(int id);
    List<Address> getAddress();
    void addAddress(Address address);
    void updateAddress(Address address);
    void deleteAddress(int id);
    void getAndUpdateAddress(String address, int id, String name, String position);
    Address addAddress(String address);

}
