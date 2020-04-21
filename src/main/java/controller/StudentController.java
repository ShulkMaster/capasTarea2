package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StudentController {

	@RequestMapping("/student")
	public @ResponseBody String GetStudentInfo() {
		return "Jose Limones 01000101 Ingenieria en limones 2016";
	}

}
