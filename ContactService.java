/*AuthorName: Chris Gollnick
 * Date: 14 February 2021
 * Course ID: CS320-T3228
 * Description: Contact Service Class allows for choosing between adding new contacts, updating, or deleting.  
 * It should communicate with the contact class to handle most functions.
 * */
package cgollnick.cs320t3228;

import java.util.Arrays;
import java.util.List;
import java.util.*;
import java.util.stream.*;

public class ContactService {
	
	Contact Contact = new Contact();									//Call in Contact.Java
	public int index = Contact.index;									//link index to Index in Contact
	
	//Declare variables for new contact
	public String newCID;
	public String newFName;
	public String newLName;
	public String newPhoneNumber;
	public String newAddress;
	//Declare variables for update contact
	public String updateFName;
	public String updateLName;
	public String updatePhone;
	public String updateAddress;
	//Variable Declarations for standard use fields
	public String contactId;
	public String firstName;
	public String lastName;
	public String phoneNumber;
	public String address;
	//Confirmation variable decalration
	public String confirm;
	
	//Error Declaration variables
	public String error1 = "EXCEEDS CHARACTER LIMIT(10)!";
	public String error2 = "EXCEEDS CHARACTER LIMIT(30)!";
	public String error3 = "INVALID FORMAT! Phone Number must be (10) Digits in form of 1234567890";	
	public String error4 = "INVALID ENTRY! Field Can Not Be Null";
	public String error5 = "ILLEGAL OPERATION! ID ALREADY EXISTS";
	//Variable declarations for array increments
	public int arrSize;
	public String newElement;
	//Declare Arrays
	public String[] newCIDS;
	public String[] firstNAMES;
	public String[] lastNAMES;
	public String[] phoneNUMS;
	public String[] aDDRESS;
	
	
	public ContactService() {
		
		
	}
	
	//Method to add a new Contact 
		public String addContact(String newCID, String newFName, String newLName, String newPhoneNumber, String newAddress) {
		
			
			//Checks and Adds the new Contact ID to the cIDs Array
			if(newCID != null) {																							//Id Null check
				List<String> list = Arrays.asList(Contact.cIDs);															//Makes list of values from Array
				if (list.contains(newCID)) {	
					throw new IllegalArgumentException(error5);																//Search for Instance of ID, if exists error
					}else{
						int idLength = newCID.length();
						if (idLength > 10) {																				//Checks the Character limit 
							throw new IllegalArgumentException(error1);														//Outputs error message if over limit
							} else {
								arrSize = Contact.cIDs.length;																//Execute method to add new CID to array
								newElement = newCID;
								Contact.cIDs = addNewElementToArray(arrSize, Contact.cIDs, newElement);					
								} 
					}
				}else{
					throw new IllegalArgumentException(error4);																//Error if Field is Null
			
			}
			
			//Checks and adds the new First Name to the fNames Array
			if(newFName != null) {
				int fNLength = newFName.length();																			//Character Limit Check for first name
				if (fNLength > 10) {
					throw new IllegalArgumentException(error1);																//THrow exception if too long
				} else {
					arrSize = Contact.fNames.length;
					newElement = newFName;
					Contact.fNames = addNewElementToArray(arrSize, Contact.fNames, newElement);
				} 
			} else {
				throw new IllegalArgumentException(error4);
			}
			
			//Checks and adds the new Last Name to the lNames Array
			if(newLName != null) {
				int lNLength = newLName.length();																			//Last name Character limit Check
				if (lNLength > 10) {
					throw new IllegalArgumentException(error1);																//Throw exception if too long
				} else {	
					arrSize = Contact.lNames.length;
					newElement = newLName;
					Contact.lNames = addNewElementToArray(arrSize, Contact.lNames, newElement);
				} 
			} else {
				throw new IllegalArgumentException(error4);
			}
			
			//Checks the new phone number for proper format and digits and adds to the array
			if(newPhoneNumber != null) {																	
				int phLength = newPhoneNumber.length();
				if (phLength != 10) {
					throw new IllegalArgumentException(error3);																//If Phone is not 10 characters, returns error message
				} else {
					arrSize = Contact.pNums.length;																			//Execute method to add new phone to array
					newElement = newPhoneNumber;
					Contact.pNums = addNewElementToArray(arrSize, Contact.pNums, newElement);						
				}
			} else {
				throw new IllegalArgumentException(error4);
			}
			//Checks the new address and adds to the array
			if(newAddress != null) {
				int adLength = newAddress.length();																			//Checks Address Character Limit
				if (adLength > 30) {
					throw new IllegalArgumentException(error2);																//Throw exception if too long
				} else {
					arrSize = Contact.addresses.length;
					newElement = newAddress;
					Contact.addresses = addNewElementToArray(arrSize, Contact.addresses, newElement);
				} 
			} else {
				throw new IllegalArgumentException(error4);
			}	
			List<String> list = Arrays.asList(Contact.cIDs);																//Makes list of values from Array
			if (list.contains(newCID)) {	
				String idVal = newCID;																						//Stores contact ID as idVal to be used as search term
				index = getIndexOfElementinArray(Contact.cIDs, idVal);														//index assigned value based on search results from method
			}						
			return Contact.cIDs[index] +"|"+ Contact.fNames[index] +"|"+ 
			Contact.lNames[index] +"|"+ Contact.pNums[index] +"|"+ Contact.addresses[index];								//Returns the new contact
			
	
		}
	
	
	
