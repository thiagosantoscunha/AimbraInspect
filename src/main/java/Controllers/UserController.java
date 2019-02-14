package Controllers;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class UserController implements Serializable {

	private static final long serialVersionUID = 6069963068944277647L;

	private String message = "Hello World, Thiago";

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
