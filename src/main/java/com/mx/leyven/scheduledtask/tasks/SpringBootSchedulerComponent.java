package com.mx.leyven.scheduledtask.tasks;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.mx.leyven.scheduledtask.business.ScheduledComponent;
import com.mx.leyven.scheduledtask.utils.TimeUtilery;

import lombok.extern.slf4j.Slf4j;
@Component
@Slf4j
public class SpringBootSchedulerComponent {
	
	
	@Autowired
	ScheduledComponent scheduledComponent;
	
	@Scheduled(fixedRate = 5000)
	public void scheduleFixedRateTask() {
		TimeUtilery.printTime();
		log.info("spring-boot scheduled using fixed rate");
	}

	@Scheduled(fixedDelay = 10000, initialDelay = 5000)
	@Scheduled(cron = "@hourly")
	@Scheduled(cron = "0 0 3 * * *", zone = "America/Mexico_City")
	public void scheduleFixedRateWithInitialDelayTask() {

		TimeUtilery.printTime();
		log.info("spring-boot scheduled using fixedDelay and initialDelay");
	}

	
	
	@Scheduled(cron = "0 * * * * *")
	public void scheduleTaskUsingCronExpression() throws ParseException {
		TimeUtilery.printTime();
		scheduledComponent.cycles();
	}
	
	

}
