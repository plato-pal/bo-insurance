package bo.insurance;

import java.io.Serializable;

public class IssuePolicyRequest implements Serializable {

	private static final long serialVersionUID = 6661595520940618248L;
	
	private String name;
	private int product;
	private String email;
	
	public IssuePolicyRequest() {}

	public IssuePolicyRequest(String name, int product, String email) {
		super();
		this.name = name;
		this.product = product;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getProduct() {
		return product;
	}

	public void setProduct(int product) {
		this.product = product;
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
		builder.append("IssuePolicyRequest [name=");
		builder.append(name);
		builder.append(", product=");
		builder.append(product);
		builder.append(", email=");
		builder.append(email);
		builder.append("]");
		return builder.toString();
	}
}
