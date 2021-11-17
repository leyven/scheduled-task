package com.mx.leyven.scheduledtask.business;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Component;

import com.mx.leyven.scheduledtask.entity.Tasks;
import com.mx.leyven.scheduledtask.repository.TasksRepository;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j

public class ScheduledComponent {

	@Autowired
	TasksRepository tasksRepository;

	/**
	 * Main process to run on a calendarized event, executes every min, can be
	 * configurable depending on the cron job / scheduled event reads the db in this
	 * case an embebed h2 for task to execute
	 * 
	 * @throws ParseException
	 */
	@Modifying
	public void cycles() throws ParseException {
		log.info("------- starting cycles -------");
		List<Tasks> tasks = tasksRepository.findByActive(true);
		executeScheduledTask(tasks);
	}

	/**
	 * Processes a list of tasks here is where the main business logic should be for
	 * this example we only change the active field to false but it can be replaced
	 * by any logic, like sending emails
	 * 
	 * @param tasks
	 * @throws ParseException
	 */
	@Modifying
	public void executeScheduledTask(List<Tasks> tasks) throws ParseException {
		long now = System.currentTimeMillis();
		Date date = new Date(now);
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
		sdf.setTimeZone(TimeZone.getTimeZone("America/Mexico_City"));
		String dateNow = sdf.format(date);
		log.info("scheduled starts at time  : {}", dateNow);

		/*
		 * foreach task we compare with the actual time and execute the task if we are
		 * at the same hour/minute than the task registered can be as complex as you
		 * want it to be a full timestamp could be provided to increase the precisition
		 * of the task involved
		 */
		for (Tasks task : tasks) {
			String scheduleTaskDate = task.getScheduledTime();
			Date dateScheduled = sdf.parse(scheduleTaskDate);
			String dateScheduledText = sdf.format(dateScheduled);
			Boolean canExecute = dateNow.equals(dateScheduledText);
			if (Boolean.TRUE.equals(canExecute)) {
				log.info("task has been executed at {} ",dateScheduledText);
				task.setActive(false);
				tasksRepository.save(task);
			}
		}

	}
}
