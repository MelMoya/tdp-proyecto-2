public class Time extends Thread {

	private long elapsed = 0;
	private int seconds = 0;
	private int minutes = 0;
	private long startTime = 0;
	private long stopTime = 0;
	private boolean running = false;
	private Logic logic;
	private int step;
	
	public Time(Logic logic, int step) {
	
		this.logic = logic;
		this.running = true;
		this.step = step;
		this.startTime = System.currentTimeMillis();
	}
	
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
		    
		if (running) 
	         elapsed = (System.currentTimeMillis() - startTime);
	    else 
	        elapsed = (stopTime - startTime);
	    
	    return elapsed;
	}
	
	private String getElapsedTimeString() {
		
		seconds = (int) (getElapsedTime() / 1000);
		if (seconds > 60) {
			seconds -= seconds * 60;
			minutes++;
		}
		
		return minutes + ":" + seconds;
			
 		
	}
	
	
//	public void increaseTime() {
//		
//		seconds++;
//	}
//	
//	public void startTime() throws InterruptedException {
//		 
//	    boolean x=true;
//	    while(x)
//	    {
//	        TimeUnit.SECONDS.sleep(1);
//	        long timepassed=System.currentTimeMillis()-starttime;
//	        long secondspassed=timepassed/1000;
//	        if(secondspassed==60)
//	        {
//	            secondspassed=0;
//	            starttime=System.currentTimeMillis();
//	        }
//	        if((secondspassed%60)==0)
//	        minutes++;
//		
//	}
//	}
//	
//	public String getTime() {
//		
//		return minutes + ":" + seconds;
//	}

}
