import java.util.Map;

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

    public static final Map<String, ClientType> m = Map.ofEntries(
            Map.entry("HOLDING", HOLDING),
            Map.entry("LEGAL_ENTITY", LEGAL_ENTITY),
            Map.entry("INDIVIDUAL", INDIVIDUAL));


    abstract Client createClient(Map<String, String> data);
}
