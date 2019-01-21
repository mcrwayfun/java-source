import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description
 * @date Created in 2019/1/21
 */
public class PropertyUtil {

    public static Properties loadProperties(String filePath) throws IOException {

        // 获取配置文件并加载
        Properties property = new Properties();
        InputStream resourceAsStream = Thread.currentThread().getContextClassLoader().
                getResourceAsStream(filePath);
        property.load(resourceAsStream);

        return property;
    }

    public static void main(String[] args) {
        try {
            Properties properties = PropertyUtil.loadProperties("app.properties");
            String name = properties.getProperty("app.name");
            String location = properties.getProperty("app.location");
            System.out.println("name=" + name + ", location=" + location);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
