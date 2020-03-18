import java.util.Scanner;
import java.io.*;

public class Main {

	public static void main(String[] args) {
		// Main Program
		
		// Variable for the file name
		String fileName = "Completed project.txt";
		
		// Scanner to capture input
		Scanner scan = new Scanner(System.in);
		
		// Declare input variable and set to anything except 0
		int menu_input = -1;
		
		// Create arrays of objects. Note: Sizes of the arrays will change
		Project[] projects = new Project[2];
		Person[] clients = new Person[2];
		Person[] contractors = new Person[2];
		Person[] architects = new Person[2];
		
		// ------- Only for Testing -------
		clients[0] = new Person("Jaco", "Steyn", "082", "jaco@mail.com", "1 Road", "Client");
		contractors[0] = new Person("Gustav", "du Plessis", "083", "gus@mail.co.za", "1 Boulevard", "Contractor");
		architects[0] = new Person("Wynand", "Prinsloo", "084", "Wyn@mail.org", "3 Street", "Architect");
		projects[0] = new Project(1, "house", "7 Straat", "1234", "No deadline", clients[0], contractors[0], architects[0]);
		
		// Variables to track places in arrays
		// ------ Should be 0 --------
		int projectIndex = 1;
		int clientIndex = 1;
		int contractorIndex = 1;
		int architectIndex = 1;
		
		// Loop the program until 0 is entered
		while(menu_input != 0) {
			
			// Output menu options
			System.out.println("POISED MAIN MENU");
			System.out.println("Select an option:");
			System.out.println("1 - create new project");
			System.out.println("2 - change due date of a project");
			System.out.println("3 - change the total amount paid for a project");
			System.out.println("4 - update a contractor's details");
			System.out.println("5 - finalise a project");
			System.out.println("0 - exit");
			
			// Capture menu input from user
			menu_input = scan.nextInt();
			scan.nextLine(); // Bypass the 'Enter' pressed from user
			
			if(menu_input == 1) {
				// Get project number
				System.out.println("Project number?");
				int number = scan.nextInt();
				scan.nextLine(); // Bypass 'Enter' pressed from user
				
				// Get client details
				System.out.println("Client name?");
				String client = scan.nextLine();
				System.out.println("Client surname");
				String surname = scan.nextLine();
				System.out.println("Client number?");
				String clientNumber = scan.nextLine();
				System.out.println("Client email?");
				String clientEmail = scan.nextLine();
				System.out.println("Client address?");
				String clientAddress = scan.nextLine();
				
				// Get contractor details
				System.out.println("Contractor name?");
				String contractor = scan.nextLine();
				System.out.println("Contractor surname");
				String conSurname = scan.nextLine();
				System.out.println("Contractor number?");
				String conNumber = scan.nextLine();
				System.out.println("Contractor email?");
				String conEmail = scan.nextLine();
				System.out.println("Contractor address?");
				String conAddress = scan.nextLine();
				
				// Get architect details
				System.out.println("Architect name?");
				String architect = scan.nextLine();
				System.out.println("Architect surname");
				String archSurname = scan.nextLine();
				System.out.println("Architect number?");
				String archNumber = scan.nextLine();
				System.out.println("Architect email?");
				String archEmail = scan.nextLine();
				System.out.println("Architect address?");
				String archAddress = scan.nextLine();
				
				// Get the rest of the project details
				System.out.println("Building type?");
				String building = scan.nextLine();
				System.out.println("Address?");
				String address = scan.nextLine();
				System.out.println("ERF Number?");
				String erf = scan.nextLine();
				System.out.println("Deadline?");
				String deadline = scan.nextLine();
				
				// Save the person in clients array
				clients[clientIndex] = new Person(client, surname, clientNumber, clientEmail, clientAddress, "Client");
				
				// Save the person in contractors array
				contractors[contractorIndex] = new Person(contractor, conSurname, conNumber, conEmail, conAddress, "Contractor");
				
				// Save the person in architects array
				architects[architectIndex] = new Person(architect, archSurname, archNumber, archEmail, archAddress, "Architect");
				
				// Loop until Y/N input is given
				while(true) {
					System.out.println("Does the project have a name? (Y/N)");
					String question = scan.nextLine();
					
					// Create object with projectName
					if(question.equals("Y") || question.equals("y")) {
						System.out.println("Name of the project?");
						String projectName = scan.nextLine();
						projects[projectIndex] = new Project(number, projectName, building, address, erf, deadline, clients[clientIndex], contractors[contractorIndex], architects[architectIndex]);
						break;
					}
					// Generate a projectName
					else if(question.equals("N") || question.equals("n")) {
						projects[projectIndex] = new Project(number, building, address, erf, deadline, clients[clientIndex], contractors[contractorIndex], architects[architectIndex]);
						break;
					}
					else {
						System.out.println("Wrong input! Enter 'Y' or 'N'.\n");
					}
				}
				
				// Output all the details about the new project
				System.out.println("\nNew project created:\n" + projects[projectIndex].toString() + "\n");
				
				// Increment all indexes by 1
				projectIndex++;
				clientIndex++;
				contractorIndex++;
				architectIndex++;
			}
			else if(menu_input == 2) {
				// Change due date of existing project
				if(projectIndex == 0) {
					System.out.println("No projects found!\n");
				}
				else {
					// Ask user for which project they want to access
					System.out.println("Select project number: ");
					int selection = scan.nextInt();
					scan.nextLine(); // To bypass 'Enter' from user
					
					// Get the length of projects array
					int length = projects.length;
					
					// Search project number of each object in array and compare to selection
					for(int i = 0; i < length; i++) {
						try {
							if(projects[i].getProjectNumber() == selection) {
								System.out.println("Set new deadline:");
								String newDeadline = scan.nextLine();
								projects[i].setDeadline(newDeadline);
								
								System.out.println("New deadline set!\n" + projects[i].toString() + "\n");
								
								break;
							}
						}
						catch(Exception e) {
							System.out.println("Project number not found!\n");
							System.out.println("List of project numbers:\n");
							for(int j = 0; j < length; j++) {
								if(projects[j] != null) {
									System.out.println("\t" + projects[j].getProjectNumber() + "\n");
								}
							}
						}
						
					}
				}
			}
			else if(menu_input == 3) {
				// Change the total amount paid for a project
				if(projectIndex == 0) {
					System.out.println("No projects found!\n");
				}
				else {
					// Ask user for which project they want to access
					System.out.println("Select project number:");
					int selection = scan.nextInt();
					scan.nextLine(); // Bypass the 'Enter' from user
					
					// Get the length of projects array
					int length = projects.length;
					
					// Search project number of each object in projects array and compare to selection
					for(int i = 0; i < length; i++) {
						try {
							if(projects[i].getProjectNumber() == selection) {
								System.out.println("Payment amount?");
								double amount = scan.nextDouble();
								scan.nextLine(); // Bypass the 'Enter' from user
								projects[i].setTotalPaid(amount);
								
								System.out.println("Total paid set!\n" + projects[i].toString() + "\n");
								
								break;
							}
						}
						catch(Exception e) {
							System.out.println("Project number not found!\n");
							System.out.println("List of project numbers:\n");
							for(int j = 0; j < length; j++) {
								if(projects[j] != null) {
									System.out.println("\t" + projects[j].getProjectNumber() + "\n");
								}
							}
						}
					}
				}
			}
			else if(menu_input == 4) {
				// Update a contractor's details
				if(contractorIndex == 0) {
					System.out.println("No contractors found!\n");
				}
				else {
					// Ask user for which contractor they want to access
					System.out.println("Enter contractor name:\n");
					String name = scan.nextLine();
					
					// Get the length of contractors array
					int length = contractors.length;
					
					// Search contractor name of each object in contractors array and compare to name
					for(int i = 0; i < length; i++) {
						try {
							if(contractors[i].getName().equals(name)) {
								
								System.out.println("Update number:");
								String newNumber = scan.nextLine();
								System.out.println("Update email:");
								String newEmail = scan.nextLine();
								
								contractors[i].setNumber(newNumber);
								contractors[i].setEmail(newEmail);
								
								System.out.println("Updated details:\n" + contractors[i].toString() + "\n");
								break;
							}
						}
						catch(Exception e) {
							System.out.println("Contractor not found!\n");
							System.out.println("List of contractor names:\n");
							for(int j = 0; j < length; j++) {
								if(contractors[j] != null) {
									System.out.println("\t" + contractors[j].getName() + "\n");
								}
							}
						}
					}
				}
			}
			else if(menu_input == 5) {
				// Finalize a project
				if(projectIndex == 0) {
					System.out.println("No projects found!\n");
				}
				else {
					System.out.println("Select project number:");
					int selection = scan.nextInt();
					scan.nextLine(); // Bypass the 'Enter' from user
					
					// Get the length of projects array
					int length = projects.length;
					
					// Search project number of each object in projects array and compare to selection
					for(int i = 0; i < length; i++) {
						try {
							if(projects[i].getProjectNumber() == selection) {
								
								System.out.println(projects[i].finalise());
								
								// Error handling for the file
								try {
									// Write to file encoding
									FileWriter fileWriter = new FileWriter(fileName);
									
									// Wrap FileWriter in BufferedWriter
									BufferedWriter bw = new BufferedWriter(fileWriter);
									
									// Write all the details about the project to the file
									bw.write(projects[i].toString());
									
									// Close the file
									bw.close();
								}
								catch(IOException e) {
									System.out.println("Error writing to file '" + fileName + "'!");
								}
								
								break;
							}
						}
						catch(Exception e) {
							System.out.println("Project not found!\n");
							System.out.println("List of project numbers:\n");
							for(int j = 0; j < length; j++) {
								if(projects[j] != null) {
									System.out.println("\t" + projects[j].getProjectNumber() + "\n");
								}
							}
						}
					}
				}
			}
			else if(menu_input == 0){
				// Exit the program
				System.out.println("GOODBYE");
				break;
			}
			else {
				// Error for wrong input
				System.out.println("ERROR: Input not recognised!\n");
			}
		}
		
		// Close the scanner
		scan.close();
	}
}
