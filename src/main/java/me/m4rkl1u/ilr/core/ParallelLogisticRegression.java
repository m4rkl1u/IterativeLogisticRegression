package me.m4rkl1u.ilr.core;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import me.m4rkl1u.ilr.container.LRData;

public class ParallelLogisticRegression {
	
	private Logger log = LoggerFactory.getLogger(ParallelLogisticRegression.class);

	private double   loss;
	private double[] weights;
	
	private double learningRate;	  //alpha 
	private double lambda;           //regulartion
	private Random randomizer ; 

	public ParallelLogisticRegression(double learningRate, double lambda){
		this.learningRate = learningRate;
		this.lambda       = lambda;
		this.randomizer   = new Random(new Date().getTime());
	}
	
	/**
	 * Set up the weights with number of feature
	 * 
	 * @param numFeature
	 */
	public void reset(int numFeature){
		weights = new double[numFeature + 1];
		
		for(int i = 0 ; i < numFeature + 1; i ++){
			weights[i] = randomizer.nextDouble();
		}
	}

	public double[] getWeight(){
		return weights;
	}
	public double getLoss(){
		return loss;
	}
	
	public void setWeight(double[] globalWeights){
		if(globalWeights.length != weights.length){
			throw new RuntimeException("ERROR: the global weights size is not equal to the local weight size");
		}
		
		for (int i = 0 ; i < weights.length; i++ ){
			weights[i] = globalWeights[i];
		}
	}
	
	public void iteration(List<LRData> trainData){
		
		//loss 
		loss = 0;
		for(int i = 0 ; i < trainData.size(); i ++ ){
			LRData data = trainData.get(i);
			double hx = data.getHypothesis(weights);
			if(data.getTarget() == 0) {
				loss +=  (1 - data.getTarget()) * (-Math.log(1 - hx));
			} else {
				loss +=  data.getTarget() * (-Math.log(hx));
			}
		}
		
		loss = loss / trainData.size();
		
		double sumWeight2 = 0.0;
		for(int i = 1 ; i < weights.length; i++){
			sumWeight2 += weights[i] * weights[i];
		}
		
		loss = loss + sumWeight2 * lambda / (2 * trainData.size());
		
		//calc the theta
		double[] deviation= new double[weights.length];
		for(int i = 0 ; i < weights.length; i ++){	
			deviation[i] = 0.0;  
			for(int j = 0 ; j < trainData.size() ; j ++){
				LRData data = trainData.get(j);
				if (i > 0){
					deviation[i] += data.getDistance(this.weights) * data.getInput()[i - 1];
				}
				else { 
					deviation[i] += data.getDistance(this.weights) * 1;
				}
			}
			
			deviation[i] = deviation[i] / trainData.size();
			
			if(i > 0){
				deviation[i] += lambda * this.weights[i] / trainData.size();
			}
		}
		//update weighs;
		for(int i = 0 ; i <weights.length; i ++){
			weights[i] = weights[i] - learningRate * deviation[i]; 
		}
	}
	
	public double getValidateLoss(List<LRData> validData){
		double rt = 0.0;
		for(int i = 0 ; i < validData.size(); i ++ ){
			LRData data = validData.get(i);
			double hx = data.getHypothesis(weights);	
			rt += (-data.getTarget() * Math.log(hx) - (1 - data.getTarget()) * Math.log(1 - hx));
		}
		
		rt = rt / validData.size();
		
		double sumWeight2 = 0.0;
		for(int i = 1 ; i < weights.length; i++){
			sumWeight2 += weights[i] * weights[i];
		}
		
		rt = rt + sumWeight2 * lambda / (2 * validData.size());
		
		return rt;
	}
}
