import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ParserWithIf
{
    public static Client parseIf(Scanner scanner) {
        Map<String, String> m = Parser.parseAndGetData(scanner);
        Client cli = new Client("", 0);
        if(m.containsKey("clientType")) {
            if (m.get("clientType").equals("LEGAL_ENTITY")) {
                return new LegalEntity(m.get("name"), Integer.parseInt(m.get("inn")), Integer.parseInt(m.get("capital")));
            } else if (m.get("clientType").equals("HOLDING")) {
                return new Holding(m.get("name"), Integer.parseInt(m.get("inn")), m.get("CEO"));
            } else if (m.get("clientType").equals("INDIVIDUAL")) {
                return new Individual(m.get("name"), Integer.parseInt(m.get("inn")));
            }
        }
        return cli;
    }
}
