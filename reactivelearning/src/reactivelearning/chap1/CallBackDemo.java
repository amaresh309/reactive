package reactivelearning.chap1;

public class CallBackDemo {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Main Thread is running");
		
		Runnable r = new Runnable() {
			@Override
			public void run() {
			    new CallBackDemo().runningAsync(new CallBack() {

					@Override
					public void call() {
					System.out.println("Callback called!!!");
						
					}
			    	
			    });	
			}
		};
	
		Thread t = new Thread(r);
		t.start();
		Thread.sleep(2000);
		System.out.println("Main Thread completed");
	}
	
	public void runningAsync(CallBack callback) {
		System.out.println("I am running in a separate thread");
		sleep(1000);
		callback.call();
	}

	private void sleep(int i) {
		
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
