import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ParserWithEnum {
    public static Client parseEnum(Scanner scanner) {
        Map<String, String> m = Parser.parseAndGetData(scanner);
        return ClientCreator.newCli(m);
    }
}
