
class Chopstick{

	public boolean used;
	public String _name;

	public Chopstick(String _name){
		this._name = _name;
	}

	public synchronized void take() {
		Log.msg ("Used :: " + _name );
		this.used = true;
	}
	public synchronized void release() {
		Log.msg ("Released :: " + _name );
		this.used = false ;
	}
}