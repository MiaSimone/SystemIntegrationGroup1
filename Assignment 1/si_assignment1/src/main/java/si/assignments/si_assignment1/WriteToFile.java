package si.assignments.si_assignment1;
import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;
import java.io.File;  // Import the File class
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors
import org.apache.commons.io.FileUtils;

public class WriteToFile {

//        public static void CreateFolder(String path) {
//        try {
//            File myObj = new File(path);
//            if (myObj.createNewFile()) {
//                System.out.println("Folder created: " + myObj.getName());
//            } else {
//                System.out.println("Folder already exists.");
//            }
//        } catch (IOException e) {
//            System.out.println("An error occurred.");
//            e.printStackTrace();
//            }
//        }

        public static void CreateFile(String name, String path) {
            try {
                File myObj = new File(path + "\\InviteFor" + name + ".txt");
                if (myObj.createNewFile()) {
                    System.out.println("File created: " + myObj.getName());
                } else {
                    System.out.println("File already exists.");
                }
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }

        public static void WriteToFile(String name, String gender, String path) {
            Lorem lorem = LoremIpsum.getInstance();
            String dummyText = lorem.getParagraphs(2, 4);
            try {
                FileWriter myWriter = new FileWriter(path + "\\InviteFor" + name + ".txt");
                myWriter.write("Dear " + gender + " " + name + "!\n" + dummyText);
                myWriter.close();
                System.out.println("Successfully wrote to the file.");
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }

        public static void CleanFolder(String pathName) throws IOException {
            File directory = new File(pathName);
            FileUtils.cleanDirectory(directory);
        }


    }
