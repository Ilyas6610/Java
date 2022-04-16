import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CustomClassLoader extends ClassLoader {

    ArrayList<StringBuilder> className;
    Map<String, Byte[]> classNameToClass = new HashMap<>();

    public CustomClassLoader(URL[] urls) throws IOException {
        className = new ArrayList<>(2);
        for (int i = 0; i < urls.length; i++) {
            className.add(new StringBuilder());
            BufferedInputStream in = new BufferedInputStream(urls[i].openStream());
            parseData(i, in);
        }
    }

    private Byte[] toByte(byte[] byteArray, int len){
        Byte[] arr = new Byte[byteArray.length - len];
        for (int i = len; i < byteArray.length; i++) {
            arr[i-len] = (--byteArray[i]);
        }
        return arr;
    }

    private byte[] toPrimitiveByte(Byte[] byteArray){
        byte[] arr = new byte[byteArray.length];
        for (int i = 0; i < byteArray.length; i++) {
            arr[i] = byteArray[i];
        }
        return arr;
    }

    private void parseData(int i, BufferedInputStream in) throws IOException {
        byte dataBuff[] = in.readAllBytes();
        for (int j = 0; j < dataBuff.length; j++) {
            char ch = (char) (dataBuff[j] - 1);
            char next = (char) (dataBuff[j + 1]-1);
                if ((Character.isLetter(ch) || ch == '.') &&
                        (Character.isLetter(next) || next == '.')) {
                    dataBuff[j]--;
                    className.get(i).append(ch);
                }
                else{
                    classNameToClass.put(className.get(i).toString(), toByte(dataBuff, j));
                    break;
                }
        }
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        URL[] urls = new URL[0];
        try {
            urls = new URL[]{new URL("file://C:/Users/User/IdeaProjects/CustomClassLoader/src/main/java/")};
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        URLClassLoader classLoader = new URLClassLoader(urls);
        System.out.println(name);
        return defineClass(name, toPrimitiveByte(classNameToClass.get(name)), 0, classNameToClass.get(name).length);
    }
}
