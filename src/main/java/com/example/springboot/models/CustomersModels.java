package com.example.springboot.models;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "TB_Customers")
public class CustomersModels implements Serializable {
	
	private static final long serialVersionUID = 1L; 
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private UUID idCustomers;	
	
    @NotBlank(message = "O nome é obrigatório")
    private String name;

    @Pattern(regexp = "\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2}", message = "Digite um CNPJ válido")
    @NotBlank(message = "O CNPJ é obrigatório")
    @Size(min = 14, max = 18, message = "O CNPJ deve ter entre 14 e 18 caracteres")
    private String cnpj;
	
    @Digits(integer = 10, fraction = 0, message = "Digite um número válido")
	private String number;
    
    @NotBlank(message = "A cidade é obrigatória")
    private String city;

    @NotBlank(message = "O estado é obrigatório")
    private String state;

    @Pattern(regexp = "\\d{5}-\\d{3}", message = "Digite um CEP válido")
    @NotBlank(message = "O CEP é obrigatório")
    private String zipCode;

    @DecimalMin(value = "-90.0", inclusive = false, message = "Digite uma latitude válida")
    @DecimalMax(value = "90.0", inclusive = false, message = "Digite uma latitude válida")
    @NotBlank(message = "A latitude é obrigatória")
    private String latitude;

    @DecimalMin(value = "-180.0", inclusive = false, message = "Digite uma longitude válida")
    @DecimalMax(value = "180.0", inclusive = false, message = "Digite uma longitude válida")
    @NotBlank(message = "A longitude é obrigatória")
    private String longitude;

    @NotBlank(message = "A rua é obrigatória")
    private String street;


	public UUID getIdCustomers() {
		return idCustomers;
	}

	public void setIdCustomers(UUID idCustomers) {
		this.idCustomers = idCustomers;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}


	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	
	}
    
}