			//Method to Search for a contact ID and Update the details for it
		public String updateContact(String contactID, String updateFName, String updateLName, String updatePhone, String updateAddress)	{
			List<String> list = Arrays.asList(Contact.cIDs);														//Makes list of values from Array
			if (list.contains(contactId)) {	
				String idVal = contactId;																			//Stores contact ID as idVal to be used as search term
				index = getIndexOfElementinArray(Contact.cIDs, idVal);												//index assigned value based on search results from method
			}
			//Update First name
			if (updateFName == "NC") {																				//Use NC for no change, if exists then field does nto change
				Contact.fNames[index] = Contact.fNames[index];
			} else {
				int fLen = updateFName.length();																	//Check Length for character requirement
				if (fLen > 10) {
					throw new IllegalArgumentException(error1);																		//Prints error if over character limit
				} else {
					Contact.fNames[index] = updateFName;
				}
			}
			//Update last name
			if (updateLName == "NC") {
				Contact.lNames[index] = Contact.lNames[index];									
			} else {
				int lLen = updateLName.length();																	//Checks last Name Length
				if ( lLen > 10) {
					throw new IllegalArgumentException(error1);
				} else {
				Contact.lNames[index] = updateLName;
				}
			}
			//Update phone
			if (updatePhone == "NC") {
				Contact.pNums[index] = Contact.pNums[index];
			} else {
				
				int pLen = updatePhone.length();
				if (pLen != 10) {																					//Checks Phone format and length
					throw new IllegalArgumentException(error3);																		//error if fails check
				} else {
				Contact.pNums[index] = updatePhone;																	//Store new phone number
				}
			}
			
			//Update Address 
			if (updateAddress == "NC") {
				Contact.addresses[index] = Contact.addresses[index];
			} else {
				int aLen = updateAddress.length();
				if (aLen > 30) {																					//Checks address length
					throw new IllegalArgumentException(error2);
				} else {
					Contact.addresses[index] = updateAddress;
				}
			}
			
			return Contact.cIDs[index] +"|"+ Contact.fNames[index] +"|"+ 
			Contact.lNames[index] +"|"+ Contact.pNums[index] +"|"+ Contact.addresses[index]; 						//Returns the updated contact
		}

