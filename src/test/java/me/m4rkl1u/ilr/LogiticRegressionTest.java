package me.m4rkl1u.ilr;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import me.m4rkl1u.ilr.container.LRData;
import me.m4rkl1u.ilr.core.ParallelLogisticRegression;
import me.m4rkl1u.ilr.records.Parser;

import org.junit.Test;

public class LogiticRegressionTest {

	@Test
	public void test() {
		ParallelLogisticRegression plr = new ParallelLogisticRegression(2, 0);
		try {
			BufferedReader in = new BufferedReader(new FileReader("src/main/resources/data.txt"));
			Parser parser = new Parser("," , 2);
			List<LRData> data = parser.processReader(in);
			int inter = (int)(data.size() * 0.8);
			List<LRData> trainData = data.subList(0, inter);
			List<LRData> validData = data.subList(inter+1, data.size() - 1);
			in.close();
			
			plr.reset(trainData.get(0).getInput().length);
			
			for(int i = 0; i < 500; i ++){
				plr.iteration(trainData);
				System.out.println("The Loss func:" + plr.getLoss() + " and the valid Loss:" + plr.getValidateLoss(validData));
			}
		} catch (IOException e){
			e.printStackTrace();
		}
	}
}
