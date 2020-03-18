
public class Project {
	// ATTRIBUTES
	private int projectNumber;
	private String projectName;
	private String buildingType;
	private String address;
	private String erfNumber;
	private double totalCost;
	private double totalPaid;
	private String deadline;
	private String completionDate = "";
	private boolean isFinalised = false;
	private Person client;
	private Person contractor;
	private Person architect;
	
	// METHODS
	// Constructor without projectName
	public Project(int number, String type, String address, String erf, String deadline, Person client, Person contractor, Person architect) {
		this.projectNumber = number;
		this.buildingType = type;
		this.address = address;
		this.erfNumber = erf;
		this.deadline = deadline;
		this.client = client;
		this.contractor = contractor;
		this.architect = architect;
		this.totalPaid = 0;
		this.projectName = generateProjectName();
		this.totalCost = 1000;
	}
	
	// Constructor with projectName
	public Project(int number, String name, String type, String address, String erf, String deadline, Person client, Person contractor, Person architect) {
		this.projectNumber = number;
		this.projectName = name;
		this.buildingType = type;
		this.address = address;
		this.erfNumber = erf;
		this.deadline = deadline;
		this.client = client;
		this.contractor = contractor;
		this.architect = architect;
		this.totalPaid = 0;
		this.totalCost = 1000;
	}
	
	// toString for output
	public String toString() {
		String output = "Project Number: " + projectNumber;
		output += "\nProjectName: " + projectName;
		output += "\n" + client.toString();
		output += "\nBuilding Type: " + buildingType;
		output += "\nAddress: " + address;
		output += "\n" + contractor.toString();
		output += "\n" + architect.toString();
		output += "\nERF Number: " + erfNumber;
		output += "\nDeadline: " + deadline;
		output += "\nTotal Paid: R " + totalPaid;
		
		return output;
	}
	
	// Generate a name for the project
	private String generateProjectName() {
		// Code to return surname + type of building as string
		String result = this.client.getSurname() + " " + this.buildingType;
		return result;
	}
	
	// Change the deadline for a project
	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}
	
	// Finalize a project
	public String finalise() {
		String output;
		
		// Check if the project has been finalized before
		if(isFinalised) {
			output = "Project already finalised";
		}
		else {
			// Check how much the client has paid for the project
			if(this.totalPaid == this.totalCost) {
				output = "Project paid in full.";
			}
			else if(this.totalPaid > this.totalCost){
				output = "Overpaid: R " + (this.totalPaid - this.totalCost);
			}
			else {
				output = "INVOICE\n";
				output += "Client:\n";
				output += this.client.getName() + "\n";
				output += this.client.getNumber() + "\n";
				output += this.client.getEmail() + "\n";
				
				output += "Total Cost:\tR " + this.totalCost + "\n";
				output += "Total Paid:\tR " + this.totalPaid + "\n";
				output += "Remaining:\tR " + (this.totalCost - this.totalPaid) + "\n";
				
				this.setCompletionDate(this.deadline);
				
				output += "Completion Date: " + getCompletionDate();
			}
		}
		
		isFinalised = true;
		return output;
	}
	
	// Change to amount paid by client
	public void setTotalPaid(double paid) {
		this.totalPaid = paid;
	}
	
	// Return the project number
	public int getProjectNumber() {
		return this.projectNumber;
	}
	
	// Set the completion date
	public void setCompletionDate(String date) {
		this.completionDate = date;
	}
	
	// Get the completion date
	public String getCompletionDate() {
		return this.completionDate;
	}
}
