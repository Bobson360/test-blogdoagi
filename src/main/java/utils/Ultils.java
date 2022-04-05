package utils;

public class Ultils {
	
public static boolean isUnix() {
	return !System.getProperty("os.name").toLowerCase().contains("Win");
}

public static boolean isMac() {
	return System.getProperty("os.name").toLowerCase().contains("mac");
}



public static void main(String[] args) {
	System.out.println(isMac());
}
}
