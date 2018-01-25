package com.bsit.common.utils;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		// 创建12个字节的字节缓冲区
		ByteBuffer bb = ByteBuffer.wrap(new byte[12]);
		System.out.println(Arrays.toString("abdcef".getBytes()));
		
		// 存入字符串
		bb.asCharBuffer().put("abdcef");
		System.out.println(Arrays.toString(bb.array()));

		// 反转缓冲区
		bb.rewind();
		// 设置字节存储次序
		bb.order(ByteOrder.BIG_ENDIAN);
		bb.asCharBuffer().put("abcdef");
		System.out.println(Arrays.toString(bb.array()));

		// 反转缓冲区
		bb.rewind();
		// 设置字节存储次序
		bb.order(ByteOrder.LITTLE_ENDIAN);
		bb.asCharBuffer().put("abcdef");
		System.out.println(Arrays.toString(bb.array()));
		
		
		ByteBuffer buffer = ByteBuffer.allocate(4);
		buffer.rewind();
		buffer.order(ByteOrder.LITTLE_ENDIAN);
		buffer.asIntBuffer().put(0x424c0000);	//0x424c0000  0x00004c42
		System.out.println(Arrays.toString(buffer.array()));
	}

}
