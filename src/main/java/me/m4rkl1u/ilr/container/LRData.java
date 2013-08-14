package me.m4rkl1u.ilr.container;

public class LRData {
	
	private int target; 	 //1 or 0
	
	private double[] input;  // input data, size = n
		
	public double getDistance(double[] weight){		
		double hx = this.getHypothesis(weight);
		return (hx - target);
	}
	
	public double getPowDistance(double[] weight) {
		double rt = this.getDistance(weight);
		return rt * rt;
	}
	
	public double getHypothesis(double[] weight){
		double rt = 0.;
		
		if(weight.length - 1 != input.length) {
			throw new RuntimeException("ERROR the input size is not equal to weight size");
		}
		
		rt = 1 * weight[0];
		
		for (int i = 1 ; i < weight.length; i ++) {
			rt += input[i - 1] * weight[i];
		}
		
		return (1 / (1 + Math.exp(-rt)));
	}
	
	public double[] getInput() {
		return input;
	}
	public void setInput(double[] input) {
		this.input = input;
	}
	
	public int getTarget() {
		return target;
	}

	public void setTarget(int target) {
		this.target = target;
	}
}
