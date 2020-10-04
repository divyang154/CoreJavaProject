package mainApplication;

import java.io.IOException;
import java.util.Scanner;

import FileOperations.FileOperationsManagementImpl;
import FileOperations.FileOperationsManagementInterface;

public class MainApplication {

	public static void main(String[] args) {

		FileOperationsManagementInterface fileOpMgmtinst = new FileOperationsManagementImpl();
		boolean exitApplication = false;
		do {
			System.out.println("1. Display existing file names ");
			System.out.println("2. Add/Delete/Search a file");
			System.out.println("3. Exit");
			System.out.println("Please enter an option:-");
			Scanner userInput = new Scanner(System.in);
			Integer menuSelected = Integer.parseInt(userInput.nextLine());
			System.out.println("Menu Selected:-" + menuSelected);

			switch (menuSelected) {

			case 1:
				System.out.println("Display existing file names");
				fileOpMgmtinst.displayExistingFiles();
				break;
			case 2:
				System.out.println("Please enter the operation to be performed");
				System.out.println(" 1. Add file");
				System.out.println(" 2. Delete file");
				System.out.println(" 3. Search file");
				System.out.println(" 4. Back to main menu");
				Integer operationSelected = Integer.parseInt(userInput.nextLine());
				if (operationSelected.equals(new Integer(1))) {
					System.out.println("Please enter the file name");
					String fileName = userInput.nextLine();
					System.out.println("Please enter the content to be written to file");
					String content = userInput.nextLine();
					try {
						String message = fileOpMgmtinst.addFileToDirectory(fileName,content);
						System.out.println(message);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				} else if (operationSelected.equals(new Integer(2))) {
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
					
					break;
				} else if (operationSelected.equals(new Integer(3))) {
					System.out.println("Please enter the file name to be searched");
					String fileNameToBeSearched = userInput.nextLine();
					String message = fileOpMgmtinst.searchUserSpecifiedFile(fileNameToBeSearched);
					System.out.println(message);
					break;
				} else if (operationSelected.equals(new Integer(4))) {
					break;
				}
				break;
			case 3:
				System.out.println("Exit");
				exitApplication = true;
				break;
			}
		} while (!exitApplication);

	}
}
