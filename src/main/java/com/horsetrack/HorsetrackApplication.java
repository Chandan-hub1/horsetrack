package com.horsetrack;

import com.horsetrack.controller.KioskMode;
import com.horsetrack.repository.HorseRepository;
import com.horsetrack.repository.InventoryRepository;
import com.horsetrack.service.HorseService;
import com.horsetrack.service.ReporterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Profile;

import java.util.Scanner;

@Profile("!test")
@SpringBootApplication
public class HorsetrackApplication implements CommandLineRunner {

	@Autowired
	private ConfigurableApplicationContext context;

	@Autowired
	HorseRepository horseRepository;

	@Autowired
	InventoryRepository inventoryRepository;

	@Autowired
	HorseService horseService;

	@Autowired
	ReporterService reporterService;

	@Autowired
	KioskMode kioskMode;
	public static void main(String[] args) {
		SpringApplication.run(HorsetrackApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		kioskMode.initialize();

		kioskMode.printStartupMessages();

		Scanner commandString = new Scanner(System.in);
		while (!(kioskMode.quit())) {

			// Read from the command line
			// validate the input
			kioskMode.execute(commandString.nextLine());

		}

		System.exit(SpringApplication.exit(context));
	}
}
