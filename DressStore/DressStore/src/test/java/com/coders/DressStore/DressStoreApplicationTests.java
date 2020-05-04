package com.coders.DressStore;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.coders.DressStore.Service.ServiceDao;

@SpringBootTest
class DressStoreApplicationTests {

	@Autowired
	ServiceDao sd;
	
	@Test
	void contextLoads() {
		
		for(int i=0; i<sd.getProductsList().size(); i++) {
		System.out.println(sd.getProductsList().get(i).getName());
		for(int j=0; j<sd.getProductsList().get(i).getProductImage().size(); j++) {
		System.out.println(sd.getProductsList().get(i).getProductImage().get(j).getName());
		}
		}
	}
	
	@Test
	void contextLoads2() {
		
		System.out.println("----->"+sd.getProduct(36).getName());
	}
}
