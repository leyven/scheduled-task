package com.mx.leyven.scheduledtask.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeUtilery {

	private TimeUtilery() {
		throw new IllegalStateException("Utility class");
	}
	public static void printTime() {
		long now = System.currentTimeMillis();
		Date date = new Date(now);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		sdf.setTimeZone(TimeZone.getTimeZone("America/Mexico_City"));
		log.info("------------###------------");
		log.info(sdf.format(date));
	}
}
