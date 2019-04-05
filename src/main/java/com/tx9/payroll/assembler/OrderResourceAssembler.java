package com.tx9.payroll.assembler;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;


import com.tx9.payroll.controller.OrderController;
import com.tx9.payroll.model.Order;
import com.tx9.payroll.status.Status;

@Component
public class OrderResourceAssembler implements ResourceAssembler<Order, Resource<Order>> {

	@Override
	public Resource<Order> toResource(Order order) {
		// unconditional links to single-item resource and aggregate root
		Resource<Order> orderResource = new Resource<>(
				order,
				linkTo(methodOn(OrderController.class).one(order.getId())).withSelfRel(),
				linkTo(methodOn(OrderController.class).all()).withRel("orders")
		);
		
		if (order.getStatus() == Status.IN_PROGRESS) {
			orderResource.add(
				linkTo(methodOn(OrderController.class)
					.cancel(order.getId())).withRel("cancel"));
			orderResource.add(
				linkTo(methodOn(OrderController.class)
					.complete(order.getId())).withRel("complete"));
		}

		return orderResource;
	}

}
