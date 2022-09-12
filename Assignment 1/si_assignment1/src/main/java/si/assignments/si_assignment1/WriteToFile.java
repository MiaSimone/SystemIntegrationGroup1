package si.assignments.si_assignment1;
import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;
import java.io.File;  // Import the File class
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors
import java.util.Objects;

import org.apache.commons.io.FileUtils;

public class WriteToFile {

        public static void CreateFile(String name, String path) {
            String filePath = path + "\\InviteFor" + name + ".txt";
            System.out.println(filePath);
            try {
                File myObj = new File(filePath);
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
//            Lorem lorem = LoremIpsum.getInstance();
//            String dummyText = lorem.getParagraphs(2, 4);
            String meetingInfo =
                    "\nI would like to invite you to attend our upcoming Liberal Arts department job networking event. The event will be held \n" +
                            "on the afternoon of May 1, 2023. We wish to provide our graduating seniors with an opportunity to meet business leaders \n" +
                            "in the area who may be looking for new hires who hold degrees in the Liberal Arts.\n\n" +
                            "The event will be held at the Cox Student Center at Northern State University and will last about two to three hours. \n" +
                            "If you have an interest in attending or sending a company representative to meet with our students, please let me know \n" +
                            "at your earliest convenience and I can reserve a table for you.\n\n" +
                            "Thank for your time and I hope to hear from you soon.\n\nRespectfully,\nLucy the Cat";

            try {
                FileWriter myWriter = new FileWriter(path + "\\InviteFor" + name + ".txt");
                myWriter.write("Dear " + gender + " " + name + "!\n" + meetingInfo);
                myWriter.close();
                System.out.println("Successfully wrote to the file.");
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }

        public static void CleanFolder(String pathName) throws IOException {
            File file = new File(pathName);
            FileUtils.deleteDirectory(file);
        }


        public static void CreateFolder(String path) {
            File myObj = new File(path);
            if (myObj.mkdirs()) {
                System.out.println("Folder created: " + myObj.getName());
            } else {
                System.out.println("Folder already exists.");
            }

        }



    }
