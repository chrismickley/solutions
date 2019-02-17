package com.techelevator;

import com.techelevator.inventory.reader.CsvInventoryReader;
import com.techelevator.inventory.reader.InventoryReader;
import com.techelevator.view.Menu;

/**
 * Starts the vending machine applicatoin
 * Creates a new VendingMachineCLI and creates and passes it the inventory reader to use
 *
 */
public class VendingMachineStart {
	
	public static void main(String[] args) {
		
		Menu menu = new Menu(System.in, System.out);
		
		InventoryReader reader = new CsvInventoryReader();
		
		VendingMachineCLI cli = new VendingMachineCLI(menu, reader);
		cli.run();
	}
}
