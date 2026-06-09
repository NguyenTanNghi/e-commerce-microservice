package com.programmingtechie.inventory_service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.programmingtechie.inventory_service.model.Inventory;
import com.programmingtechie.inventory_service.repository.InventoryRepository;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}
    @Bean
    public CommandLineRunner loadData(InventoryRepository inventoryRepository) {
        return args -> {
            Inventory inventory = new Inventory();
            inventory.setSkuCode("iphone-13");
            inventory.setQuantity(100);
            inventoryRepository.save(inventory);

            Inventory inventory2 = new Inventory();
            inventory2.setSkuCode("iphone-13-red");
            inventory2.setQuantity(0);
            inventoryRepository.save(inventory2);
        };
    }

}
