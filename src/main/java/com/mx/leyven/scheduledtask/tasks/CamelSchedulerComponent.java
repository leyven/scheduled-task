package com.mx.leyven.scheduledtask.tasks;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
	public class CamelSchedulerComponent extends RouteBuilder {


	    @Value("${camel.config.scheduler.delay}")
	    private String delay;
	    
	    @Value("${camel.config.scheduler.initialDelay}")
	    private String initialDelay;

	    @Value("${camel.config.cron.testTask}")
	    private String testCron;


	    @Override
	    public void configure() throws Exception {

	        from(String.format("scheduler://runCancelationJobs?delay=%s&initialDelay=%s", delay,initialDelay))
	                .to("bean:schedulerActions?method=task1")
	                .log("terminando primera accion")
	                .to("bean:schedulerActions?method=task2")
	                .log("termina flujo principal")
	                .end();
	        
	        from(String.format("cron:tab?schedule=%s",testCron))
	        .setBody().constant("camel using  cron")
	        .log("${body}");


	    }
	}

