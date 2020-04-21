package com.uca.capas.tarea.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

@Controller
public class DateController {

	@RequestMapping("/date")
	public @ResponseBody String getDayOfWeek(HttpServletRequest req) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date;
		try {
			date = dateFormat.parse(req.getParameter("dia") + "/" + req.getParameter("mes") + "/" + req.getParameter("año"));
		} catch (ParseException e) {
			date = new Date();
			System.out.println("ups");
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int day = cal.get(Calendar.DAY_OF_WEEK);
		String dayName = "error";
		switch (day) {
		case Calendar.SUNDAY: dayName = "Domingo";
		break;
		case Calendar.MONDAY: dayName = "Lunes";
		break;
		case Calendar.TUESDAY: dayName = "Martes";
		break;
		case Calendar.WEDNESDAY: dayName = "Miercoles";
		break;
		case Calendar.THURSDAY: dayName = "Jueves";
		break;
		case Calendar.FRIDAY: dayName = "Friday";
		break;
		case Calendar.SATURDAY: dayName = "Sabado";
		break;
		}
		return dayName;
	}

}
