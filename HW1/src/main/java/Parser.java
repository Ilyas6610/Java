import java.io.*;
import java.math.BigInteger;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Parser {

    public static void main(String[] args) throws Exception {
        try {
            Client cli = parse("file");
            System.out.println(cli.getName() + ' ' + cli.getInn() + ' ' + cli.getClass());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static Client parse(String fileName) throws Exception{
        Path path = FileSystems.getDefault().getPath("C:\\Users\\User\\IdeaProjects\\Java_HW1\\src\\main\\java", fileName);
        Scanner scanner = new Scanner(path);
        return parseEnum(scanner); //parseIf(scanner);
    }

    public static Client parseIf(Scanner scanner){
        HashMap<String, String> m = getData(scanner);
        Client cli = new Client("", 0);;
        if (m.get("clientType").equals("LEGAL_ENTITY")) {
            return new LegalEntity(m.get("name"), Integer.parseInt(m.get("inn")), Integer.parseInt(m.get("capital")));
        } else if (m.get("clientType").equals("HOLDING")) {
            return new Holding(m.get("name"), Integer.parseInt(m.get("inn")), m.get("CEO"));
        } else if (m.get("clientType").equals("INDIVIDUAL"))
            return new Individual(m.get("name"), Integer.parseInt(m.get("inn")));
        return cli;
    }

    public static Client parseEnum(Scanner scanner){
        HashMap<String, String> m = getData(scanner);
        return ClientType.newCli(m);
    }

    private static HashMap<String, String> getData(Scanner scanner) {
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


    enum ClientType {
        HOLDING {
            @Override
            Client createClient(Map<String, String> data) {
                return new Holding(data.get("name"), Integer.parseInt(data.get("inn")),
                        data.get("CEO"));
            }
        },
        INDIVIDUAL {
            @Override
            Client createClient(Map<String, String> data) {
                return new Individual(data.get("name"), Integer.parseInt(data.get("inn")));
            }
        },
        LEGAL_ENTITY {
            @Override
            Client createClient(Map<String, String> data) {
                return new LegalEntity(data.get("name"), Integer.parseInt(data.get("inn")),
                        Integer.parseInt(data.get("capital")));
            }
        };

        private static final Map<String, ClientType> m = new HashMap<>();

        static {
            m.put("HOLDING", HOLDING);
            m.put("LEGAL_ENTITY", LEGAL_ENTITY);
            m.put("INDIVIDUAL", INDIVIDUAL);
        }

        static Client newCli(Map<String,String> data){
            return m.get(data.get("clientType").trim()).createClient(data);
        }

        abstract Client createClient(Map<String, String> data);
    }
}
