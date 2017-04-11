
import java.io.*;
import java.net.*;
import java.util.HashMap;
//import java.util.PriorityQueue;

public class Dine{
	public static void main(String[] args) throws IOException{

		int x=10;

		Log.msg(String.valueOf(x));
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		
		Chopstick[] chopistics = new Chopstick[5];

		//initlize the chopistics
		for(int i=0; i< chopistics.length; i++){
			chopistics[i] = new Chopstick("C: "+i);
		}
		
		ServerSocket ss=new ServerSocket(5000);
		
		//Storing all the threads 
		Philosopher[] philosophers = new Philosopher[5];
		
		for(int i=0;i<philosophers.length;i++){
			Socket s=ss.accept();
			//Streams
			philosophers[i] = new Philosopher("P: " +i+ " - ", chopistics[i], chopistics[(i+1)%5],s);
			Log.msg("Thread "+ i);
			
			Thread t= new Thread( philosophers[i]);
			t.start();
		}
 	}
}
