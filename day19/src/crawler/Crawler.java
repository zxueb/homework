package crawler;
/**网络爬虫
 * 导出JPG格式图片
 *
 */

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Crawler {
    public static void main(String[] args) throws IOException {
        //地址
        String s = "https://tieba.baidu.com/p/2256306796?red_tag=1781367364";
        //匹配类型
        String regex = "<img class=\\\"BDE_Image\\\" src=\\\"(.*?)\\\"";
        //获取网页源码
        StringBuffer str = getStringBuffer(s);
        //获取图片链接集合
        List<String> list = getImgList(str,regex);
        //下载图片
       download(list);
    }

    /**
     * 获取网页源码
     * @param s
     * @return
     * @throws IOException
     */
    private static StringBuffer getStringBuffer(String s) throws IOException {
        HttpsURLConnection connection = (HttpsURLConnection) new URL(s).openConnection();
        InputStream in = connection.getInputStream();
        BufferedReader read = new BufferedReader(new InputStreamReader(in));
        StringBuffer str = new StringBuffer();
        while(read.readLine() != null){
            str.append(read.readLine());
        }
        return str;
    }

    /**
     * 下载文件
     * @param list
     */
    private static void download(List<String> list) throws IOException {
        ExecutorService service = Executors.newFixedThreadPool(5);
        for(String s : list){
            DownFile downFile = new DownFile(s);
            Thread th = new Thread(downFile);
            service.submit(th);

        }
        service.shutdown();
    }

    /**
     * 获取文件链接的集合
     * @param str
     * @return
     */
    private static List<String> getImgList(StringBuffer str,String regex) {
        List<String> list = new ArrayList<>();
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(str);
        int index = 0;
        while(m.find(index)){
            String s = m.group();
            StringBuffer sb1 = new StringBuffer(s);
            s = sb1.substring(s.indexOf("https"),s.indexOf(".jpg"));
            StringBuffer sb2 = new StringBuffer(s);
            sb2.append(".jpg");
            list.add(sb2.toString());
            index = m.end();
        }
        return list;
    }


}






