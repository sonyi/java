package cn.imcore.talk;

import java.net.Socket;

public class User {

	private Socket cus;
	private String name;
	
	public User(Socket cus, String name) {
		this.cus = cus;
		this.name = name;
	}

	public Socket getCus() {
		return cus;
	}

	public void setCus(Socket cus) {
		this.cus = cus;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cus == null) ? 0 : cus.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (cus == null) {
			if (other.cus != null)
				return false;
		} else if (!cus.equals(other.cus))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	

}
