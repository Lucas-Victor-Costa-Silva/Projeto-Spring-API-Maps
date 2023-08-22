package com.example.springboot.services;
 
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.springboot.models.CustomersModels;
import com.example.springboot.repositories.CustomersRepositories;

@Service
public class CustomersServices {
	
	
	final CustomersRepositories customersRepositories;
	
	public CustomersServices(CustomersRepositories customersRepositories) {
		this.customersRepositories = customersRepositories;
	}
	
	@Transactional
	public CustomersModels save(CustomersModels customersModels) {
		return customersRepositories.save(customersModels);
	}
	
	public Iterable<CustomersModels> findAll() {
		return customersRepositories.findAll();
	}
	
	//Verifica CNPJ 
    public boolean existsByCnpj(String cnpj) {
        return customersRepositories.existsByCnpj(cnpj);
    }

    public Optional<CustomersModels> findById(UUID id){
    	return customersRepositories.findById(id);
    }
    
    @Transactional
    public void delete(CustomersModels customersModels){
    	 customersRepositories.delete(customersModels);;
    } 
    
}
