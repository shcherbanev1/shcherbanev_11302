public class TimePart {
	
	private int hours;
	private int minutes;
	private int seconds;
	
	public TimePart(int hours, int minutes, int seconds) throws WrongTimeException {
		if (hours < 0 || minutes < 0 || seconds < 0) {
			throw new WrongTimeException();
		}
		if (seconds >= 60) {
			minutes += seconds / 60;
			seconds = seconds % 60;
		}
		if (minutes >= 60) {
			hours += minutes / 60;
			minutes = minutes % 60;
		}
		this.hours = hours;
		this.minutes = minutes;
		this.seconds = seconds;
	}
	
	
	public TimePart sum(TimePart other) throws WrongTimeException {
		return new TimePart(hours + other.hours, minutes + other.minutes, seconds + other.seconds);
	}
	
	public TimePart multiply(int n) throws WrongTimeException  {
		return new TimePart(n * hours, n* minutes, n * seconds);
	}
	
	public TimePart getDifference(TimePart other) throws WrongTimeException  {
		return new TimePart(Math.abs(hours - other.hours), 
							Math.abs(minutes - other.minutes), 
							Math.abs(seconds - other.seconds));
	}
	
	public int getDifferenceInSeconds(TimePart other) throws WrongTimeException  {
		int ans = Math.abs(hours - other.hours) * 3600 + Math.abs(minutes - other.minutes) * 60 + Math.abs(seconds - other.seconds);
		return ans;
	}
	
	public String Compare(TimePart other) {
		int time1InSeconds = hours * 3600 + minutes * 60 + seconds;
		int time2InSeconds = other.hours * 3600 + other.minutes * 60 + other.seconds;
		if (time1InSeconds > time2InSeconds) {
			return "первый промежуток больше";
		}
		if (time2InSeconds > time1InSeconds) {
			return "второй промежуток больше";
		}
		return "равны";
	}
	
	public String toString() {
		return hours + " час, " + minutes + " минут, " + seconds + " секунд";
	}
	
	public boolean equals(TimePart other) {
		return hours == other.hours && minutes == other.minutes && seconds == other.seconds;
	}
	
}