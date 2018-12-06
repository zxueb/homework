package chat;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server extends AbstractServerClient {
    public static void main(String[] args){
        Server server = new Server();
        System.out.println("服务器已启动，等待连接。。。");
        try {
            ServerSocket serverSocket = new ServerSocket(1234);
            ExecutorService service = Executors.newFixedThreadPool(5);
            while(true){
                Socket socket = serverSocket.accept();
                service.submit(() -> {
                    try(
                            InputStream in = socket.getInputStream();
                            OutputStream out = socket.getOutputStream()
                    ){
                        //接收客户端
                        server.receive(socket,in,out);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private Map<Socket,String> map = new ConcurrentHashMap<>();
    @Override
    public void handle (int cmd, String content, Socket socket, InputStream in, OutputStream out) throws IOException {
        switch (cmd){
            case 1:
                map.put(socket,content);
                send(5,"欢迎" + content,out);
                break;
            case 2:
                send(6,map.values().toString(),out);
                break;
            case 3:
                String n = map.get(socket);
                String say = n + ":" + content;
                for(Socket soc : map.keySet()){
                    if(soc.equals(socket)){
                        continue;
                    }else{
                        send(7,say,soc.getOutputStream());
                    }
                }
                break;
            case 4:
                String[] str = content.split(" ");
                String name = str[0];//私聊对象的名字
                String cont = str[1];//内容
                boolean b = false;
                for(Socket soc : map.keySet()){
                    if(map.get(soc).equals(name)){
                        b = true;
                        send(8,map.get(socket) + ":" + cont,soc.getOutputStream());
                    }
                }
                if(!b){
                    System.out.println("聊天室无此对象");
                }
                break;
            default:
        }
    }
}
