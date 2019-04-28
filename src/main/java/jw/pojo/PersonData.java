package jw.pojo;

import java.util.Objects;
import org.apache.commons.codec.language.Metaphone;

/*
 *  this matchs input file
 */
public class PersonData {
	private int id;
	private String first_name;
	private String last_name;
	private String email;
	private String company;
	private String address1;
	private String address2;
	private String zip;
	private String city;
	private String state_long;
	private String state;
	private String phone;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the first_name
	 */
	public String getFirst_name() {
		return first_name;
	}

	/**
	 * @param fname the fname to set
	 */
	public void setFirst_name(String fname) {
		this.first_name = fname;
	}
	

	/**
	 * @return the lname
	 */
	public String getLast_name() {
		return last_name;
	}

	/**
	 * @param lname the lname to set
	 */
	public void setLast_name(String lname) {
		this.last_name = lname;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the company
	 */
	public String getCompany() {
		return company;
	}

	/**
	 * @param company the company to set
	 */
	public void setCompany(String company) {
		this.company = company;
	}

	/**
	 * @return the address1
	 */
	public String getAddress1() {
		return address1;
	}

	/**
	 * @param address1 the address1 to set
	 */
	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	/**
	 * @return the address2
	 */
	public String getAddress2() {
		return address2;
	}

	/**
	 * @param address2 the address2 to set
	 */
	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	/**
	 * @return the zip
	 */
	public String getZip() {
		return zip;
	}

	/**
	 * @param zip the zip to set
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the state_long
	 */
	public String getState_long() {
		return state_long;
	}

	/**
	 * @param state_long the state_long to set
	 */
	public void setState_long(String state_long) {
		this.state_long = state_long;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Override
	public String toString() {
		return id + "," + last_name + "," + first_name + "," + company + "," + email + "," + address1 + "," + address2
				+ "," + zip + "," + city + "," + state_long + "," + state + "," + phone;

	}

	@Override
	public int hashCode() {
		Metaphone metaphone = new Metaphone();
		// last name should be same regardless case, first name should be metaphone equal
		return Objects.hash(metaphone.metaphone(first_name), last_name.toUpperCase() ) ;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}

		// fuzzy rules are here
		// hash take care last name & first name
		// email & phone should match one of them if it has
		// can add more rules if needed

		PersonData other = (PersonData) obj;
		
		if(matchPhoneEmail(other)) {
			return true;
		}

		return false;
	}

	
	/*
	 * compare 2 strings, return true if one of them is null
	 * otherwise compare them
	 */
	private boolean matchString(String s1, String s2) {
		if (s1 == null) {
			return true;
		}

		if (s2 == null) {
			return true;
		}
		return s1.equalsIgnoreCase(s2);

	}
	
	
	private boolean matchPhoneEmail(PersonData other) {
		//we can remove - from phone & check the first one if it is 1
		// I skiped that to save time
		return (matchString(email, other.email) || matchString(phone, other.phone));		
	}

}
