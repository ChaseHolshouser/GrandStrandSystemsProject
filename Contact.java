public class Contact {
	
	// fields are private to protect the data from outside change
	private final String contactId;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	
	
	// constructor creates a new Contact object and validates all required fields
	public Contact(String contactId, String firstName, String lastName, String phone, String address) {
		
		// contactId must not be null AND be 10 characters or fewer
		if (contactId == null || contactId.length() > 10) {
			throw new IllegalArgumentException("Invalid Contact ID");
		}
		
		// firstName must not be null AND must be 10 characters or fewer
		if (firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("Invald First Name. Try Again.");
		}
		
		// lastName must not be null AND must be 10 characters or fewer
		if (lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid Last Name. Try Again.");
		}
		
		// phone number must not be null AND must be exactly 10 digits
		if (phone == null || !phone.matches("\\d{10}")) {
			throw new IllegalArgumentException("Invalid Phone Number. Try Again.");
		}
		
		// address must not be null AND must be 30 characters or fewer
		if (address == null || address.length() > 30) {
			throw new IllegalArgumentException("Invalid Address. Try Again");
		}
		
		// if all validation passes, assign the values to the object fields
		this.contactId = contactId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
	}
	
	// getters that are public for other classes to read the values
	public String getContactId() {
		return contactId;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getPhone() {
		return phone;
	}
	public String getAddress() {
		return address;
	}

	// setters allow specific fields to be updated after contact creation
	// no setter for contactId because cotactId can not be changed
	public void setFirstName(String firstName) {
		if (firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("Invald First Name. Try Again.");
	}
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		if (lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid Last Name. Try Again.");
	}
		this.lastName = lastName;
	}
	
	public void setPhone(String phone) {
		if (phone == null || !phone.matches("\\d{10}")) {
			throw new IllegalArgumentException("Invalid Phone Number. Try Again.");
	}
		this.phone = phone;
	}
	
	public void setAddress(String address) {
		if (address == null || address.length() > 30) {
			throw new IllegalArgumentException("Invalid Address. Try Again");
	}
		this.address = address;
	}
}







