import java.io.*;
import java.net.*;
import java.util.Scanner;
public class client {
    public static class SendingMsg implements Runnable{
        private PrintWriter out;
        public SendingMsg(PrintWriter out){
            this.out = out;
        }
        public void run(){
            
            Scanner sc = new Scanner(System.in);
            String sentmsg;
            while((sentmsg = sc.nextLine()) != null){
                out.println(sentmsg);
            }
        }
    }
    public static class RecieveMsg implements Runnable{
        private BufferedReader in;
        public RecieveMsg(BufferedReader in){
            this.in = in;
        }
        public void run(){
            try{
                String recmsg;
                while((recmsg = in.readLine()) != null){
                    System.out.println(recmsg);
                }
            }catch(Exception e){
                System.out.println(e.getMessage());
            }

            
        }
    }
    public static void main(String[] args) throws Exception{

            Socket client = new Socket("127.0.0.1",5000);
            
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter out = new PrintWriter(client.getOutputStream(),true);

            Thread t1 = new Thread(new SendingMsg(out));
            Thread t2 = new Thread(new RecieveMsg(in));

            t1.start();
            t2.start();
            t1.join();
            client.close();
        
    }
}
