package savantly.sprout.viewModel;

import java.io.Serializable;

public class CommonResponse implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7505341094957126539L;
	String message;
	Object value;
	
	public CommonResponse(String message){
		this.message = message;
	}
	
	public CommonResponse(String message, Object value){
		this.message = message;
		this.value = value;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}
}
