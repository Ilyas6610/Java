import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestParser {

    @Test
    public void testParserEnumIndividual() {
        String s = "{\n" +
                "  \"name\": \"ИП Иванов\",\n" +
                "  \"inn\": 13242352,\n" +
                "  \"clientType\": \"INDIVIDUAL\"\n" +
                "}";
        Scanner scanner = new Scanner(s);
        Client cli = new Individual("ИП Иванов", 13242352);
        assertEquals(cli, ParserWithEnum.parseEnum(scanner));
    }

    @Test
    public void testParserEnumLegalEntity() {
        String s = "{\n" +
                "  \"name\": \"Чебуреки #1\",\n" +
                "  \"inn\": 49348294,\n" +
                "  \"clientType\": \"LEGAL_ENTITY\",\n" +
                "  \"capital\": 100000\n" +
                "}";
        Scanner scanner = new Scanner(s);
        Client cli = new LegalEntity("Чебуреки #1", 49348294, 100000);
        assertEquals(cli, ParserWithEnum.parseEnum(scanner));
    }

    @Test
    public void testParserEnumHolding() {
        String s = "{\n" +
                "  \"name\": \"ООО Матрешка\",\n" +
                "  \"inn\": 89088997,\n" +
                "  \"clientType\": \"HOLDING\",\n" +
                "  \"CEO\": \"Bill Gates\"\n" +
                "}";
        Scanner scanner = new Scanner(s);
        Client cli = new Holding("ООО Матрешка", 89088997, "Bill Gates");
        assertEquals(cli, ParserWithEnum.parseEnum(scanner));
    }

    @Test
    public void testParserIfIndividual() {
        String s = "{\n" +
                "  \"name\": \"ИП Иванов\",\n" +
                "  \"inn\": 13242352,\n" +
                "  \"clientType\": \"INDIVIDUAL\"\n" +
                "}";
        Scanner scanner = new Scanner(s);
        Client cli = new Individual("ИП Иванов", 13242352);
        assertEquals(cli, ParserWithIf.parseIf(scanner));
    }

    @Test
    public void testParserIfLegalEntity() {
        String s = "{\n" +
                "  \"name\": \"Чебуреки #1\",\n" +
                "  \"inn\": 49348294,\n" +
                "  \"clientType\": \"LEGAL_ENTITY\",\n" +
                "  \"capital\": 100000\n" +
                "}";
        Scanner scanner = new Scanner(s);
        Client cli = new LegalEntity("Чебуреки #1", 49348294, 100000);
        assertEquals(cli, ParserWithIf.parseIf(scanner));
    }

    @Test
    public void testParserIfHolding() {
        String s = "{\n" +
                "  \"name\": \"ООО Матрешка\",\n" +
                "  \"inn\": 89088997,\n" +
                "  \"clientType\": \"HOLDING\",\n" +
                "  \"CEO\": \"Bill Gates\"\n" +
                "}";
        Scanner scanner = new Scanner(s);
        Client cli = new Holding("ООО Матрешка", 89088997, "Bill Gates");
        assertEquals(cli, ParserWithIf.parseIf(scanner));
    }
}

