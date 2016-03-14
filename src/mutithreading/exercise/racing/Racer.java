package mutithreading.exercise.racing;

public class Racer implements Runnable{

	public static String winner;
	private boolean isRaceWon;
	
	public void race() {

		// TODO Auto-generated method stub
		for(int distance=1;distance<=100;distance++){
			System.out.println("Distance covered by "+Thread.currentThread().getName()+" is "+distance);
			isRaceWon=checkIsRaceOver(distance);
			if (isRaceWon) {
				System.out.println("Winner is "+winner);
				break;
			}
			
		}
	
	}
	
	@Override
	public void run() {
		this.race();
	}
	private boolean checkIsRaceOver(int totalDistanceCovered) {
		if (!isRaceWon && totalDistanceCovered==100) {
			winner=Thread.currentThread().getName();
			return true;
		} else if(!isRaceWon && totalDistanceCovered<100){
			winner=null;
			return false;
		}
		return isRaceWon;
	}

}
