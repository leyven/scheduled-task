package com.mx.leyven.scheduledtask.camel.jobs;

import org.springframework.stereotype.Component;

import com.mx.leyven.scheduledtask.utils.TimeUtilery;

import lombok.extern.slf4j.Slf4j;

@Slf4j

/**
 * hello world like examples being called with camel scheduler and camel-cron
 * @author ecgomez
 * 
 */
@Component
public class SchedulerActions {
	public void task1() {
		TimeUtilery.printTime();
		log.info("camel starting task 1 using scheduler");
	}

	public void task2() {
		TimeUtilery.printTime();

		log.info("camel starting task 2 using scheduler");
	}

	public void task3() {
		TimeUtilery.printTime();

		log.info("camel starting task 3 using cron component");
	}
}
