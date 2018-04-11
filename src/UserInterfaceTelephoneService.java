
public class UserInterfaceTelephoneService {
	
	Connection connection;
	
	public UserInterfaceTelephoneService(Connection connection) {
		this.connection = connection;
	}

	public void recordMessage (String message) {
		connection.recordMessage(message);
	}
	
	public void hangUp () {
		connection.hangUp();
	}
	
	public void dial(String input) {
		connection.dial(input);
	}
	
}
