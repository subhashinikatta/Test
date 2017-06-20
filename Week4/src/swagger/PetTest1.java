package io.swagger.test;

import java.io.IOException;


import io.swagger.client.ApiException;
import io.swagger.client.api.*;
import io.swagger.client.model.Pet;

public class PetTest1 {

	public static void main(String[] args) throws IOException, ApiException {
		PetApi petApi = new PetApi();
		Pet pet = new Pet();
		pet.setName("subhashini");
		pet.setId(1L);
		pet.setStatus("available");
		petApi.addPet(pet);
		System.out.println(petApi.getPetById(1L));

	}
}