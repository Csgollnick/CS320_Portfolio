/*Author Name: Chris Gollnick
 * Date: 14 February 2021
 * Course ID: CS320-T3228
 * Description: Junit Tests for the Contact.java file.  Tests Creating an object. 
 * 				Tests length of each item variable and outputs error in console when exceeding the limits.
 * */

package Test.cgollnick.cs320t3228;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import cgollnick.cs320t3228.*;




public class ContactTest {
	Contact Contact = new Contact();
	
	@Test	//Tests Createing a New Contact Object
	public void createObjectTest() {
		Contact.createNew("2", "James", "May", "1326545453", "12 Main St");
		assertEquals("2|James|May|1326545453|12 Main St", Contact.returnNewContact());
	}
	
	@Test //Test When Contact ID is too Long
	public void contactIDTest() {
		Assertions.assertThrows(IllegalArgumentException.class,()->{Contact.ContactID("234567891234567");});
	}
	@Test //Tests when the names are too long
	public void namesLengthTest() {
		Assertions.assertThrows(IllegalArgumentException.class,()->{Contact.FirstName("Megalomanickla");});
		Assertions.assertThrows(IllegalArgumentException.class,()->{Contact.LastName("Uberkensovincala");});
	}
	
	@Test //Tests when address is too Long
	public void addressLengthTest() {
		Assertions.assertThrows(IllegalArgumentException.class,()->{Contact.Address("10237 Hollywood Blvd, Buena Vista, CA 98923");});
	}
	
	@Test //Tests when phone number is not correct format
	public void phoneNumberLengthTest() {
		Assertions.assertThrows(IllegalArgumentException.class,()->{Contact.PhoneNumber("449075642367");});
	}

	

}
