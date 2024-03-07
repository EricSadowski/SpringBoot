package com.example.depInj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DepInjApplication {

	@Bean
	public PaymentMethod paymentMethod(){
		return new CreditCardPayment();  //can also use paypal payment
	}

	@Bean
	public OrderService orderService() {
		return new OrderService(paymentMethod());
	}


	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DepInjApplication.class);
		OrderService orderService = context.getBean(OrderService.class);
		orderService.placeOrder(100);
	}




}
