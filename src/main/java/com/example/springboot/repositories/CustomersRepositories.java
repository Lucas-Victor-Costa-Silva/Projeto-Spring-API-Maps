package com.example.springboot.repositories;


import com.example.springboot.models.CustomersModels;

import java.util.UUID;  

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomersRepositories extends JpaRepository<CustomersModels, UUID> {
	boolean existsByCnpj(String cnpj);
}
