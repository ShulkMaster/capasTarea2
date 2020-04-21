package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

@Controller
@RequestMapping("/date")
public class DateController {
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody String getDayOfWeek(int dayOfMoth, int mothOfYear, int year) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date;
		try {
			date = dateFormat.parse(dayOfMoth + "/" + mothOfYear + "/" + year);
		} catch (ParseException e) {
			date = new Date();
			e.printStackTrace();
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
