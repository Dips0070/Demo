
import java.io.*;
import java.nio.charset.*;
import java.util.Scanner;


public class ValidateSchema {
 
	private static String readFile(String pathname) throws IOException {

	    File file = new File(pathname);
	    StringBuilder fileContents = new StringBuilder((int)file.length());        

	    try (Scanner scanner = new Scanner(file)) {
	        while(scanner.hasNextLine()) {
	            fileContents.append(scanner.nextLine() + System.lineSeparator());
	        }
	        return fileContents.toString();
	    }
	}
	public static void displayDirectoryContents(File dir) {
		File[] files = dir.listFiles();
		for (File file : files) {
			if (file.isDirectory()) {
				/*System.out.println("directory:" + file.getCanonicalPath());*/
				displayDirectoryContents(file);
			} else {
				/*System.out.println("     file:" + file.getCanonicalPath());*/
				try {
					if(readFile(file.getCanonicalPath()).toString().contains("EFTDEVS1") 
							|| readFile(file.getCanonicalPath()).toString().contains("EFTDEVLC") 
							|| readFile(file.getCanonicalPath()).toString().contains("EFTDEVLZ")){
						System.out.println("THE DATABASE NAME EXISTS IN FILE"+ "File Name  :"+ file.getCanonicalPath());
					}else{
					
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public static void main (String args[]){
		File currentDir = new File("."); // current directory
		displayDirectoryContents(currentDir);
		/*String amount ="LookupDAO";
		try {
			
			if(readFile(amount).toString().contains("EFTDEVS1") 
					|| readFile(amount).toString().contains("EFTDEVLC") 
					|| readFile(amount).toString().contains("EFTDEVLZ")){
				System.out.println("THE DATABASE NAME EXISTS IN FILE");
			}else{
				System.out.println("THE DATABASE NAME DOES NOT EXISTS IN FILE");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
}