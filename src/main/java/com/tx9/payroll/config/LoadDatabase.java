package com.tx9.payroll.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tx9.payroll.model.Employee;
import com.tx9.payroll.model.Order;
import com.tx9.payroll.repository.EmployeeRepository;
import com.tx9.payroll.repository.OrderRepository;
import com.tx9.payroll.status.Status;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class LoadDatabase {

	@Bean
	CommandLineRunner initDatabase(EmployeeRepository repository, OrderRepository orderRepository) {
		return args -> {
			log.info("Preloading " + repository.save(new Employee("Jacob", "Lee", "Full Stack Developer")));
			log.info("Preloading " + repository.save(new Employee("Angela", "Han", "Accountant")));
			log.info("Preloading " + orderRepository.save(new Order("MacBook Pro", Status.COMPLETED)));
			log.info("Preloading " + orderRepository.save(new Order("iPhone", Status.IN_PROGRESS)));

			orderRepository.findAll().forEach(order -> {
				log.info("Preloaded " + order);
			});
		};
	}
}
