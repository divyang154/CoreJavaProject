package mainApplication;

import java.io.IOException;
import java.util.Scanner;

import FileOperations.FileOperationsManagementImpl;
import FileOperations.FileOperationsManagementInterface;

public class MainApplication {

	public static void main(String[] args) {

		System.out.println("Welcome to File Management System");

		FileOperationsManagementInterface fileOpMgmtinst = new FileOperationsManagementImpl();
		boolean exitApplication = false;
		Scanner userInput = new Scanner(System.in);
		do {
			System.out.println("**********************************************");
			System.out.println("1. Display existing file names ");
			System.out.println("2. Add/Delete/Search a file");
			System.out.println("3. Exit");
			System.out.println("Please enter an option:-");
			String menuSelected = userInput.nextLine();

			switch (menuSelected) {

			case "1":
				System.out.println("Display existing file names");
				fileOpMgmtinst.displayExistingFiles();
				break;
			case "2":
				boolean exitLoop = true;
				do{
				System.out.println("---------------------------------------------");	
				System.out.println("Please enter the operation to be performed");
				System.out.println(" 1. Add file");
				System.out.println(" 2. Delete file");
				System.out.println(" 3. Search file");
				System.out.println(" 4. Back to main menu");
				String operationSelected = userInput.nextLine();
				if (operationSelected.equals("1")) {
					System.out.println("Please enter the file name");
					String fileName = userInput.nextLine();
					try {
						String message = fileOpMgmtinst.addFileToDirectory(fileName,userInput);
						System.out.println(message);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else if (operationSelected.equals("2")) {
					System.out.println("Please enter the file name to be deleted");
					String fileNameToBeDeleted = userInput.nextLine();
					String message;
					try {
						message = fileOpMgmtinst.deleteFileFromDirectory(fileNameToBeDeleted);
						System.out.println(message);	
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				} else if (operationSelected.equals("3")) {
					System.out.println("Please enter the file name to be searched");
					String fileNameToBeSearched = userInput.nextLine();
					String message = fileOpMgmtinst.searchUserSpecifiedFile(fileNameToBeSearched);
					System.out.println(message);

				} else if (operationSelected.equals("4")) {
					exitLoop = false;
				}else  {
					System.out.println("Please enter proper values as per listing shown above");	
				}
				}while(exitLoop);
				break;
			case "3":
				System.out.println("Exit");
				exitApplication = true;
				break;
			default:
				System.out.println("Please enter appropriate input from the menu listed above");
			}
		} while (!exitApplication);
		userInput.close();
	}
}
