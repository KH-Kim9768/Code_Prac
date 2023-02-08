package kr.ac.shingu.cs.network;

import java.nio.ByteBuffer;

public class ByteBufferTest {
	public static void main(String[] args) {
		ByteBuffer bb = ByteBuffer.allocate(5);
		System.out.println(bb.capacity());
		System.out.println(bb.limit());
		System.out.println(bb.position());
		
		byte c = 7;
		bb.put(c);
		c = 9;
		bb.put(c);
		System.out.println(bb.capacity());
		System.out.println(bb.limit());
		System.out.println(bb.position());
		
		bb.flip();//limit -> 2, position -> 0
		System.out.println(bb.capacity());
		System.out.println(bb.limit());
		System.out.println(bb.position());
		System.out.println(bb.get());
		System.out.println(bb.position());
	}
}
