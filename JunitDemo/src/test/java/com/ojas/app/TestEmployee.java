package com.ojas.app;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(OrderAnnotation.class)
public class TestEmployee {
	
	@BeforeEach
	public void setup() {
		System.out.println("setup");
	}
	
	@AfterEach
	public void clear() {
		System.out.println("clear");
	}

	@Test
	@DisplayName("Testing Save Method ")
	public void testSave() {
		System.out.println("Hello");
	}
	
	@Test
	@DisplayName("Testing Update Method")
	public void testUpdate() {
		System.out.println("Hello-Update");
	}
	
	@Test
	public void testDelete() {
		System.out.println("Hello-Delete");
	}
	
	@RepeatedTest(value = 3)
	public void testMultiple(TestInfo info) {
		//System.out.println("Hello"+ info.getTestMethod());
		System.out.println("Hello"+info.getDisplayName());
	}
}
