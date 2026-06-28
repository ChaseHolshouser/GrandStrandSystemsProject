import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ContactTest {
	
	// tests that a valid contact can be created successfully
	@Test
	void testValidContact() {
		Contact contact = new Contact("1", "John", "Smith", "1234567890", "123 Main St");
		
		assertEquals("1", contact.getContactId());
		assertEquals("John", contact.getFirstName());
		assertEquals("Smith", contact.getLastName());
		assertEquals("1234567890", contact.getPhone());
		assertEquals("123 Main St", contact.getAddress());
	}
	
	// tests invalid contactId
	@Test
	void testInvalidContactId() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "John", "Smith", "1234567890", "123 Main St");
		});
	}
	
	// tests invalid firstName
	@Test
	void testInvalidFirstName() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", null, "Smith", "1234567890", "123 Main St");
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "JohnJohnJohn", "Smith", "1234567890", "123 Main St");
		});
	}
	
	// tests invalid lastName
	@Test
	void testInvalidLastName() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "John", null, "1234567890", ";123 Main St");
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "John", "SmithSmithSmith", "1234567890", "123 Main St");
		});
	}
	
	// tests invalid phone number
	@Test
	void testInvalidPhone() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "John", "Smith", null, "123 Main St");
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "Java", "Smith", "1234", "123 Main St");			
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "Java", "Smith", "12345678901234", "123 Main St");			
		});
	}
	
	// tests invalid address
	@Test
	void testInvalidAddress() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "Java", "Smith", "1234567890", null);
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "Java", "Smith", "1234567890", "Address that has too many characters Max is set at 30");
		});
	}
}


