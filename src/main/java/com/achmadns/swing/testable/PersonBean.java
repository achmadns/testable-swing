package com.achmadns.swing.testable;

public class PersonBean extends Bean {
	private String firstName;
	private String lastName;
	private String phone;
	private String email;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String zipCode;
	private String country;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		String old = this.firstName;
		this.firstName = firstName;
		firePropertyChange("firstName", old, firstName);
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		String old = this.lastName;
		this.lastName = lastName;
		firePropertyChange("lastName", old, lastName);
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		String old = this.phone;
		this.phone = phone;
		firePropertyChange("phone", old, phone);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		String old = this.email;
		this.email = email;
		firePropertyChange("email", old, email);
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		String old = this.address1;
		this.address1 = address1;
		firePropertyChange("address1", old, address1);
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		String old = this.address2;
		this.address2 = address2;
		firePropertyChange("address2", old, address2);
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		String old = this.city;
		this.city = city;
		firePropertyChange("city", old, city);
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		String old = this.state;
		this.state = state;
		firePropertyChange("state", old, state);
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		String old = this.zipCode;
		this.zipCode = zipCode;
		firePropertyChange("zipCode", old, zipCode);
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		String old = this.country;
		this.country = country;
		firePropertyChange("country", old, country);
	}

	@Override
	public String toString() {
		return "PersonBean [firstName=" + firstName + ", lastName=" + lastName
				+ ", phone=" + phone + ", email=" + email + ", address1="
				+ address1 + ", address2=" + address2 + ", city=" + city
				+ ", state=" + state + ", zipCode=" + zipCode + ", country="
				+ country + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((address1 == null) ? 0 : address1.hashCode());
		result = prime * result
				+ ((address2 == null) ? 0 : address2.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((zipCode == null) ? 0 : zipCode.hashCode());
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
		PersonBean other = (PersonBean) obj;
		if (address1 == null) {
			if (other.address1 != null)
				return false;
		} else if (!address1.equals(other.address1))
			return false;
		if (address2 == null) {
			if (other.address2 != null)
				return false;
		} else if (!address2.equals(other.address2))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (zipCode == null) {
			if (other.zipCode != null)
				return false;
		} else if (!zipCode.equals(other.zipCode))
			return false;
		return true;
	}
}
