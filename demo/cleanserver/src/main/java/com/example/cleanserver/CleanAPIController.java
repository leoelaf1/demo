package com.example.cleanserver;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CleanAPIController {

	@CrossOrigin(origins = "*")
	@RequestMapping("/clean")
	public CleanOutput clean(
			@RequestParam(name = "filename", required = false, defaultValue = "../def") String filename) {
		CleanFileProcessor processor = new CleanFileProcessor();
		return processor.processFile(filename);
	}
}
