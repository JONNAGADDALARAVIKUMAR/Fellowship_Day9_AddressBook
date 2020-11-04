package day9AddressBook;

import java.util.HashMap;
import java.util.Scanner;

import completeAddressBook.AddressBook;

public class AddressBookMainClass {

	public static void main(String[] args) {
		
		HashMap<String, HashMap> addressBooks = new HashMap<String, HashMap>();//Stores Multiple Address Books
		HashMap<String, DetailsCollector> oneListContacts = new HashMap<String, DetailsCollector>();//Stores Single AddressBook
		Scanner scan = new Scanner(System.in);
		
		System.out.println("\n\tWelcome to Address Book Progrem");
		
		AddressBookManupulator familyAddressBook = new AddressBookManupulator();//family Address Book
		AddressBookManupulator friendsAddressBook = new AddressBookManupulator();//Friends Address Book
	       
	    while (true) {
	        System.out.println("1: for family \n" +
	        					"2: for friend \n" +
	                    		"3: for terminate the program");
	        int selectedOption = scan.nextInt();
	            
	        if (selectedOption == 1) {
	            	
	        	oneListContacts = familyAddressBook.userChoice();
	            addressBooks.put("Family", oneListContacts);
	        }    
	        else if (selectedOption == 2) {
	        	oneListContacts = friendsAddressBook.userChoice();	
	        	addressBooks.put("Friend", oneListContacts);    
	        }    
	        else if(selectedOption == 3) {
	        	break;   
	        }   
	    }
	    System.out.println(addressBooks);
	}
}
