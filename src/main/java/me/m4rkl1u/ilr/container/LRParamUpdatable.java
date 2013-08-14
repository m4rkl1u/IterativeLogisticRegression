package me.m4rkl1u.ilr.container;

import java.nio.ByteBuffer;

import com.cloudera.iterativereduce.Updateable;

public class LRParamUpdatable implements Updateable<LRParams>{
	
	private LRParams params;


	@Override
	public ByteBuffer toBytes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void fromBytes(ByteBuffer b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromString(String s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public LRParams get() {
		return params;
	}

	@Override
	public void set(LRParams t) {
		this.params = t;
	}


}
