// ExecutorThread
public class ExecutorThread implements Runnable 
{
	private String ExecutorThread;
	private int count;
	private final long timeSleep;

	ExecutorThread(String name, int newcount, long newtimeSleep) 
	{
		this.ExecutorThread = name;
	    this.count = newcount;
	    this.timeSleep = newtimeSleep;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub

		int sum = 0;
	    for (int i = 1; i <= this.count; i++) 
	    {
	    	sum = sum + i;
	    }
	    System.out.println(ExecutorThread + " thread of Dice has sum = " + sum + 
	    		" and is going to sleep for " + timeSleep);
	    try {
			Thread.sleep(this.timeSleep);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

} // end ExecutorThread