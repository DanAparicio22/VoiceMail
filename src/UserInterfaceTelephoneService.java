
public class UserInterfaceTelephoneService {
	
	private static final String KEYS_FOR_DIAL = "1234567890#";
	private static final int ZERO_COINCIDENCES = 0;
	private static final int LENGTH_ONE = 1;
	private static final String HANG_UP = "H";
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
	
	public void processInput(String input) {
		if(isHangUp(input)) {
			hangUp();
		} else {
			if(isDial(input)) {
				dial(input);
			} else {
				recordMessage(input);
			}
		}
	}
	
	private boolean isHangUp(String key) {
		return key.equalsIgnoreCase(HANG_UP);
	}
	
	private boolean isDial(String key) {
		return key.length() == LENGTH_ONE && getCoincidencesInput(key) >= ZERO_COINCIDENCES;
	}
	
	private int getCoincidencesInput(String key) {
		return KEYS_FOR_DIAL.indexOf(key);
	}
	
}
