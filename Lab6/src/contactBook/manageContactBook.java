package contactBook;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;

public class manageContactBook {
	//All lists and scanners at the top to user across the program
	static Scanner input = new Scanner(System.in);
	
	static ArrayList<String> contactNamesArrayList = new ArrayList<>();
	static ArrayList<String> contactNumbersArrayList = new ArrayList<>();
	
	static LinkedList<String> contactNamesLinkedList = new LinkedList<>();
	static LinkedList<String> contactNumbersLinkedList = new LinkedList<>();

	public static void addContact(int implementation) {	

		System.out.println("Enter contact name: ");
		String contactName = input.nextLine();
		
		System.out.println("Enter contact phone number: ");
		String phoneNumber = input.nextLine();
		
		while(phoneNumber.length() != 10) {
			System.out.println("Invalid phone number. Enter 10 digit contact phone number: ");
			phoneNumber = input.nextLine();
		}
		//Creates contacts depending on user inputs
		if (implementation == 1) {
			contactNamesArrayList.add(contactName);
			contactNumbersArrayList.add(phoneNumber);
		}
		
		else if (implementation == 2) {
			contactNamesLinkedList.add(contactName);
			contactNumbersLinkedList.add(phoneNumber);
		}
	}
	
	public static void removeContact(int implementation) {
		System.out.println("Enter contact you would like to remove: ");
		String contactToRemove = input.nextLine();
		
		if (implementation == 1) {
			int index = contactNamesArrayList.indexOf(contactToRemove);
			//contact doesn't exist
			while(index == -1) {
				System.out.println("Contact not found. Enter contact you would like to remove: ");
				contactToRemove = input.nextLine();
				index = contactNamesArrayList.indexOf(contactToRemove);
			}
			//contact does exist
			contactNamesArrayList.remove(index);
			contactNumbersArrayList.remove(index);
		}
		
		else if (implementation == 2) {
			int index = contactNamesLinkedList.indexOf(contactToRemove);
			//contact doesn't exist
			while(index == -1) {
				System.out.println("Contact not found. Enter contact you would like to remove: ");
				contactToRemove = input.nextLine();
				index = contactNamesLinkedList.indexOf(contactToRemove);
			}
			//contact does exist
			contactNamesLinkedList.remove(index);
			contactNumbersLinkedList.remove(index);
		}
	}
	
	public static void updateContact(int implementation) {
		System.out.println("Enter contact you would like to update: ");
		String contactToUpdate = input.nextLine();
		
		//checking which implementation the user entered
		
		if (implementation == 1) {
			
			int index = contactNamesArrayList.indexOf(contactToUpdate);
			//if index doesn't exist
			if (index == -1) {
				do {
					System.out.println("Contact not found.");
					System.out.println("Enter contact you would like to update: ");
					contactToUpdate = input.nextLine();
					index = contactNamesArrayList.indexOf(contactToUpdate);
					
				} while(index == -1);
			}
			//index does exist
			else if (index != -1) {
				System.out.println("Enter new name: ");
				String newName = input.nextLine();
				
				System.out.println("Enter new phone number: ");
				String newPhoneNumber = input.nextLine();
				//checking if valid phone number
				
				while(newPhoneNumber.length() != 10) {
					System.out.println("Invalid phone number. Enter 12 digit contact phone number: ");
					newPhoneNumber = input.nextLine();
				}
				contactNamesArrayList.set(index, newName);
				contactNumbersArrayList.set(index, newPhoneNumber);
			}
		}
		//other implementation
		else if (implementation == 2) {
			int index = contactNamesLinkedList.indexOf(contactToUpdate);
			//if index doesn't exist
			if (index == -1) {
				do {
					System.out.println("Contact not found.");
					System.out.println("Enter contact you would like to update: ");
					contactToUpdate = input.nextLine();
					index = contactNamesLinkedList.indexOf(contactToUpdate);
					
				} while(index == -1);
			}
			//index does exist
			else if (index != -1) {
				System.out.println("Enter new name: ");
				String newName = input.nextLine();
				
				System.out.println("Enter new phone number: ");
				String newPhoneNumber = input.nextLine();
				
				//checking if valid phone number
				while(newPhoneNumber.length() != 10) {
					System.out.println("Invalid phone number. Enter 12 digit contact phone number: ");
					newPhoneNumber = input.nextLine();
				}
				contactNamesLinkedList.set(index, newName);
				contactNumbersLinkedList.set(index, newPhoneNumber);
			}
		}
	}
	
