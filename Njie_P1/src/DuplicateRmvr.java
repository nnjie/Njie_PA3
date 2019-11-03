import java.io.*;
import java.util.ArrayList;

public class DuplicateRemover {
    ArrayList<String> listOfUniqueWords;

    public DuplicateRemover() {
        listOfUniqueWords = new ArrayList<String>();
    }

    public void remove(String fileName) throws IOException {
        FileReader filereader =  new FileReader(fileName);
        BufferedReader reader = new BufferedReader(filereader);
        String lineRead = reader.readLine();
        while(lineRead != null)
        {
            String listOffWords [] = lineRead.split(" ");
            for(String oneWord : listOffWords)
            {
                if(!listOfUniqueWords.contains(oneWord))   listOfUniqueWords.add(oneWord);
            }
            lineRead = reader.readLine();
        }

        reader.close();
        System.out.println("Remove operation on file " + fileName +  " has been complete ...");
    }

    public void write(String fileName) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(fileName);
        for(String oneWord : listOfUniqueWords)
        {
            writer.println(oneWord);
        }
        writer.close();
        System.out.println("Write operation on file " + fileName +  " has been complete ...");
    }
}
