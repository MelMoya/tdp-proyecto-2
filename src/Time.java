public class Time extends Thread {

	private int milliseconds = 0; // Borrar
	private int seconds = 0;
	private int secondsSpeed = 0;
	private int minutes = 0;
	private long startTime = 0;
	private long stopTime = 0;
	private boolean running = false;
	private Logic logic;
	private int step;
	
	public Time(Logic logic, int step) {
	
		this.milliseconds = 0;
		this.seconds = 0;
		this.minutes = 0;
		this.stopTime = 0;
		this.logic = logic;
		this.running = true;
		this.step = step;
		this.secondsSpeed = seconds + 10;
		this.startTime = System.currentTimeMillis();
	}
	
//	public void restartTime(int step) { 
//		milliseconds = 0;
//		seconds = 0;
//		minutes = 0;
//		startTime = 0;
//		stopTime = 0;
//		secondsSpeed = seconds + 10;
//		this.running = true;
//		this.step = step;
//		this.startTime = System.currentTimeMillis();
//	}
	
	public void stopTime() {
		
		this.stopTime = System.currentTimeMillis();
		this.running = false;
	}
	
	@Override
	public void run() {
		

		while (this.running) {
			try {
				logic.setTime(this.getElapsedTimeString());
				Thread.sleep(step);
				logic.moveToDown();			
			} catch(InterruptedException e) {}
		}
		
	}

	public void setStep(int step) {
		
		this.step = step;
	}

	public long getElapsedTime() {
		long elapsed;
		
		if (running) {
	         elapsed = (System.currentTimeMillis() - startTime);
		}
	    else 
	        elapsed = (stopTime - startTime);
	    
	    return elapsed;
	}
	
	private String getElapsedTimeString() {
		
		
		milliseconds = (int) (getElapsedTime());
		seconds = (int) (milliseconds / 1000) % 60 ;
		minutes = (int) ((milliseconds / (1000*60)) % 60);
		increment();
		
		String toReturn = minutes + ":" + seconds;
		if (seconds<10) {
			toReturn = minutes + ":" + "0" + seconds;

		}
	
		return toReturn;
 		
	}
	
	private void increment() {
		if (seconds == secondsSpeed) {
			secondsSpeed = seconds + 10;
			logic.increaseSpeed();
		}
		if (seconds == 50) 
			secondsSpeed = 0;
	}	

}