	public static void searchContact(int implementation) {
		System.out.println("Enter contact name to search: ");
		String contactToSearch = input.nextLine();
		
		//checking user implementation
		
		if (implementation == 1) {
			int index = contactNamesArrayList.indexOf(contactToSearch);
			//index doesn't exist
			if (index == -1) {	
				do {
					System.out.println("Contact not found. Please enter again.");
					System.out.println("Enter contact name to search: ");
					contactToSearch = input.nextLine();
					index = contactNamesArrayList.indexOf(contactToSearch);
				} while(index == -1);
			//index exists
			} else {
				System.out.println("Contact Found: ");
				System.out.println("Name: " + contactNamesArrayList.get(index));
				System.out.println("Phone: " +contactNumbersArrayList.get(index));
			}
		}
		//other implementation
		else if (implementation == 2) {
			int index = contactNamesLinkedList.indexOf(contactToSearch);
			//index doesn't exist
			if (index == -1) {	
				do {
					System.out.println("Contact not found. Please enter again.");
					System.out.println("Enter contact name to search: ");
					contactToSearch = input.nextLine();
					index = contactNamesLinkedList.indexOf(contactToSearch);
				} while(index == -1);
			//index exists
			} else {
				System.out.println("Contact Found: ");
				System.out.println("Name: " + contactNamesLinkedList.get(index));
				System.out.println("Phone: " +contactNumbersLinkedList.get(index));
			}
		}
	}
	
	public static void displayContacts(int implementation) {
		System.out.println("All contacts: ");
		//checking user input
		if (implementation == 1) {
			for (int i = 0; i < contactNamesArrayList.size(); i++) {
				System.out.println(i+1 + ". " + contactNamesArrayList.get(i) + "-" + contactNumbersArrayList.get(i));
			}
		}
		else if (implementation == 2) {
			for (int i = 0; i < contactNamesLinkedList.size(); i++) {
				System.out.println(i+1 + ". " + contactNamesLinkedList.get(i) + "-" + contactNumbersLinkedList.get(i));
			}
		}
	}
	
	
	public static void main(String[] args) {
		System.out.println("Choose implementation: 1 - ArrayList, 2 - LinkedList");
		int implementation = input.nextInt();
		
		//This loops if the user doesn't enter option 1 or 2 and does so
		//until they do pick 1 or 2
		while(implementation != 1 && implementation != 2) {
			System.out.printf("Option %d not known. Please enter again.\n", implementation);
			System.out.println("Choose implementation: 1 - ArrayList, 2 - LinkedList");
			implementation = input.nextInt();
			input.nextLine();
		}
		
		int choice = 0;
		
		//in case user enters something else besides the menu numbers
		do {
			
			//display menu
			
			System.out.println("Contact Book Menu:");
			System.out.println("1. Add Contact");
			System.out.println("2. Remove Contact");
			System.out.println("3. Update Contact");
			System.out.println("4. Search Contact");
			System.out.println("5. Display Contacts");
			System.out.println("6. Exit");
			System.out.println("Enter your choice: ");
				
			choice = input.nextInt();
			input.nextLine();
			
			//Using the user input to run the correct method

			switch(choice) {
				case 1: 
					addContact(implementation);
					System.out.println("Contact added.");
					break;
				case 2:
					removeContact(implementation);
					System.out.println("Contact removed.");
					break;
				case 3:
					updateContact(implementation);
					System.out.println("Contact updated.");
					break;
				case 4:
					searchContact(implementation);
					break;
				case 5:
					displayContacts(implementation);
					break;
				case 6:
					System.out.println("Exitting program.");
					input.close();
					return;
				default: 
					System.out.println("Unknown option. Please try again.");
				}
			//reiterating that this is in case the user enters an unknown option
		} while(choice !=6);
		input.close();
	}
}
