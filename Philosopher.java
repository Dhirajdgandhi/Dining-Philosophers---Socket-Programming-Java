import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

// State : 2 = Eat, 1 = think
class Philosopher extends Thread
{
	private Chopstick _leftChopistick;
	private Chopstick _rightChopistick;

	private String _name;
	private int _state;

	PrintStream out=null;
    BufferedReader in=null;
    
	public Philosopher ( String name, Chopstick _left, Chopstick _right,Socket s) throws IOException{
		this._state = 1;
		this._name = name;
		_leftChopistick = _left;
		_rightChopistick = _right;
		this.out=new PrintStream(s.getOutputStream());
		this.in=new BufferedReader(new InputStreamReader(s.getInputStream()));
	}
 
	public void eat()
	{
		while(true){
			
			System.out.print(""); //MOST IMP THING DONT REMOVE THIS
			if(! _leftChopistick.used){
				if(!_rightChopistick.used){
					_leftChopistick.take();
					_rightChopistick.take();
	
					Log.msg(_name + " : Eating");
					
					Log.Delay(10000);
	
					_leftChopistick.release();
			 		_rightChopistick.release();
			 		
			 		break;
				}
			}	
		}
		//think();
	}

	/*public void think(){
		 	this._state = 1;
		 	Log.msg(_name + " : Think");
		 	Log.Delay(1000);
	}*/

	public void run(){
		
		Log.msg("Chopstick " + _leftChopistick._name + " and " +_rightChopistick._name);
		while(true){
			try {
				in.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			eat();
			Log.Delay(1000);
			out.println("PATHAR");// because EAT ka jawab PATTHAR se :P
			
		}
			
		
	}
}