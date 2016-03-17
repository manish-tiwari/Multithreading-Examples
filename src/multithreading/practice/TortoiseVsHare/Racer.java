package multithreading.practice.TortoiseVsHare;

import java.util.HashMap;
import java.util.Map;

public class Racer implements Runnable {

	public static String winner;

	static Map<String, Integer> threadAndDistance = new HashMap<String, Integer>();
	private static final int totalDistance = 10;

	public void race() {

		for (int distance = 1; distance <= totalDistance; distance++) {
			if (winner != null) {
				break;
			}
			checkStatus(distance);
			if (winner != null) {
				break;
			}
		}

	}

	private static int cnt = 0;

	private synchronized void checkStatus(int distance) {
		try {
			Thread.currentThread().sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		isRaceWon();
		if (cnt == 0) {
			System.out.println("Distance covered by " + Thread.currentThread().getName() + " is " + distance);
			if (winner != null) {
				System.out.println("Winner is " + winner);
				cnt++;
			}
		}
	}

	@Override
	public void run() {
		System.out.println("Thread:" + Thread.currentThread().getName());
		threadAndDistance.put(Thread.currentThread().getName(), new Integer(1));
		this.race();
	}

	private void isRaceWon() {
		if (winner != null) {
			return;
		}
		if (threadAndDistance.get(Thread.currentThread().getName()) >= totalDistance) {
			winner = Thread.currentThread().getName();
		} else {
			threadAndDistance.put(Thread.currentThread().getName(),
					threadAndDistance.get(Thread.currentThread().getName()) + 1);
		}
	}

}
