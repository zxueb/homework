package chat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client extends AbstractServerClient{
    public static void main(String[] args) throws IOException {
        Client client = new Client();
        Socket socket = new Socket("localhost",1234);
        System.out.println("*******聊天室*******");
        System.out.println("*****1.创建昵称*****");
        System.out.println("*****2.查看用户*****");
        System.out.println("*****3.群聊*********");
        System.out.println("*****4.私聊*********");
        //向服务器端发送请求，首先创建昵称
        Scanner sc  = new Scanner(System.in);
        while(true) {
            int a = sc.nextInt();
            if(a ==1) {
                System.out.print("请输入昵称：");
                String name = sc.next();
                //向服务器发送请求
                client.send(1, name, socket.getOutputStream());
                break;
            }else{
                System.out.println("请先创建昵称");
            }
        }
        //发送其他请求
        new Thread(() ->{
            try(
                    OutputStream out = socket.getOutputStream())
            {
                    Scanner scanner = new Scanner(System.in);
                    while(scanner.hasNextLine()){
                        String line = scanner.nextLine();
                        char cmd = line.charAt(0);
                        //向服务器发送不同指令
                        switch(cmd){
                            case '2' :
                                client.send(2,"",out);
                                break;
                            case '3' :
                                String cont1 = line.substring(2);
                                client.send(3,cont1,out);
                                break;
                            case '4':
                                String cont2  = line.substring(2);
                                client.send(4,cont2,out);
                                break;
                            default:
                                System.out.println("请输入正确的指令：");
                        }
                    }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

        //接收服务器端的响应
        new Thread(() -> {
            try(
                    InputStream in = socket.getInputStream();
                    OutputStream out = socket.getOutputStream();
            ){
                client.receive(socket,in,out);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    @Override
    public void handle(int cmd, String content, Socket socket, InputStream in, OutputStream out) {
        switch(cmd){
            case 5:
                System.out.println(content);
                break;
            case 6:
                System.out.println(content);
                break;
            case 7:
                System.out.println(content);
                break;
            case 8:
                System.out.println(content);
                break;
            default:
        }
    }
}
