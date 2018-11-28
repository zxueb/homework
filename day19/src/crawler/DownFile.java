package crawler;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;
import java.util.Random;

public class DownFile implements Runnable {
    String s = null;
    public DownFile(String s){
        this.s = s;
    }
    @Override
    public void run() {
        try {
            HttpsURLConnection connection = (HttpsURLConnection)
                    new URL(s).openConnection();
            InputStream in = connection.getInputStream();
            BufferedInputStream read = new BufferedInputStream(in);
            Random random = new Random();
            File file = new File("C:\\Users\\Administrator\\Desktop\\a");
            String imgName = String.valueOf(random.nextInt()) + ".jpg";
            if(!file.exists()){
                file.mkdirs();
            }
            BufferedOutputStream write = new BufferedOutputStream(
                    new FileOutputStream(
                            new File(file,imgName)));
            int len = 0;
            while((len = read.read()) != -1){
                write.write(len);
                write.flush();
            }
            System.out.println("图片" + imgName + "下载完成");
            read.close();
            write.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
