package me.m4rkl1u.ilr;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Collection;

import org.apache.hadoop.conf.Configuration;

import me.m4rkl1u.ilr.container.LRParamUpdatable;

import com.cloudera.iterativereduce.ComputableMaster;

public class LRMasterNode extends LRBaseNode implements ComputableMaster<LRParamUpdatable>{

	private Configuration conf;
	private int maxInteration;
	private int[] targetPos;
	private int[] targetNeg;
	private int targetCol;

	@Override
	public void setup(Configuration c) {
	    conf = c;
	    maxInteration = conf.getInt("app.iteration.count", 1);
	    targetCol     = conf.getInt("app.target.column", 0);
	    targetNeg     = conf.getInts("app.target.negative");
	    targetPos     = conf.getInts("app.target.positive");
	}

	@Override
	public void complete(DataOutputStream out) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public LRParamUpdatable compute(Collection<LRParamUpdatable> workerUpdates,
			Collection<LRParamUpdatable> masterUpdates) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LRParamUpdatable getResults() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
