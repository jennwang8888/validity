package jw.service;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jw.pojo.PersonData;
import jw.pojo.DataOut;

@Service
public class ProcessData {

	@Autowired
	private LoadObjectList loadObjectList;
/**
 * read input file & process it
 * @param filePath
 * @return DTO DataOut
 */
	public DataOut processData(Path filePath) {
		List<PersonData> listData = loadObjectList.loadObjectList(PersonData.class, filePath);

		if (listData == null || listData.size() == 0)
			return null;

		HashMap<PersonData, List<String>> map = processData(listData);

		return transfermData(map);
	}
/**
 * transferm data from hashmap to DTO DataOut
 * @param map
 * @return DTO DataOut
 */
	private DataOut transfermData(HashMap<PersonData, List<String>> map) {
		DataOut dataOut = new DataOut();

		for (PersonData key : map.keySet()) {
			ArrayList<String> l = (ArrayList<String>) map.get(key);
			if (l.size() > 1) {
				// potentail Dup
				if (dataOut.getPotential_Duplicates() == null) {
					ArrayList<List<String>> dupList = new ArrayList<List<String>>();
					dataOut.setPotential_Duplicates(dupList);
				}

				List<List<String>> dupList = dataOut.getPotential_Duplicates();

				dupList.add((List<String>) map.get(key));

			} else {
				// none dup
				if (dataOut.getNone_Duplicates() == null) {
					ArrayList<String> noneDupList = new ArrayList<String>();
					dataOut.setNone_Duplicates(noneDupList);
				}
				List<String> noneDupList = dataOut.getNone_Duplicates();
				String d2 = ((List<String>) map.get(key)).get(0);
				noneDupList.add(d2);
			}
		}

		return dataOut;
	}
	
	/**
	 * process input listData and put in hashmap. All duplicated data in the arraylist
	 * @param listData
	 * @return
	 */
	private HashMap<PersonData, List<String>> processData(List<PersonData> listData) {
		HashMap<PersonData, List<String>> map = new HashMap<PersonData, List<String>>();

		for (PersonData d : listData) {
			if (map.containsKey(d)) {
				//dup add to the arraylist
				ArrayList<String> l = (ArrayList<String>) map.get(d);
				l.add(d.toString());
			} else {
				//none-dup
				ArrayList<String> l = new ArrayList<String>();
				l.add(d.toString());
				map.put(d, l);
			}
		}

		return map;
	}

}
