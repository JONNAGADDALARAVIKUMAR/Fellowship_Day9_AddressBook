package day9AddressBook;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class AddressBookManupulator {
	
	HashMap<String, DetailsCollector> contacts = new HashMap<String, DetailsCollector>();
	static Scanner scanner = new Scanner(System.in);
	
	int choice = 1;
	public HashMap<String, DetailsCollector> userChoice() {
		
		while(choice != 5) {
			switch (choice) {
			
				case 1://Adds contact
					System.out.println("Add new Contact");
					DetailsCollector collect = getUserInput();
					contacts.put(collect.getEmailId(), collect);
					System.out.print("\n1.Create New Contact\n2.Read Existing Contact\n3.Update Existing Contact\n4.Delete Existing Contact\n5.Exit\nOption : ");
					choice = scanner.nextInt();
					break;
					
				case 2: //Reads Contact
					readContacts();
					System.out.print("\n1.Create New Contact\n2.Read Existing Contact\n3.Update Existing Contact\n4.Delete Existing Contact\n5.Exit\nOption : ");
					choice = scanner.nextInt();
					break;

				case 3: //Updates Contact
					updateContacts();
					System.out.print("\n1.Create New Contact\n2.Read Existing Contact\n3.Update Existing Contact\n4.Delete Existing Contact\n5.Exit\nOption : ");
					choice = scanner.nextInt();
					break;
				case 4: //Deletes Contact
					deleteContacts();
					System.out.print("\n1.Create New Contact\n2.Read Existing Contact\n3.Update Existing Contact\n4.Delete Existing Contact\n5.Exit\nOption : ");
					choice = scanner.nextInt();
					break;
				
				case 5: //Terminates Program
					break;
				
				default: //If User Enters Invalid
					while(choice > 0 && choice < 9) {
						System.out.println("Enter valid Option");
						choice = scanner.nextInt();
					}
					break;
			}
		}
		System.out.println("\n\tProgram Terminated");
		choice = 1;
		return contacts;
	}
	
	private DetailsCollector getUserInput() { //Takes Input from User
		
		 	System.out.print("First Name : ");
	        String firstName = scanner.next();
	        System.out.print("Last Name : ");
	        String lastName = scanner.next();
	        System.out.print("Address : ");
	        String address = scanner.next();
	        System.out.print("City : ");
	        String city = scanner.next();
	        System.out.print("Zip Code : ");
	        int zip = scanner.nextInt();
	        System.out.print("State : ");
	        String state = scanner.next();
	        System.out.print("Phone Number : ");
	        long phone = scanner.nextLong();
	        System.out.print("Email Id : ");
	        String emailId = scanner.next();
	        
	        DetailsCollector collect = new DetailsCollector(); //POJO class
	        
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
	
	private void readContacts() { //Method to read all contacts
		
		Set<String> allKeys = contacts.keySet(); //Stores All Unique Contact Keys
		
		System.out.println("\nEnter Which contact you want to Read");
		for(String key : allKeys) {
			System.out.println(key);
		}
		
		System.out.print("Key : ");
		String readWithKey = scanner.next();
		
		if(contacts.containsKey(readWithKey)) { //Shows Contact Details Stored in Entered Unique Key
			
			System.out.println("\nContact Details :");
			DetailsCollector showDetailsToUpdate = contacts.get(readWithKey);
			
			System.out.println("\n\tFirst Name\t:\t"+showDetailsToUpdate.getFirstName()
								+"\n\tLast Name\t:\t"+showDetailsToUpdate.getLastName()
								+"\n\tAddress\t\t:\t"+showDetailsToUpdate.getAddress()
								+"\n\tCity\t\t:\t"+showDetailsToUpdate.getCity()
								+"\n\tZip Code\t:\t"+showDetailsToUpdate.getZip()
								+"\n\tState\t\t:\t"+showDetailsToUpdate.getState()
								+"\n\tPhone Nuber\t:\t"+showDetailsToUpdate.getPhoneNumber()
								+"\n\tEmail ID\t:\t"+showDetailsToUpdate.getEmailId());
			
		}
		else {
			System.out.println("\nInvalid Key !!!");
		}
	}
	private void updateContacts() { //Updates Contacts
		
		System.out.println("\nEnter Which contact you want to update");
		
		Set<String> allKeys = contacts.keySet(); //Stores All Unique Contact Keys
		
		for(String key : allKeys) {
			System.out.println(key);
		}
		
		System.out.print("Key : ");
		String updateWithKey = scanner.next();
		
		if(contacts.containsKey(updateWithKey)) { //Shows Contact Details Stored in Entered Unique Key
			
			DetailsCollector showDetailsToUpdate = contacts.get(updateWithKey);
			
			int updateDoneOption = 1;
			while(updateDoneOption == 1) { //Runs Until Completion of Multiple Updates on a contact
				
				System.out.println("\nEnter Choice to Update");
				System.out.println("\n\t1.First Name\t:\t"+showDetailsToUpdate.getFirstName()
									+"\n\t2.Last Name\t:\t"+showDetailsToUpdate.getLastName()
									+"\n\t3.Address\t:\t"+showDetailsToUpdate.getAddress()
									+"\n\t4.City\t\t:\t"+showDetailsToUpdate.getCity()
									+"\n\t5.Zip Code\t:\t"+showDetailsToUpdate.getZip()
									+"\n\t6.State\t\t:\t"+showDetailsToUpdate.getState()
									+"\n\t7.Phone Nuber\t:\t"+showDetailsToUpdate.getPhoneNumber()
									+"\n\t8.Email ID\t:\t"+showDetailsToUpdate.getEmailId());
			
				boolean entry = true;
			
				while(entry) {
					
					System.out.print("Option : ");
					int optionToUpdate = scanner.nextInt(); //Takes Option to update Contact details
				
					switch(optionToUpdate) {
				
					case 1:
						System.out.print("First Name : ");
						String firstName = scanner.next();
						showDetailsToUpdate.setFirstName(firstName);
						System.out.print("Updated\n\n1.Update More Details\n2.Updates Enough\nOption : ");
						updateDoneOption = scanner.nextInt();
						entry = false;
						break;
					
					case 2:
						System.out.print("Last Name : ");
						String lastName = scanner.next();
						showDetailsToUpdate.setLastName(lastName);
						System.out.print("Updated\n\n1.Update More Details\n2.Updates Enough\nOption : ");
						updateDoneOption = scanner.nextInt();
						entry = false;
						break;
					
					case 3:
						System.out.print("Address : ");
						String address = scanner.next();
						showDetailsToUpdate.setAddress(address);
						System.out.print("Updated\n\n1.Update More Details\n2.Updates Enough\nOption : ");
						updateDoneOption = scanner.nextInt();
						entry = false;
						break;
					
					case 4:
						System.out.print("City : ");
						String city = scanner.next();
						showDetailsToUpdate.setCity(city);
						System.out.print("Updated\n\n1.Update More Details\n2.Updates Enough\nOption : ");
						updateDoneOption = scanner.nextInt();
						entry = false;
						break;
					
					case 5:
						System.out.print("Zip Code : ");
						int zip = scanner.nextInt();
						showDetailsToUpdate.setZip(zip);
						System.out.print("Updated\n\n1.Update More Details\n2.Updates Enough\nOption : ");
						updateDoneOption = scanner.nextInt();
						entry = false;
						break;
					
					case 6:
						System.out.print("State : ");
						String state = scanner.next();
						showDetailsToUpdate.setState(state);
						System.out.print("Updated\n\n1.Update More Details\n2.Updates Enough\nOption : ");
						updateDoneOption = scanner.nextInt();
						entry = false;
						break;
					
					case 7:
						System.out.print("Phone Number : ");
						long phoneNumber = scanner.nextLong();
						showDetailsToUpdate.setPhoneNumber(phoneNumber);
						System.out.print("Updated\n\n1.Update More Details\n2.Updates Enough\nOption : ");
						updateDoneOption = scanner.nextInt();
						entry = false;
						break;
					
					case 8:
						System.out.print("Email : ");
						String email = scanner.next();
						showDetailsToUpdate.setEmailId(email);
						contacts.put(showDetailsToUpdate.getEmailId(), showDetailsToUpdate);
						contacts.remove(updateWithKey);
						System.out.print("Updated\n\n1.Update More Details\n2.Updates Enough\nOption : ");
						updateDoneOption = scanner.nextInt();
						entry = false;
						break;
						
					default:
						System.out.println("Enter Valid Option");
						break;
					}
				}
			}
		}
		else {
			System.out.println("\nInvalid Key !!!");
		}
	}
	private void deleteContacts() {
		
		Set<String> allKeys = contacts.keySet(); //Stores All Unique Contact Keys
		System.out.println("\nEnter Which contact you want to Delete");
		
		for(String key : allKeys) {
			System.out.println(key);
		}
		System.out.print("Key : ");
		String deleteWithKey = scanner.next();
		
		if(contacts.containsKey(deleteWithKey)) { //Deletes Contact based on Entered Unique Key
			contacts.remove(deleteWithKey);
			System.out.println("Deleted Successfully");
		}
	}
}
