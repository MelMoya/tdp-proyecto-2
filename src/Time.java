import java.util.concurrent.TimeUnit;

public class Time {

	private long startTime = 0;
	private long stopTime = 0;
	private boolean running = false;
	private Logic logic;
    long starttime= 0;
	
	public Time(Logic logic) {
		
		this.logic = logic;
		start();
	}
	
	public void start() {
	    this.startTime = System.currentTimeMillis();
	    this.running = true;
	}


	public void stop() {
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
