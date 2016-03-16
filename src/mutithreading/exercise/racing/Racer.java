package mutithreading.exercise.racing;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Racer implements Runnable {

	public static String winner;

	static Map<String, Integer> threadAndDistance = new HashMap<String, Integer>();
	static Map<String, Long> threadAndStartingTime = new HashMap<String, Long>();
	static Map<String, Long> threadAndEndingTime = new HashMap<String, Long>();
	static final int totalDistance = 10;

	public void race() {

		for (int distance = 1; distance <= totalDistance; distance++) {
			// if (winner != null) {
			// break;
			// }
			checkStatus(distance);
			// if (winner != null) {
			// break;
			// }
		}

	}

	private static int cnt = 0;

	/*
	 * 
	 * Checking the distance covered by each racer and if the race is over
	 * calculating the time taken by each racer and simultaneously printing it
	 */

	private synchronized void checkStatus(int distance) {
		String racerName = Thread.currentThread().getName();
		try {
			Thread.currentThread().sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		isRaceWon(racerName);
		System.out.println("Distance covered by " + racerName + " is "
				+ threadAndDistance.get(racerName));
		if (cnt == 0) {
			if (winner != null) {
				System.out.println("Winner is " + winner);
				cnt++;
			}
		}
		if (threadAndDistance.get(racerName) == totalDistance) {
			long timeTaken = threadAndEndingTime.get(racerName)
					- threadAndStartingTime.get(racerName);
			System.out
					.println("Time taken by " + racerName
							+ " to complete the race is " + timeTaken
							+ " milliseconds");
		}
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()
				+ " started running...");
		threadAndDistance.put(Thread.currentThread().getName(), new Integer(1));
		threadAndStartingTime.put(Thread.currentThread().getName(), Calendar
				.getInstance().getTimeInMillis());
		this.race();
	}

	private void isRaceWon(String racerName) {

		if (threadAndDistance.get(racerName) >= totalDistance) {

			if (cnt == 0) {
				winner = racerName;
			}
		} else {
			threadAndDistance.put(racerName,
					threadAndDistance.get(racerName) + 1);
			if (threadAndDistance.get(racerName) == totalDistance) {
				threadAndEndingTime.put(racerName, Calendar.getInstance()
						.getTimeInMillis());
			}
		}
	}

}
