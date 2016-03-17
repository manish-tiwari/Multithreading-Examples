package multithreading.practice.TortoiseVsHare;

public class RaceDemo {

	@SuppressWarnings("static-access")
	public static void main(String[] args) throws InterruptedException {
		Racer racer=new Racer();
		Thread tortoiseThread=new Thread(racer, "tortoise");
		Thread hareThread=new Thread(racer,"hare");
		tortoiseThread.start();
		hareThread.start();
		//tortoise.sleep(1000*10);
		//tortoise.sleep(10);
	}

}
