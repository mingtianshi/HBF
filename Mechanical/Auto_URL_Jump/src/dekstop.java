import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.URI;

public class dekstop {
    static String path = "src/url/urls.txt";

    public static void readFile() {
        //路径
        Desktop desktop = Desktop.getDesktop();
        File file = new File(path);
        StringBuilder result = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
            //构造一个BufferedReader类来读取文件
            String s = null;

            //循环次数等于行数 urls
            for (int i = 0; i < 10; i++) {
                s = br.readLine();
                System.out.println(s);
                URI uri = new URI(s); //创建URI统一资源标识符
                desktop.browse(uri);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        //自动跳转 awt
        readFile();
    }
}
