package digio.main;

import digio.parse.Parser;

import java.io.File;
import java.io.FileNotFoundException;

public class LogParser {
    public static void main(String[] args) {
        try {
            new Parser().parse(new File("example.log"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
