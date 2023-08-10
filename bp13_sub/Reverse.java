package bp13_sub;

import java.nio.file.*;
import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Reverse {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("/Users/simonhinterreiter/Library/CloudStorage/Dropbox/06 - Coding/01 - Local GitHub Repositories/Win/STUDY.BSc-S01-SoSe2023-C01-InformatikII/02 - Betreutes Programmieren/13 - WIP/textfile.txt"); 

        List<String> lines = new ArrayList<>();
        StringBuilder builder = new StringBuilder();

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                builder.setLength(0); // Reset the StringBuilder for reuse
                builder.append(line);
                builder.reverse();
                lines.add(builder.toString());
            }
        } 

        Collections.reverse(lines); 

        try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(path, StandardOpenOption.APPEND))) {
            writer.println(); 
            for (String reversedLine : lines) {
                writer.println(reversedLine);
            }
        } 
    }
}
