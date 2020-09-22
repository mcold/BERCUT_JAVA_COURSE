import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Программа аналог сервиса Алиса
 * –Сервер работает так:
 * строка на входе разбивается на слова.
 * Произвольное слово из набора отправляется клиенту со знаком вопроса.
 * – Взаимодействие заканчивается, если клиент отправляет строку close
 */

public class TASK_53_SERVER {

    public static void main(String[] args) throws IOException {
        AlisaServer();
    }

    public static void AlisaServer() throws IOException {
        ServerSocket ss = new ServerSocket(5000);
        Socket client = ss.accept();
        client.getInputStream();

        try(BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        ){
            while(true) {
                String clientLine = br.readLine();
                System.out.println("Received from client: " + clientLine);
                List<String> arrLine = Arrays.asList(clientLine.split("\\s+|\\p{Punct}+"));
                ArrayList<String> arrRes = new ArrayList<String>();
                for(String e: arrLine){
                    e = e.replace(" ", "");
                    if(e.startsWith("close") && e.endsWith("close")){
                        bw.write("close");
                        bw.newLine();
                        bw.flush();
                        System.out.println("Connection is closed");
                        TimeUnit.SECONDS.sleep(1);
                        System.exit(0);
                    }else{
                        if(e.length() != 0){
                            arrRes.add(e);
                        }
                    }
                }

                Integer num = (int)(Math.random()*arrRes.size());
                String word = arrRes.get(num);
                bw.write(word);
                bw.newLine();
                bw.flush();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
