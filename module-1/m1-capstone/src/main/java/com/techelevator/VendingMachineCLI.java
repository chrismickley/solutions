package com.techelevator;

import com.techelevator.exception.InvalidAmountException;
import com.techelevator.file.log.TextLogWriter;
import com.techelevator.file.report.SalesReportWriter;
import com.techelevator.inventory.reader.InventoryReader;
import com.techelevator.view.Menu;

/**
 * Handles the workflow of the customer interaction with the vending machine
 *
 */
public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS,
													   MAIN_MENU_OPTION_PURCHASE };
	
	private static final String PURCHASE_MENU_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_FINISH_TRANSACTION = "Finish Transaction";
	private static final String[] PURCHASE_MENU_OPTIONS = { PURCHASE_MENU_FEED_MONEY,
															PURCHASE_MENU_SELECT_PRODUCT,
															PURCHASE_MENU_FINISH_TRANSACTION };
	
	
	private Menu menu;
	private VendingMachine vendingMachine;
	
	/**
	 * Sets the working instance of the menu and creates a new vendingMachine passing it
	 * the InventoryReader and a new Log and Sales Report writer
	 * @param menu
	 * @param reader
	 */
	public VendingMachineCLI(Menu menu, InventoryReader reader) {
		this.menu = menu;
		this.vendingMachine = new VendingMachine(new TextLogWriter(), reader, new SalesReportWriter());
	}
	
	
	/**
	 * Starts the user interaction by displaying the initial menu
	 */
	public void run() { 
		while(true) {
			String choice = (String)menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			
			if(choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display vending machine items
				menu.displayList(vendingMachine.getItemsAsStringList());
			} else if(choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				displayPurchaseMenu();
			}
		}
	}
	
	
	private void displayPurchaseMenu() {
		
		while(true) {
			String choice = (String)menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS, true, vendingMachine.getBalance());
			
			if(choice.equals(PURCHASE_MENU_FEED_MONEY)) {
				displayFeedMoneyMenu();
			} else if(choice.equals(PURCHASE_MENU_SELECT_PRODUCT)) {
				displayPurchaseItemMenu();
				
			} else if(choice.equals(PURCHASE_MENU_FINISH_TRANSACTION)) {
				finishTransaction();
				break;
			}
		}
		
	}
	
	private void displayFeedMoneyMenu() {
		int amount = menu.getAmountFromUserInput();
		try {
			vendingMachine.addToBalance(amount);
		} catch (InvalidAmountException e) {
			menu.displayUserMessage(amount + " is Invalid!", true);
		}
	}
	
	private void displayPurchaseItemMenu() {
		menu.displayList(vendingMachine.getItemsAsStringList());
		String choice = menu.getItemChoiceFromUser(vendingMachine.getBalance());
		VendingMachine.PurchaseStatus status = vendingMachine.makePurchase(choice);
		displayPurchaseStatus(status);	
	}
	
	private void finishTransaction() {
		menu.displayCompleteTransaction(vendingMachine.finishTransaction());
	}
		
	private void displayPurchaseStatus(VendingMachine.PurchaseStatus status) {
	
		boolean isError = true;
		String message = "";
			
		switch(status) {
			case OK:
				message = "Thank you for your purchase";
				isError = false;
				break;
			case INVALIDITEM:
				message = "Invalid Selection, please try again.";
				break;
			case SOLDOUT:
				message = "Item Sold Out";
				break;
			case NOTENOUGHMONEY:
				message = "Please insert more money to purchase this item";
				break;		
		}
		menu.displayUserMessage(message, isError);
		
	}
	
	

}
