package bean;

public class InvalidAgeException extends Exception {
String message;

public InvalidAgeException() {
	super();
}

@Override
public String toString() {
	return "InvalidAgeException [message=" + message + "]";
}

}
