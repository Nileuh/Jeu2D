
public class Temps {
	
	private final long startTime;
	
	Temps(long startTime){
		this.startTime = startTime;
	}

	public long getStartTime() {
		return startTime;
	}
	
	public long tempsDeJeu() {
		long tempsT = System.currentTimeMillis();
		long estimatedTime = (tempsT - startTime) / 1000;
		return estimatedTime;
	}

}
