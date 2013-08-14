package me.m4rkl1u.ilr;

import java.util.List;

import me.m4rkl1u.ilr.container.LRParamUpdatable;
import me.m4rkl1u.ilr.core.ParallelLogisticRegression;

import org.apache.hadoop.conf.Configuration;

import com.cloudera.iterativereduce.ComputableWorker;
import com.cloudera.iterativereduce.io.RecordParser;

public class LRWorkerNode extends LRBaseNode implements ComputableWorker<LRParamUpdatable>{

	private ParallelLogisticRegression plr;
	private double lambda;
	private double alpha;
	private int numFeature;
	private Configuration conf;
	
	@Override
	public void setup(Configuration c) {
		// TODO Auto-generated method stub
		this.conf = c;
		
		plr = new ParallelLogisticRegression(alpha, lambda);
		
		plr.reset(numFeature);
	}

	@Override
	public LRParamUpdatable compute(List<LRParamUpdatable> records) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LRParamUpdatable compute() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setRecordParser(RecordParser r) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public LRParamUpdatable getResults() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(LRParamUpdatable t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean IncrementIteration() {
		// TODO Auto-generated method stub
		return false;
	}

	

}
