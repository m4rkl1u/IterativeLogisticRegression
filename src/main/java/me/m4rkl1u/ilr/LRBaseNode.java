package me.m4rkl1u.ilr;

import org.apache.hadoop.conf.Configuration;

public abstract class LRBaseNode {
	
	Configuration c = null;
	
	private int numInput;
	private int numIteration;
	
	
	
	public int getNumInput() {
		return numInput;
	}
	public void setNumInput(int numInput) {
		this.numInput = numInput;
	}
	public int getNumIteration() {
		return numIteration;
	}
	public void setNumIteration(int numIteration) {
		this.numIteration = numIteration;
	}
	
}
