import java.util.concurrent.TimeUnit;

public class Time extends Thread {

	private long startTime = 0;
	private long stopTime = 0;
	private boolean running;
	private Logic logic;
	private int step;
    long starttime = 0;
	
	public Time(Logic logic, int step) {
	
		this.logic = logic;
		this.running = true;
		this.step = step;
	}
	

	public void stopTime() {
	    this.stopTime = System.currentTimeMillis();
	    this.running = false;
	}


	public long getElapsedTime() {
	    long elapsed;
	    if (running) 
	         elapsed = (System.currentTimeMillis() - startTime);
	    else 
	        elapsed = (stopTime - startTime);
	    
	    return elapsed;
	}

	@Override
	public void run() {
		

		while (this.running) {
			try {
				Thread.sleep(step);
				logic.moveToDown();			
			} catch(InterruptedException e) {}
		}
	}


	public void setStep(int step) {
		this.step = step;
		
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
