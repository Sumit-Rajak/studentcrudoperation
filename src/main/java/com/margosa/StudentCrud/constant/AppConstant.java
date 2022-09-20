package com.margosa.StudentCrud.constant;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

public class AppConstant {

	
	public static final ZoneId INDIA_ZONE = ZoneId.of("Asia/Kolkata");

	
	
	 public static final java.util.Date INDIA_ZONE_DATE = Date.from(ZonedDateTime.now(INDIA_ZONE).toInstant());

}
