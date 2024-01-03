import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Container {
	
	 static LocalDateTime now = LocalDateTime.now();
	 
	 static String regDate = now.format(DateTimeFormatter.ofPattern("yy-MM-dd HH:mm:ss"));

	public static LocalDateTime getNow() {
		return now;
	}

	public static void setNow(LocalDateTime now) {
		Container.now = now;
	}

	public static String getRegDate() {
		return regDate;
	}

	public static void setRegDate(String regDate) {
		Container.regDate = regDate;
	}
	 
	 
}
