package me.m4rkl1u.ilr.container;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.List;

import org.apache.hadoop.io.Writable;

public class LRParams  implements Writable {
	public List<LRData> data;
	public double[] weights;
	@Override
	public void write(DataOutput out) throws IOException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void readFields(DataInput in) throws IOException {
		// TODO Auto-generated method stub
		
	}
}
