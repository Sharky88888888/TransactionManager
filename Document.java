import java.nio.file.*;
import java.io.IOException;

public class Document {
    private String filename;
    private String content;

    public Document(String filename) throws IOException {
        this.filename = filename;
        content = new String(Files.readAllBytes(Paths.get(filename))).toLowerCase();
    }

    public String getFilename() {
      return filename; 
    }
  
    public String getContent() { 
      return content; 
    }
}
