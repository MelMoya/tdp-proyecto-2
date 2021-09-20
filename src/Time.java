
public class Time {

	private int minutes;
	private int seconds;
	private Logic logic;
	
	
	public Time(Logic logic) {
		
		minutes = 0;
		seconds = 0;
		this.logic = logic;
	}
	
	public void increaseTime() {
		
		seconds++;
	}
	
	public String getTime() {
		
		return minutes + ":" + seconds;
	}

}
