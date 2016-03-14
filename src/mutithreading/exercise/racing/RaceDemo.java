package mutithreading.exercise.racing;

public class RaceDemo {

	@SuppressWarnings("static-access")
	public static void main(String[] args) throws InterruptedException {
		Racer racer=new Racer();
		Thread thread1=new Thread(racer, "racer1");
		Thread thread2=new Thread(racer, "racer2");
		Thread thread3=new Thread(racer, "racer3");
		Thread thread4=new Thread(racer, "racer4");
		Thread thread5=new Thread(racer, "racer5");
		Thread thread6=new Thread(racer, "racer6");
		Thread thread7=new Thread(racer, "racer7");
		Thread thread8=new Thread(racer, "racer8");
		Thread thread9=new Thread(racer, "racer9");
		Thread thread10=new Thread(racer, "racer10");
		thread1.start();
//		Thread tortoise=new Thread(racer, "tortoise");
//		Thread hare=new Thread(racer,"hare");
		//tortoise.start();
		//hare.start();
		//hare.sleep(100);
		//tortoise.sleep(10);
	}

}
