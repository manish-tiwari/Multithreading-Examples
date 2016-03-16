package mutithreading.exercise.racing;

public class RelayRace {

	private static final int numberOfRacers = 10;

	@SuppressWarnings("static-access")
	public static void main(String[] args) throws InterruptedException {
		Racer racer = new Racer();
		
		/*
		 * creating threads dynamically for each racer
		 * */
		
		 Thread[] threads = new Thread[numberOfRacers];
		 for (int i = 0; i < threads.length; i++) {
			 String racerName="racer "+String.valueOf(i);
		     threads[i] = new Thread(racer,racerName);
//		     threads[i].start();
		 }
		 
		 for (int i = 0; i < threads.length; i++) {
//			 String racerName=racer+" "+String.valueOf(i);
//		     threads[i] = new Thread(racer,racerName);
		     threads[i].start();
		 }
		
//		Thread racer1 = new Thread(racer, "racer 1");
//		Thread racer2 = new Thread(racer, "racer 2");
//		Thread racer3 = new Thread(racer, "racer 3");
//		Thread racer4 = new Thread(racer, "racer 4");
//		Thread racer5 = new Thread(racer, "racer 5");
//		Thread racer6 = new Thread(racer, "racer 6");
//		Thread racer7 = new Thread(racer, "racer 7");
//		Thread racer8 = new Thread(racer, "racer 8");
//		Thread racer9 = new Thread(racer, "racer 9");
//		Thread racer10 = new Thread(racer, "racer 10");
//		racer1.start();
//		racer2.start();
//		racer3.start();
//		racer4.start();
//		racer5.start();
//		racer6.start();
//		racer7.start();
//		racer8.start();
//		racer9.start();
//		racer10.start();
	}

}
