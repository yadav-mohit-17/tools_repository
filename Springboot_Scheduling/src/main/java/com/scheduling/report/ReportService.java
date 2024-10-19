package com.scheduling.report;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ReportService {

	
//	@Scheduled(fixedDelay = 2000)
	@Scheduled(cron = "*/10 * * * * *")
	public void printReport() {
		System.out.println("Report "+new Date());
	}
}
