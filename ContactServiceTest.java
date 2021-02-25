/*Author Name: Chris Gollnick
 * Date: 14 February 2021
 * Course ID: CS320-T3228
 * Description: Junit Tests for the ContactService.java file.  Tests Creating an object. 
 * 				Tests length of each item variable and outputs error in console when exceeding the limits.
 * */

package Test.cgollnick.cs320t3228;

import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import cgollnick.cs320t3228.*;

class ContactServiceTest {
	ContactService ContactService = new ContactService();
	
	@Test  //Test add single contact
	public void SingleContactAddTest() {
		String id = "8";
		String fn ="Kelly";
		String ln = "Migras";
		String ph = "9876754456";
		String ad = "1 Merifda lane";
		assertEquals("8|Kelly|Migras|9876754456|1 Merifda lane", ContactService.addContact(id,fn,ln,ph,ad));
	}
	
	@Test //Test adding multiple contacts
	public void MultiContactAddTest() {
		int i = 0; 
		int l = 2;
		String[] cID = {"12","13"};
		String[] firstN = {"Matt", "Bryant"};
		String[] lastN = {"Jonas","Cyr"};
		String[] phN = {"5238859023","2026478934"};
		String[] addR = {"78 Killway Dr", "678 PolandSprings Lane"};
		String newCID;
		String newFName;
		String newLName;
		String newPhoneNumber;
		String newAddress;
		
		while(i < l) {
			newCID = cID[i];
			newFName = firstN[i];
			newLName = lastN[i];
			newPhoneNumber = phN[i];
			newAddress = addR[i];
			
			assertEquals(newCID+"|"+newFName+"|"+newLName+"|"+newPhoneNumber+"|"+newAddress, ContactService.addContact(newCID, newFName, newLName, newPhoneNumber, newAddress));
			i = i + 1;
		}		
	}
	@Test  //Tests for error when ID already exists
	public void DuplicateIdTest() {
		assertThrows(IllegalArgumentException.class, ()->{ContactService.addContact("1", "Jimmy", "Fans", "7745678912", "543 Lost Ave");});
	}
	@Test  //Tests for getting contact back
	public void AddContactRetrieveNewContactTest() {
		ContactService.addContact("11", "Billybob", "Glisten", "9820901234", "43 Gravelville Lane");
		
	}
	
	@Test  //tests the update Functions
	public void UpdateContactTest() {
		assertEquals("1|Lisa|Billas|2234589022|12 Sunset Strip", ContactService.updateContact("1", "Lisa", "Billas", "NC", "NC"));
		
		
	}
	@Test  //Test Deletion functions
	public void DeleteContactTest() {
		assertEquals("Operation Complete", ContactService.deleteContact("10", "Y"));
		
	}

}
