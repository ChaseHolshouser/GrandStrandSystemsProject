import java.util.HashMap;
import java.util.Map;

public class ContactService {
	
	// creates HashMap for data storage
	// courseId is the key and the value is the Contact object
	private final Map<String, Contact> contacts = new HashMap<>();
	
	// method for adding a contact that is not null and the id is unique
	public void addContact(Contact contact) {
		
		// check for empty contact
		if (contact == null) {
			throw new IllegalArgumentException("Contact Cannot Be Null");
		}
		
		// check for duplicate contactId
		if (contacts.containsKey(contact.getContactId())) {
			throw new IllegalArgumentException("Contact ID Must Be Unique");
		}
		
		// add contact to HashMap
		contacts.put(contact.getContactId(), contact);
	}
	
	// method for deleting a contact per contact Id
	public void deleteContact(String contactId) {
		
		// check that contact Id exists
		if (!contacts.containsKey(contactId)) {
			throw new IllegalArgumentException(" Contact Id Not Found.");
		}
		
		// deletes contact
		contacts.remove(contactId);
	}
	
	// method to search and return a contact
	public Contact getContact(String contactId) {
		if (!contacts.containsKey(contactId)) {
			throw new IllegalArgumentException("Contact ID ot Found,");
		}
		
		return contacts.get(contactId);	
	}
	
	// updates firstName for a specific contact
	public void updateFirstName(String contactId, String firstName) {
		getContact(contactId).setFirstName(firstName);
	}
	
	// updates lastName for a specific contact
	public void updateLastName(String contactId, String lastName) {
		getContact(contactId).setLastName(lastName);
	}
	
	// updates phone number for a specific contact
	public void updatePhone(String contactId, String phone) {
		getContact(contactId).setPhone(phone);
	}
	
	// updates address for a specific contact
	public void updateAddress(String contactId, String address) {
		getContact(contactId).setAddress(address);
	}
}
