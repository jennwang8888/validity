package jw.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jw.pojo.DataOut;
import jw.service.ProcessData;

@RestController
public class HelloController {

	@Autowired
	ProcessData processData;

	private Logger logger = LoggerFactory.getLogger(HelloController.class);

	@Value("${file.path}")
	private String filePath;

	@Value("${file.extension}")
	private String fileExtension;

	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

	/*
	 * load file fileName from the path in properties file as file.path
	 * process it & return as json back
	 */
	@RequestMapping("/get2/{fileName}")
	public DataOut getData2(@PathVariable String fileName) {
		
		Path path = Paths.get(filePath + fileName + fileExtension);
		if (Files.notExists(path)) {
			
			logger.info("file is not there " + filePath + fileName + fileExtension );
			return null;
		}
			
		return processData.processData(path);
	}

}
