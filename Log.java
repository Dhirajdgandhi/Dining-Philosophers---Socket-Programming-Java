class Log{

	public static void msg(String msg){
		System.out.println(msg);
	}
	public static void Delay(int ms){
		try{
			Thread.sleep(ms);
		}
		catch(InterruptedException ex){ }
	}
}
