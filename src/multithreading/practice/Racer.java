package multithreading.practice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Racer implements Runnable {

	public static String winner;

	static Map<String, Integer> threadAndDistance = new HashMap<String, Integer>();

	public void race() {

		// TODO Auto-generated method stub
		for (int distance = 1; distance <= 1000; distance++) {
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
		if (threadAndDistance.get(Thread.currentThread().getName()) >= 1000) {
			winner = Thread.currentThread().getName();
		} else {
			threadAndDistance.put(Thread.currentThread().getName(),
					threadAndDistance.get(Thread.currentThread().getName()) + 1);
		}
	}

}
