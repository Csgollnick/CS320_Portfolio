/*Author Name: Chris Gollnick
 * Date: 14 February 2021
 * Course ID: CS320-T3228
 * Description: Contact.java contains the arrays where all information is stored.  Also 
 * 				contains methods for creation of each field of the contact and checks for them. 
 * */


package cgollnick.cs320t3228;
import java.io.*;
import java.lang.*;
import java.util.*;

public class Contact {
	//Define Arrays
	public String[] cIDs = {"1", "2"};
	public String[] fNames = {"Ellie","Lima"};
	public String[] lNames = {"Rockit", "Bazat"};
	public String[] pNums = {"2234589022", "8015479800"};
	public String[] addresses = {"12 Sunset Strip", "456 Hale Rd"}; 
	
	//Define Variables
	public String contactId;
	public String firstName;
	public String lastName;
	public String phoneNumber;
	public String address;
	public int arrSize;
	public String newElement;
	public int index;
	
	public String storeID;
	public String storeFname;
	public String storeLname;
	public String storePnum
	public String storeAddress;

	public Contact() {
		
	}
	
	
	//Creates New Object
	public void createNew (String contactId, String firstName, String lastName, String phoneNumber, String address) {
		ContactID(contactId);											//Call ContactID Function and pass contactID to it
		FirstName(firstName);											//Call First Name function
		LastName(lastName);												//Call LastName Function
		PhoneNumber(phoneNumber);										//Call PhioneNUmber Function
		Address(address);												//Call Address Fucntion
	}
	//Check Contact ID Length
	public void ContactID(String contactId){
		int cidLEN = contactId.length();								//set cidLEN to length of contact ID							
		if (cidLEN > 10) {												//Checks if Length greater than 10
			throw new IllegalArgumentException							//Throw exception if too long
			("EXCEEDS CHARACTER LIMIT! CONTACT ID MUST BE LESS THAN 10 CHARACTERS!");
		} else {
			arrSize = cIDs.length;										//Set arrSize to length of cIDs
			newElement = contactId;										//set contactId to be the newElement
			cIDs = addNewElementToArray(arrSize, cIDs, newElement);		//Add the new element to the array
			storeID = contactId;										//Stores the contact ID
			
		}
		
	}
	//Check First name Length
	public void FirstName(String firstName) {
		int fLEN = firstName.length();									//set fLEN to be the length of firstName
		if (fLEN > 10) {												//Checks if first name is too many characters
			throw new IllegalArgumentException							//If too long, throw exception
			("EXCEEDS CHARACTER LIMIT! CONTACT ID MUST BE LESS THAN 10 CHARACTERS!");
		} else {
			arrSize = fNames.length;									//Set arrSize to length of fNames
			newElement = firstName;										//Make newElement firstName
			fNames = addNewElementToArray(arrSize, fNames, newElement);	//add newelement to array
			storeFname = firstName;										//Store first name
			
		}
	}
	//Check Last name length
	public void LastName(String lastName) {
		int lLEN = lastName.length();									//set lLen to length of lastName
		if ( lLEN > 10) {												//Checks if last name too long
			throw new IllegalArgumentException							//If too long throw exception
			("EXCEEDS CHARACTER LIMIT! CONTACT ID MUST BE LESS THAN 10 CHARACTERS!");
		} else {
			arrSize = lNames.length;									//Set arrSize to length of lNames
			newElement = lastName;										//make lastName the newElement
			lNames = addNewElementToArray(arrSize, lNames, newElement); //add new element to the array
			storeLname = lastName;										//Store last name
		}
		
	}
	//Check Phone Number Length
	public void PhoneNumber(String phoneNumber) {
		int pLEN = phoneNumber.length();								//set pLen to length of phoneNumber
		if ( pLEN != 10) {												//Check if too many/little characters
			throw new IllegalArgumentException							//If not 10, then exception
			("INVALID FORMAT! PHONE NUMBER MUST BE 10 DIGITS IN THE FORM 1234567890");
		} else {
			arrSize = pNums.length;										//set arrSize to length of pNums
			newElement = phoneNumber;									//set pHoneNumnber to newElement		
			pNums = addNewElementToArray(arrSize, pNums, newElement);	//Add newElement to Array
			storePnum = phoneNumber;									//Store PhoneNumber
		}
		
	}
	//Check Address Length
	public void Address (String address) {
		int aLEN = address.length();									//set aLen to length of address
		if (aLEN > 30) {												//Check if too many characters
			throw new IllegalArgumentException							//Throw exception if too long
			("EXCEEDS CHARACTER LIMIT! ADDRESS MUST BE LESS THAN 30 CHARACTERS");
		} else {
			arrSize = addresses.length;											//set arrSize to length of addresses array
			newElement = address;												//make newElement the Address
			addresses = addNewElementToArray(arrSize, addresses, newElement);	//Add new element to array
			storeAddress = address;												//Store address
		}
		
	}
	//Increase Capacity of Array
		public static String[] addNewElementToArray(int arrSize, String arr[], String newElement) {		
			int i;
			String newarr[] = new String[arrSize+1];
			for (i= 0; i<arrSize ; i++) 
				newarr[i] = arr[i];
			newarr[arrSize] = newElement;
			
			return newarr;
			
		}
		
		public String returnNewContact() {  //Fucntion to return the new contact
			String contactCard = storeID+"|"+storeFname+"|"+storeLname+"|"+storePnum+"|"+storeAddress;
			return contactCard;
		}

}
