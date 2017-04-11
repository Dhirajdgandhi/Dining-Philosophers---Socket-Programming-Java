
import java.io.*;
import java.net.*;
import java.util.HashMap;
//import java.util.PriorityQueue;

public class client_philosopher {
	
	//public static int id=0;
	//public static ID prod_id=new ID();
			
	public static void main(String args[])throws IOException, InterruptedException
    {
		Socket s=new Socket("localhost",5000);
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
	     
        //Streams
        PrintStream out = new PrintStream(s.getOutputStream());
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
	     
        //System.out.println("Producer : " + prod_id.id);
        
        while(true){
        	System.out.println("Khana pasand karoge ?");
        	String str=sc.readLine();
        	
        	if(str.equalsIgnoreCase("Haanji")){
        		out.println("EAT");
        		
        		Log.msg("EAT ka jawab "+in.readLine()+" se");
        	}
        }
    }
}
