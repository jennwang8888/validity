package jw.pojo;

import java.util.List;

/*
 * this is a DTO 
 */

public class DataOut {

	/*
	 * hold duplicated data in list
	 */
	private List<List<String>> Potential_Duplicates;

	private List<String> None_Duplicates;

	/**
	 * @return the potential_Duplicates
	 */
	public List<List<String>> getPotential_Duplicates() {
		return Potential_Duplicates;
	}

	/**
	 * @param potential_Duplicates the potential_Duplicates to set
	 */
	public void setPotential_Duplicates(List<List<String>> potential_Duplicates) {
		Potential_Duplicates = potential_Duplicates;
	}

	/**
	 * @return the none_Duplicates
	 */
	public List<String> getNone_Duplicates() {
		return None_Duplicates;
	}

	/**
	 * @param none_Duplicates the none_Duplicates to set
	 */
	public void setNone_Duplicates(List<String> none_Duplicates) {
		None_Duplicates = none_Duplicates;
	}

}
