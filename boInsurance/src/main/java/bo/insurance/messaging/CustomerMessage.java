package bo.insurance.messaging;

import java.io.Serializable;

public class CustomerMessage implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8084890509350208828L;
	
	public final static String CUSTOMER_QUEUE_NAME = "CustomerQueue";
	
	private String name;
	private String policyNumber;
	private String email;
	
	public CustomerMessage() {}

	public CustomerMessage(String name, String policyNumber, String email) {
		super();
		this.name = name;
		this.policyNumber = policyNumber;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Message [name=");
		builder.append(name);
		builder.append(", policyNumber=");
		builder.append(policyNumber);
		builder.append(", email=");
		builder.append(email);
		builder.append("]");
		return builder.toString();
	}

	
}
