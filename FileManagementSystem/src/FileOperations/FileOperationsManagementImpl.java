package FileOperations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileOperationsManagementImpl implements FileOperationsManagementInterface {

	@Override
	public void displayExistingFiles() {
		// TODO Auto-generated method stub
		File folder = new File(System.getProperty("user.dir") + "/src/root/");
		String[] fileArr=folder.list();
		List<String>listOfFilesNames= Arrays.asList(fileArr);
		Collections.sort(listOfFilesNames);
		for (String FileName : listOfFilesNames) {
            System.out.println(FileName);
        }
	}

	@Override
	public String addFileToDirectory(String fileName, String content) throws IOException {
		// TODO Auto-generated method stub
		File file = new File(System.getProperty("user.dir") + "/src/root/" + fileName);
		if (file.exists()) {
			return "File already exists.";
		} else {
			file.createNewFile();
			Path path = Paths.get((System.getProperty("user.dir") + "/src/root/" + fileName));
			Files.write(Paths.get(path.toUri()), content.getBytes(), StandardOpenOption.APPEND);

		}
		return "File has been created successfully";
	}

	@Override
	public String deleteFileFromDirectory(String fileNameToBeDeleted) throws IOException {
		// TODO Auto-generated method stub

		String response = "";
		File fileObj = new File(System.getProperty("user.dir") + "/src/root/" + fileNameToBeDeleted);
		if (fileObj.exists() && fileObj.getCanonicalFile().getName().equals(fileObj.getName())) {
			boolean fileDeleteFlag = fileObj.delete();
			System.out.println("Flag:-" + fileDeleteFlag);
			if (fileDeleteFlag) {
				response = "File has been deleted";
			} else {
				response = "Entered file has not been found therefore file deletion is unsuccessful";
			}

		} else {
			response = "Entered file has not been found therefore file deletion is unsuccessful";
		}
		return response;

	}

	@Override
	public String searchUserSpecifiedFile(String fileNameToBeSearched) {
		// TODO Auto-generated method stub
		String message="";
		
		File folder = new File(System.getProperty("user.dir") + "/src/root/");
		String[] fileArr=folder.list();
		Set<String>setOfFileNames = new HashSet<>(Arrays.asList(fileArr));
		Boolean fileFound=setOfFileNames.contains(fileNameToBeSearched);
		File fileObj = new File(System.getProperty("user.dir") + "/src/root/" + fileNameToBeSearched);
		if (fileFound)
		{
		    message="Specified file has been found.";
		     
		}else {
		    message="Specified file has not been found.";
		}
		return message;
	}

}
