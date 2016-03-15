package mutithreading.exercise.racing;

public class RaceDemo {

	@SuppressWarnings("static-access")
	public static void main(String[] args) throws InterruptedException {
		Racer racer=new Racer();
		Thread racer1=new Thread(racer, "racer 1");
		Thread racer2=new Thread(racer,"racer 2");
		racer1.start();
		racer2.start();
	}

}



