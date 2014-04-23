package com.interface21.sample.multiplecontexts.service;

public class SampleServiceImpl implements SampleService {
	private String simpleProp;
	
	public SampleServiceImpl() {
		System.out.println("\n\n+++++++++++++++ inside SampleServiceImpl constructor ++++++++++++++++++++++\n\n");
	}
	
	public String sayHello(String from) {
		return "Hello from " + from;
	}

	public String getSimpleProp() {
		return simpleProp;
	}

	public void setSimpleProp(String simpleProp) {
		this.simpleProp = simpleProp;
	}
	
	

}
