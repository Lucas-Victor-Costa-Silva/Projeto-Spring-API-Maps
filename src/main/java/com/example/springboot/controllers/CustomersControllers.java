package com.example.springboot.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.springboot.models.CustomersModels;
import com.example.springboot.services.CustomersServices;
import jakarta.validation.Valid;

@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
public class CustomersControllers {

	final CustomersServices customersServices;


	public CustomersControllers(CustomersServices customersServices) {
		this.customersServices = customersServices;
		
	}

	@GetMapping("/createCustomers")
	public String form(CustomersModels customersModels){	
		return "customers/formCustomers";

	}	

	@PostMapping("/createCustomers")
	public String saveCustomers(@Valid CustomersModels customersModels, BindingResult result, RedirectAttributes attributes){	
		if (customersServices.existsByCnpj(customersModels.getCnpj())) {
			attributes.addFlashAttribute("mensagem", "CNPJ já cadastrado!");
			return "redirect:/createCustomers";
		}	
		
		if (result.hasErrors()) {
			List<String> erros = result.getAllErrors()
					.stream()
					.map(DefaultMessageSourceResolvable::getDefaultMessage)
					.collect(Collectors.toList());
			attributes.addFlashAttribute("mensagem", erros);
			return "redirect:/createCustomers";
		}

		customersServices.save(customersModels);

		attributes.addFlashAttribute("mensagem", "Cliente cadastrado com sucesso!");
		return "redirect:/createCustomers";
	}	

	@GetMapping("/listCustomers")
	public ModelAndView getAllCustomers() {	
		ModelAndView modelAndView = new ModelAndView("customers/indexCustomers");

		Iterable<CustomersModels> customers = customersServices.findAll();

		modelAndView.addObject("customers", customers);

		return  modelAndView;

	}


	@GetMapping("detailCustomers/{id}")
	public ModelAndView getOneCustomers(@PathVariable(value = "id") UUID id) {
		Optional<CustomersModels> customersModelOptional = customersServices.findById(id);

		if (customersModelOptional.isPresent()) {
			CustomersModels customersModels = customersModelOptional.get();
			ModelAndView modelAndView = new ModelAndView("customers/detailCustomers");
			modelAndView.addObject("customer", customersModels);
			return modelAndView;
		} else {
			ModelAndView modelAndView = new ModelAndView("error"); 
			modelAndView.addObject("errorMessage", "Cliente não encontrado"); 
			return modelAndView;
		}
	}

	@GetMapping("/deleteCustomers/{id}")
	public String deleteCustomers(@PathVariable("id") UUID id) {
		Optional<CustomersModels> customersModelOptional = customersServices.findById(id);
		if (customersModelOptional.isPresent()) {
			customersServices.delete(customersModelOptional.get());
		}
		return "redirect:/listCustomers";
	}


	@GetMapping("/editCustomers/{id}")
	public String showUpdateForm(@PathVariable("id") UUID id, Model model) {
		Optional<CustomersModels> customersModelOptional = customersServices.findById(id);
		if (customersModelOptional.isPresent()) {
			CustomersModels customersModel = customersModelOptional.get();
			model.addAttribute("customer", customersModel);
			return "customers/updateCustomers"; 
		} else {

			return "redirect:/listCustomers"; 
		}
	}


	@PostMapping("/updateCustomers/{id}")
	public String updateCustomers(@PathVariable("id") UUID id, @Valid CustomersModels customersModels, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			List<String> erros = result.getAllErrors()
					.stream()
					.map(DefaultMessageSourceResolvable::getDefaultMessage)
					.collect(Collectors.toList());
			attributes.addFlashAttribute("mensagem", erros);
			return "redirect:/editCustomers/{id}";
		}

		Optional<CustomersModels> existingCustomerOptional = customersServices.findById(id);
		if (!existingCustomerOptional.isPresent()) {
			return "redirect:/listCustomers"; 
		}

		CustomersModels existingCustomer = existingCustomerOptional.get();
		existingCustomer.setName(customersModels.getName());
		existingCustomer.setCnpj(customersModels.getCnpj());
		existingCustomer.setNumber(customersModels.getNumber());
		existingCustomer.setCity(customersModels.getCity());
		existingCustomer.setState(customersModels.getState());
		existingCustomer.setZipCode(customersModels.getZipCode());
		existingCustomer.setLatitude(customersModels.getLatitude());
		existingCustomer.setLongitude(customersModels.getLongitude());
		existingCustomer.setStreet(customersModels.getStreet());

		customersServices.save(existingCustomer); 

		attributes.addFlashAttribute("mensagem", "Cliente atualizado com sucesso!");
		return "redirect:/listCustomers"; 
	}

}

