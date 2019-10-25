package com.ust.usttyspringcore.beans;

public class Pen implements Writer {

	@Override
	public void write() {
		System.out.println("Writing by Pen");
	}

}
