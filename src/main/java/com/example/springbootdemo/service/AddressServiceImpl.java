package com.example.springbootdemo.service;

import com.example.springbootdemo.model.Address;
import com.example.springbootdemo.repository.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    private AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Address getAddress(int id) {
        return addressRepository.getOne(id);
    }

    @Override
    public List<Address> getAddress() {
        return addressRepository.findAll();
    }

    @Override
    public void addAddress(Address address) {
        addressRepository.save(address);
    }

    @Override
    public void updateAddress(Address address) {
        addressRepository.save(address);
    }

    @Override
    public void deleteAddress(int id) {
        addressRepository.deleteById(id);
    }
    @Override
    public Address isAddressExist(String address) {
        Address ad = null;
        List<Address> list = addressRepository.findAll();
        for (Address db : list) {
            if (db.getAddress().equals(address)) {
                ad = db;
            } else {
                ad = new Address(address);
            }
        }
        return ad;
    }

}
