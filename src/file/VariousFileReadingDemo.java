package file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class VariousFileReadingDemo {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("src/examples/file/basic_lines.txt");
        File file = path.toFile();

        usingBufferedReader(file);
        usingFilesAPI(path);
    }

    static void usingBufferedReader(File file) throws IOException {
        // 1: Reading each line with readline()
        BufferedReader reader1 = new BufferedReader(new FileReader(file));
        while(true) {
            String line = reader1.readLine(); // read

            if(line == null) // if null (end of file), end loop
                break;

            System.out.println(line); // print line (if loop didn't end)
        }
        reader1.close(); // Don't forget to close



        // 2: Same as above, but more compact
        BufferedReader reader2 = new BufferedReader(new FileReader(file));
        String line;
        while((line = reader2.readLine()) != null) {
            System.out.println(line);
        }
        reader2.close();



        // 3: Using lines() (Java 8 Stream API) to loop over each
        BufferedReader reader3 = new BufferedReader(new FileReader(file));
        reader3.lines().forEach(l -> System.out.println(l));
        reader3.close();



        // 4: Same as above, but more compact (uses method reference)
        BufferedReader reader4 = new BufferedReader(new FileReader(file));
        reader4.lines().forEach(System.out::println);
        reader4.close();



        // 5: Using lines(), collecting as a List, then looping over the list
        BufferedReader reader5 = new BufferedReader(new FileReader(file));
        List<String> lines = reader5.lines().collect(Collectors.toList());

        for(String l : lines) { // Can use different looping methods if wanted
            System.out.println(l);
        }
        reader5.close();
    }

    static void usingFilesAPI(Path path) throws IOException {
        // 1: Using readAllLines to read all lines of text
        List<String> lines = Files.readAllLines(path);


        // 2: Using newBufferedReader to create a BufferedReader
        BufferedReader reader = Files.newBufferedReader(path);
        // refer to "usingBufferedReader" examples
        reader.close();


        // 3: Using lines to stream lines of text
        Stream<String> stream = Files.lines(path);
        // can use Stream functions - forEach, collect, etc..


        // 4:
    }
}
