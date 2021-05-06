package com.example.springbootdemo.service;

import com.example.springbootdemo.model.Address;
import com.example.springbootdemo.model.Employee;
import com.example.springbootdemo.repository.AddressRepository;
import com.example.springbootdemo.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {

    private AddressRepository addressRepository;


    private EmployeeRepository employeeRepository;

    public AddressServiceImpl(AddressRepository addressRepository, EmployeeRepository employeeRepository) {
        this.addressRepository = addressRepository;
        this.employeeRepository = employeeRepository;
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
    @Transactional
    public void getAndUpdateAddress(String address, int id, String name, String position) {
        Employee employee = employeeRepository.getOne(id);
        Address adr = Optional.ofNullable(addressRepository.findAddressByAddress(address))
                .orElse(new Address(address));

        if (null == adr.getEmployees()) {
            adr.setEmployees(new ArrayList<>());
        }
        if (!adr.getEmployees().contains(employee)) {
            adr.getEmployees().add(employee);
        }
        addressRepository.save(adr);
        employee.setId(id);
        employee.setAddress(adr);
        employee.setName(name);
        employee.setPosition(position);
        employeeRepository.save(employee);

    }

    @Override
    @Transactional
    public Address addAddress(String address) {
        return Optional.ofNullable(addressRepository
                .findAddressByAddress(address))
                .orElse(new Address(address));
    }

}
