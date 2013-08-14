package me.m4rkl1u.ilr.records;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.sun.tools.javac.util.Log;

import me.m4rkl1u.ilr.container.LRData;

public class Parser {

	private String delimeter = ",";
	private int    targetPos = 2;     //start from 0
	
	public Parser(String delimeter, int targetPos){
		this.delimeter = delimeter;
		this.targetPos = targetPos;
	}
	
	public LRData processLine(String s){
		LRData data = new LRData();
		
		String[] inputStr = s.split(delimeter);
		
		double[] input = new double[inputStr.length - 1];
		
		for(int i = 0, j = 0; i < inputStr.length; i ++){
			if(i == targetPos){
				data.setTarget(Integer.parseInt(inputStr[i]));
			}else {
				input[j] = Double.parseDouble(inputStr[i]);
				j ++;
			}
		}
		
		data.setInput(input);
		
		return data;
	}
	
	public List<LRData> processReader(BufferedReader reader) throws IOException{
		String s = "";
		List<LRData> data = new ArrayList<LRData>();
		while((s = reader.readLine()) !=  null){
			data.add(this.processLine(s));
		}
		
		return data;
	}


	public void setDelimeter(String delimeter) {
		this.delimeter = delimeter;
	}

	public void setTargetPos(int targetPos) {
		this.targetPos = targetPos;
	} 

}
