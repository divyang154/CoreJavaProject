package FileOperations;

import java.util.List;
import java.io.File;
import java.io.IOException;


public interface FileOperationsManagementInterface {

	public void displayExistingFiles();
	
	public String addFileToDirectory(String fileName,String content) throws IOException;
	
	public String deleteFileFromDirectory(String fileNameToBeDeleted) throws IOException;
	
	public String searchUserSpecifiedFile(String fileNameToBeSearched);	
	
}
