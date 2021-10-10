import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Scanner;

public class ClientGetter {
    //type: false - if, true - enum. Можно было бы наверно enum еще один завести,
    // но не уверен, насколько имеет смысл, учитывая, что варианта лишь 2
    public static Client getClient(String fileName, boolean type) throws Exception {
        Path path = FileSystems.getDefault().getPath("C:\\Users\\User\\IdeaProjects\\Java_HW1\\src\\main\\java", fileName);
        Scanner scanner = new Scanner(path);
        return type ? ParserWithEnum.parseEnum(scanner) : ParserWithIf.parseIf(scanner);
    }
}
