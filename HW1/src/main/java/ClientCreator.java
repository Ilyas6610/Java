import java.util.Map;

public class ClientCreator {
    static Client newCli(Map<String, String> data) {
        return ClientType.m.get(data.get("clientType").trim()).createClient(data);
    }
}
