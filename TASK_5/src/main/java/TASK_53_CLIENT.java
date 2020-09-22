import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class TASK_53_CLIENT {
    public static void main(String[] args) throws Exception {

        Socket server = new Socket("localhost", 5000);


        try (
                BufferedReader br = new BufferedReader(new InputStreamReader((server.getInputStream())));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(server.getOutputStream()));
                BufferedReader console = new BufferedReader(new InputStreamReader((System.in)));
        ) {
            while (true) {
                String userInput = console.readLine();
                bw.write(userInput);
                bw.newLine();
                bw.flush();

                String str = br.readLine();
                System.out.println("received from server: " + str);
                if(str.startsWith("close") && str.endsWith("close")){
                    System.out.println("Connection is closed");
                    System.exit(0);
                }

            }
        }
    }
}
