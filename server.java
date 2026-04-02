import java.io.*;
import java.net.*;
import java.util.*;
public class server {

    public static Set<PrintWriter> clients = new HashSet<>();
    public static class clientHandler implements Runnable{
        public int id = 0;
        private Socket client;
        private PrintWriter out;

        //private String name;
        public clientHandler(Socket client){
            this.client = client;
            //this.name = "client " + id;
            
        }
        public void run(){
            try{
                BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                PrintWriter out = new PrintWriter(client.getOutputStream(),true);
                synchronized(clients){
                    clients.add(out);
                }
                

                String msg;
                while((msg = in.readLine()) != null){
                    System.out.println(msg);
                    synchronized(clients){
                        for(PrintWriter writer: clients){
                            
                            writer.println(msg);
                        }
                    }
                    if(msg.equals("exit")){
                        synchronized(clients){
                            clients.remove(out);
                        }
                    }
                }
                
                    
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
    public static void main(String[] args) throws Exception{
        ServerSocket server = new ServerSocket(5000);
        while(true){
            Socket client = server.accept();
            Thread t = new Thread(new clientHandler(client));
            t.start();
        }
    }
}
