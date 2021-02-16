package com.bobpaulin.graal.component.impl;

import com.bobpaulin.graal.component.Something;

public class DoSomethingElse implements Something {

	@Override
	public void something() {
		System.out.println("Something Else");

	}

}
