package io.vishal.comtroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

public class TestController {

	@GetMapping("/test")
	public ResponseEntity<String> test(){
		return ResponseEntity.ok("working");
	}
}