		//Method to remove an object
		public String deleteContact(String contactId, String confirm) {
			List<String> list = Arrays.asList(Contact.cIDs);														//Makes list of values from Array
			if (list.contains(contactId)) {	
				String idVal = contactId;																			//Stores contact ID as idVal to be used as search term
				index = getIndexOfElementinArray(Contact.cIDs, idVal);	
			}
			System.out.println(Contact.cIDs[index] +"|"+ Contact.fNames[index] +"|"+ 
			Contact.lNames[index] +"|"+ Contact.pNums[index] +"|"+ Contact.addresses[index]);						//Displays The Information Linked to entered ID
			
			System.out.println("Confirm Delete Y/N?");																//Confirms Deletion of Record
			if (confirm == "N") {																					//If N then cancel deletion
				throw new IllegalArgumentException("Deletion Cancelled");
				} else if (confirm == "Y") {																		//If Y then proceed with deletion
					
					String[] tempCID = new String [Contact.cIDs.length - 1];										//Copies array to temp array minus the removed index
					for (int i = 0, j = 0; i < Contact.cIDs.length; i++) {
						if ( i != index) {
							tempCID[j++] = Contact.cIDs[i];
							Contact.cIDs = tempCID.clone();
						}
					}
					String[] tempFN = new String [Contact.fNames.length - 1];										//Copies array to temp array minus the removed index
					for (int i = 0, j = 0; i < Contact.fNames.length; i++) {
						if ( i != index) {
							tempFN[j++] = Contact.fNames[i];
							Contact.fNames = tempFN.clone();
						}
					}
					String[] tempLN = new String [Contact.lNames.length - 1];										//Copies array to temp array minus the removed index
					for (int i = 0, j = 0; i < Contact.lNames.length; i++) {
						if ( i != index) {
							tempLN[j++] = Contact.lNames[i];
							Contact.lNames = tempLN.clone();
						}
					}
					String[] tempPH = new String [Contact.pNums.length - 1];										//Copies array to temp array minus the removed index
					for (int i = 0, j = 0; i < Contact.pNums.length; i++) {
						if ( i != index) {
							tempPH[j++] = Contact.pNums[i];
							Contact.pNums = tempPH.clone();
						}
					}
					String[] tempA = new String [Contact.addresses.length - 1];										//Copies array to temp array minus the removed index
					for (int i = 0, j = 0; i < Contact.addresses.length; i++) {
						if ( i != index) {
							tempA[j++] = Contact.addresses[i];
							Contact.addresses = tempA.clone();
						}
					}
					
					List<String> updateList = Arrays.asList(Contact.cIDs);
					if (list.contains(contactId)) {
						throw new IllegalArgumentException("FAILURE");
					} else {
						System.out.println("DELETION SUCCESS");
				}
				
				} else {
					throw new IllegalArgumentException("Invalid Selection. Canceling delete operation.");	 						//IF anything but Y or N exists for confirm, cancel operation
				}
			
			return "Operation Complete";
		}
		
		
		
		//Method to find the index of an element in an array
		public static int getIndexOfElementinArray (String arrayName[], String searchTerm) {
			
			if (arrayName == null) {
				return -1;																							//Returns -1 if arrayName is null		
			}
			int arrayLength = arrayName.length;																		//Gets the length of the array
			int searchindex = 0;																					//Initialize first index to check is position 0
			
			while (searchindex < arrayLength) {																		//Continues while the index is less than the length of the array
				if (arrayName[searchindex] == searchTerm) {
					return searchindex;																				//Returns the index when search term is found
				} else {
					searchindex = searchindex + 1;																	//If not found at current position, increment by 1
				}
			}		
			return -1;
		}

		//Increase Capacity of Array
		public static String[] addNewElementToArray(int arrSize, String arr[], String newElement) {		
			int i;
			String newarr[] = new String[arrSize+1];																//Creates new array with 1 size larger
			for (i= 0; i<arrSize ; i++) 							
				newarr[i] = arr[i];
			newarr[arrSize] = newElement;																			//copies original array to new array until new item added
					
			return newarr;
		}
		

	public void main(String[] args) {
	
	
	}
	
}
