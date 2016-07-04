package example.common;

public class CustomMessage {

	private String message;

	private long senderId;

	public CustomMessage(long senderId, String message) {
		this.senderId = senderId;
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public long getSenderId() {
		return senderId;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setSenderId(long senderId) {
		this.senderId = senderId;
	}

}
