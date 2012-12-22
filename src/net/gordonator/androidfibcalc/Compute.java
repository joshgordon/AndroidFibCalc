package net.gordonator.androidfibcalc;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;

public class Compute implements Runnable {

	int fibLen;
	ArrayList<String> returnSpace; 
	
	public Compute(int fibLen, ArrayList<String> returnSpace)
	{ 
		this.fibLen = fibLen; 
		this.returnSpace = returnSpace; 
		
	}
	
	public ArrayList<String> getFibSequence(int seqLen)
	{ 
		ArrayList<BigInteger> fib = new ArrayList<BigInteger>(seqLen);
		fib.add(new BigInteger("1")); 
		fib.add(new BigInteger("1")); 
		
		while(fib.size() <= seqLen)
		{ 
			fib.add(fib.get(fib.size()-1).add(fib.get(fib.size()-2))); 
		}
		
		ArrayList<String> fibStrings = new ArrayList<String>(seqLen); 
		
		Iterator<BigInteger> itr = fib.iterator(); 
		
		while (itr.hasNext())
		{ 
			fibStrings.add(itr.next().toString()); 
		}

		return fibStrings; 
	}

	
	@Override
	public void run() {
		returnSpace = getFibSequence(fibLen); 
		
		// TODO Auto-generated method stub

	}

}
