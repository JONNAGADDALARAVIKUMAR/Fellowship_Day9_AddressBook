package day9AddressBook;

import java.util.HashMap;
import java.util.Scanner;

public class AddressBookManupulator {
	
	HashMap<String, DetailsCollector> contacts = new HashMap<String, DetailsCollector>();
	static Scanner scanner = new Scanner(System.in);
	static AddressBookManupulator addressBookManupulator = new AddressBookManupulator();
	
	public void choice() {
	
		DetailsCollector collect = addressBookManupulator.getUserInput();
		contacts.put(collect.getEmailId(), collect);
		System.out.println(contacts);
	}
	
	private DetailsCollector getUserInput() {
		
		 	System.out.print("First Name : ");
	        String firstName = scanner.next();
	        System.out.print("Last Name : ");
	        String lastName = scanner.next();
	        System.out.print("Address : ");
	        String address = scanner.next();
	        System.out.print("City : ");
	        String city = scanner.next();
	        System.out.print("Zip Code  ");
	        int zip = scanner.nextInt();
	        System.out.print("State : ");
	        String state = scanner.next();
	        System.out.print("Phone Number  ");
	        long phone = scanner.nextLong();
	        System.out.print("Email Id  ");
	        String emailId = scanner.next();
	        
	        DetailsCollector collect = new DetailsCollector();
	        
	        collect.setFirstName(firstName);
	        collect.setLastName(lastName);
	        collect.setAddress(address);
	        collect.setCity(city);
	        collect.setZip(zip);
	        collect.setState(state);
	        collect.setPhoneNumber(phone);
	        collect.setEmailId(emailId);
		
	        return collect;
	}
}
