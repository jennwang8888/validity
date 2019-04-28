package jw.service;

import java.io.File;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

@Service
public class LoadObjectList {
	private Logger logger = LoggerFactory.getLogger(LoadObjectList.class);

	public <T> List<T> loadObjectList(Class<T> type, Path filePath) {
		try {
			CsvSchema bootstrapSchema = CsvSchema.emptySchema().withHeader();
			CsvMapper mapper = new CsvMapper();
			File file = filePath.toFile();
			MappingIterator<T> readValues = mapper.readerFor(type).with(bootstrapSchema).readValues(file);
			return readValues.readAll();
		} catch (Exception e) {
			logger.error("Error occurred while loading object list from file " + filePath.getFileName(), e);
			return Collections.emptyList();
		}
	}

}