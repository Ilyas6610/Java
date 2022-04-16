import java.io.*;
import java.math.BigInteger;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Parser {

    public static Map<String, String> parseAndGetData(Scanner scanner) {
        HashMap<String, String> m = new HashMap<>();
        String line = scanner.nextLine();
        BigInteger num;
        if (line.charAt(0) != '{')
            throw new RuntimeException();
        while (scanner.hasNext()) {
            String key, val;
            scanner.useDelimiter("\"");
            scanner.next();
            key = scanner.next();
            scanner.skip("\": ");
            scanner.useDelimiter(",|\\r|\\n");
            if (scanner.hasNextBigInteger()) {
                num = scanner.nextBigInteger();
                m.put(key, "" + num);
                try {
                    scanner.skip(",");
                } catch (Exception e) {
                    break;
                }
            } else {
                scanner.useDelimiter("\"");
                val = scanner.next();
                m.put(key, val);
                try {
                    scanner.skip("\",");
                } catch (Exception e) {
                    break;
                }
            }
        }
        return m;
    }
}

