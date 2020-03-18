
public class Person {
	// ATTRIBUTES
	private String name;
	private String surname;
	private String telNumber;
	private String email;
	private String address;
	private String affiliation;
	
	// METHODS
	// Constructor
	public Person(String name, String surname, String telNumber, String email, String address, String affiliation) {
		this.name = name;
		this.surname = surname;
		this.telNumber = telNumber;
		this.email = email;
		this.address = address;
		this.affiliation = affiliation;
	}
	
	// toString for output
	public String toString() {
		String output = affiliation + " details:";
		output += "\n\tName: " + name + " " + surname;
		output += "\n\tTel Number: " + telNumber;
		output += "\n\tEmail Address: " + email;
		output += "\n\tPhysical Address: " + address;
		
		return output;
	}
	
	// Retrieve the name of a person
	public String getName() {
		return this.name;
	}
	
	// Change the name of a person
	public void setName(String name) {
		this.name = name;
	}
	
	// Retrieve the surname of a person
	public String getSurname() {
		return this.surname;
	}
	
	// Change the surname of a person
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	// Retrieve the number of a person
	public String getNumber() {
		return telNumber;
	}
	
	// Change the number of a person
	public void setNumber(String number) {
		this.telNumber = number;
	}
	
	// Retrieve the email address of a person
	public String getEmail() {
		return this.email;
	}
	
	// Change the email address of a person
	public void setEmail(String email) {
		this.email = email;
	}
	
	// Retrieve the email address of a person
	public String getAddress() {
		return this.address;
	}
	
	// See what affiliation a person has to a project
	public String getAffiliation() {
		return affiliation;
	}
}
