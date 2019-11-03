import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class DuplicateCounter {
    Map<String, Integer> wordCounterlist;

    public DuplicateCounter(){
        wordCounterlist = new HashMap<String, Integer>();
    }

    public void count(String fileName) throws IOException {
        FileReader filereader = new FileReader(fileName);
        BufferedReader reader = new BufferedReader(filereader);
        String lineRead = reader.readLine();
        while(lineRead != null)
        {
            String liftOfWords[] = lineRead.split(" ");
            for(String oneWord:liftOfWords)
            {
                if (wordCounterlist.containsKey(oneWord) == false)
                {
                    wordCounterlist.put(oneWord, 1);
                }
                else
                {
                    int count = wordCounterlist.get(oneWord);
                    wordCounterlist.put(oneWord, count + 1);
                }
            }
            lineRead = reader.readLine();
        }
        reader.close();
        System.out.println("Count operation on text file " + fileName +  " has been complete ...");
    }

    public void write(String fileName) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(fileName);
        for (Map.Entry<String, Integer> oneWordEntry : wordCounterlist.entrySet()) {
            writer.println(oneWordEntry.getKey() + " : " + oneWordEntry.getValue());
        }

        writer.close();

        System.out.println("Write operation on text file " + fileName +  " has been complete ...");
    }
}
