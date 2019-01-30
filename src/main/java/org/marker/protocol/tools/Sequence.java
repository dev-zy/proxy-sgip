package org.marker.protocol.tools;

import java.util.concurrent.atomic.AtomicLong;

public class Sequence {
	private static AtomicLong sequence = new AtomicLong(0);
	private static long count = 1;
	public static long next(){
		if(count >= Integer.MAX_VALUE){
			count = 1;
		}
		return count++;
	}
	
	public static long getId() {
		long sequenceId = (sequence.getAndIncrement() % 0xffff)+1;
		return sequenceId;
	}
	
	public static long getId(final AtomicLong atomic) {
		long sequenceId = ((atomic!=null?atomic:sequence).getAndIncrement() % 0xffff)+1;
		return sequenceId;
	}
	
	public static void main(String[] args) {
		while(true){
			System.out.println(Sequence.next());
		}
	}
}
