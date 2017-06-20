package io.swagger.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.ls.LSException;

import io.swagger.client.ApiException;
import io.swagger.client.api.*;

public class PetTest {

	public static void main(String[] args) throws IOException {
		List<String> status = new ArrayList<String>();
		status.add("sold");
		PetApi pet = new PetApi();

		try {
			pet.updatePetWithForm("1", "nicky", "available");
			System.out.println(pet.getPetById((long) 1).getName());
			System.out.println(pet.getPetById((long) 1).getStatus());
			System.out.println(pet.getPetById((long) 1).getTags());
			System.out.println(pet.getPetById((long) 1).getPhotoUrls());
		} catch (ApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}