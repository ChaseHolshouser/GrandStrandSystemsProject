import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ContactServiceTest {
	
	// tests that a contact can be added an retrieved
	@Test
	void testAddContact() {
		ContactService service = new ContactService();
		
		Contact contact = new Contact("1", "John", "Smith", "1234567890", "123 Main St");
		
		service.addContact(contact);
		
		assertEquals(contact, service.getContact("1"));
	}
	
	// tests that duplicate contactIds are rejected
	@Test
	void testDuplicateContactId() {
		ContactService service = new ContactService();
		
		Contact contact1 = new Contact("1", "John", "Smith", "1234567890", "123 Main St");	
		Contact contact2 = new Contact("1", "Billy", "Bob", "0987654321", "456 West St");
		
		service.addContact(contact1);
		
		assertThrows(IllegalArgumentException.class, () -> {
			service.addContact(contact2);
		});
	}
	
	// tests that a contact can be deleted
	@Test
	void testDeleteContact() {
		ContactService service = new ContactService();
		
		Contact contact = new Contact("1", "John", "Smith", "1234567890", "123 Main St");
		
		service.addContact(contact);
		service.deleteContact("1");
		
		assertThrows(IllegalArgumentException.class, () -> {
			service.getContact("1");
		});
	}
	
	// tests updating firstName
	@Test
	void testUpdateFirstName() {
		ContactService service = new ContactService();
		
		Contact contact = new Contact("1", "John", "Smith", "1234567890", "123 Mainn St");
		
		service.addContact(contact);
		service.updateFirstName("1", "Billy");
		
		assertEquals("Billy", service.getContact("1").getFirstName());
	}
	
	// tests updating lastName
	@Test
	void testUpdateLastName() {
		ContactService service = new ContactService();
		
		Contact contact = new Contact("1", "John", "Smith", "1234567890", "123 Mainn St");
		
		service.addContact(contact);
		service.updateLastName("1", "Bob");
		
		assertEquals("Bob", service.getContact("1").getLastName());
	}
	
	// tests updating phone number
	@Test
	void testUpdatePhone() {
		ContactService service = new ContactService();
		
		Contact contact = new Contact("1", "John", "Smith", "1234567890", "123 Mainn St");
		
		service.addContact(contact);
		service.updatePhone("1", "0987654321");
		
		assertEquals("0987654321", service.getContact("1").getPhone());
	}
	
	// tests updating address
	@Test
	void testUpdateAddress() {
		ContactService service = new ContactService();
		
		Contact contact = new Contact("1", "John", "Smith", "1234567890", "123 Main St");
		
		service.addContact(contact);
		service.updateAddress("1", "456 West St");
		
		assertEquals("456 West St", service.getContact("1").getAddress());
	}
	
	// tests that attempting to update a contact that does not exist throws exception
	@Test
	void testUpdateInvalidContactId() {
		ContactService service = new ContactService();
		
		assertThrows(IllegalArgumentException.class, () -> {
			service.updateFirstName("99",  "Billy");
		});
	}
}
