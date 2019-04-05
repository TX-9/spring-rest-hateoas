package com.tx9.payroll.assembler;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import com.tx9.payroll.controller.EmployeeController;
import com.tx9.payroll.model.Employee;

@Component
public class EmployeeResourceAssembler implements ResourceAssembler<Employee, Resource<Employee>>{

	@Override
	public Resource<Employee> toResource(Employee employee) {

		return new Resource<>(employee,
			linkTo(methodOn(EmployeeController.class).one(employee.getId())).withSelfRel(),
			linkTo(methodOn(EmployeeController.class).all()).withRel("employees"));
	}
}
