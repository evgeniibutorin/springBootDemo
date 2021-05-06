package com.example.springbootdemo.service;


import com.example.springbootdemo.model.Address;
import com.example.springbootdemo.model.Employee;
import com.example.springbootdemo.repository.AddressRepository;
import com.example.springbootdemo.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    EmployeeRepository repository;
    private AddressService addressService;

    public EmployeeServiceImpl(EmployeeRepository repository, AddressService addressService) {
        this.repository = repository;
        this.addressService = addressService;
    }

    @Override
    @Transactional(readOnly = true)
    public Employee getEmployee(final int id) { return repository.findById(id).get(); }

    @Override
    @Transactional(readOnly = true)
    public List<Employee> getEmployees() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = false)
    public void addEmployee(final Employee employee) {
        repository.save(employee);
    }

    @Override
    @Transactional(readOnly = false)
    public void updateEmployee(final Employee employee) {
        repository.save(employee);
    }

    @Override
    @Transactional(readOnly = false)
    public void deleteEmployee(final int id) {
        Address address = repository
                .getOne(id)
                .getAddress();
        int s = address.getEmployees().size();
        repository.deleteById(id);

//        if (s<2){
//            addressService.deleteAddress(address.getId());
//        }
    }

    @Override
    @Transactional(readOnly = false)
    public List<Employee> deleteSimilarEmployees(){
        List <Employee> allEmployees = repository.findAll();
        int size = allEmployees.size();
        int duplicates = 0;
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                if ((!allEmployees.get(j).getPosition().equals(allEmployees.get(i).getPosition())) &&(!allEmployees.get(j).getPosition().equals(allEmployees.get(i).getPosition())))
                    continue;

                repository.deleteById(allEmployees.get(j).getId());
                duplicates++;
                allEmployees.remove(j);
                j--;
                size--;
            }
        }
        return repository.findAll();
    }

    @Override
    public List<Employee> findEmployeeByName(String name){
        return repository.findEmployeeByName(name);
    }

}
