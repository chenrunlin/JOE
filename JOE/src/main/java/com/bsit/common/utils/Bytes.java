package com.bsit.common.utils;

import java.util.Arrays;
import java.util.List;

public class Bytes {
	
	private final static byte[] hex = "0123456789ABCDEF".getBytes();
	
	private final static String[] binaryArray = { 
		"0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111", 
		"1000", "1001", "1010", "1011", "1100", "1101", "1110", "1111"};
	
	private static int parse(char c) {  
        if (c >= 'a')  
            return (c - 'a' + 10) & 0x0f;  
        if (c >= 'A')  
            return (c - 'A' + 10) & 0x0f;  
        return (c - '0') & 0x0f;  
    } 
	
	/**
	 * 
	 * @param target
	 * @param ch
	 * @param iLen
	 * @param isLeft
	 * @return 指定字符左或右补齐字符串
	 */
	public static String getFixStr(String target, char ch, int iLen, boolean isLeft) {
		int perlen = target.length();
		if (iLen < perlen) {
			return target.substring(perlen - iLen, perlen);
		}
		for (int i = 0; i < iLen - perlen; i++) {
			if (isLeft) {
				target = ch + target;
			} else {
				target = target + ch;
			}
		}
		return target.toUpperCase();
	}
	
	/**
	 * @param i
	 * @return 整数变成十六进制字符串,并自动补齐偶数个字符
	 */
	public static String Integer2HexString(int i, int length) {
		String hex = Integer.toHexString(i);
		if (hex.length() % 2 > 0) {
			hex = '0' + hex;
		}
		return getFixStr(hex, '0', length, true);
	}
	
	// 从字节数组到十六进制字符串转换  
    public static String Bytes2HexString(byte[] b) {  
        byte[] buff = new byte[2 * b.length];  
        for (int i = 0; i < b.length; i++) {  
            buff[2 * i] = hex[(b[i] >> 4) & 0x0f];  
            buff[2 * i + 1] = hex[b[i] & 0x0f];  
        }  
        return new String(buff);  
    }  
    
    // 从十六进制字符串到字节数组转换  
    public static byte[] HexString2Bytes(String hexstr) {  
        byte[] b = new byte[hexstr.length() / 2];  
        int j = 0;  
        for (int i = 0; i < b.length; i++) {  
            char c0 = hexstr.charAt(j++);  
            char c1 = hexstr.charAt(j++);  
            b[i] = (byte) ((parse(c0) << 4) | parse(c1));  
        }  
        return b;  
    }  
    
    //字符串转换成十六进制字符串 
    public static String String2HexString(String str) {  
        char[] chars = "0123456789ABCDEF".toCharArray();  
        StringBuilder sb = new StringBuilder("");  
        byte[] bs = str.getBytes();  
        int bit;  
        for (int i = 0; i < bs.length; i++) {  
            bit = (bs[i] & 0x0f0) >> 4;  
            sb.append(chars[bit]);  
            bit = bs[i] & 0x0f;  
            sb.append(chars[bit]);  
        }  
        return sb.toString();  
    }  
    
    public static byte[] String2HexByte(String str) {
    	return HexString2Bytes(String2HexString(str));
    }
    
    //十六进制字符串转换字符串 
    public static String HexString2String(String hexStr) {  
        String str = "0123456789ABCDEF";  
        char[] hexs = hexStr.toCharArray();  
        byte[] bytes = new byte[hexStr.length() / 2];  
        int n;  
        for (int i = 0; i < bytes.length; i++) {  
            n = str.indexOf(hexs[2 * i]) * 16;  
            n += str.indexOf(hexs[2 * i + 1]);  
            bytes[i] = (byte) (n & 0xff);  
        }  
        return new String(bytes);  
    } 
    
    //位图信息（字节码）解析成二进制字符串
  	@SuppressWarnings("unused")
	private static String bytes2BinaryStr(byte[] bArray) {
  		String outStr = "";
  		int pos = 0;
  		for (byte b : bArray) {
  			// 高四位
  			pos = (b & 0xF0) >> 4;
  			outStr += binaryArray[pos];
  			// 低四位
  			pos = b & 0x0F;
  			outStr += binaryArray[pos];
  		}
  		return outStr;
  	}
  	
  	/** 
	* @功能: 10进制串转为BCD码 
	* @参数: 10进制串 
	* @结果: BCD码 
	*/
	public static byte[] str2Bcd(String asc) {
		int len = asc.length();
		int mod = len % 2;
		if (mod != 0) {
			asc = "0" + asc;
			len = asc.length();
		}
		byte abt[] = new byte[len];
		if (len >= 2) {
			len = len / 2;
		}
		byte bbt[] = new byte[len];
		abt = asc.getBytes();
		int j, k;
		for (int p = 0; p < asc.length() / 2; p++) {
			if ((abt[2 * p] >= '0') && (abt[2 * p] <= '9')) {
				j = abt[2 * p] - '0';
			} else if ((abt[2 * p] >= 'a') && (abt[2 * p] <= 'z')) {
				j = abt[2 * p] - 'a' + 0x0a;
			} else {
				j = abt[2 * p] - 'A' + 0x0a;
			}
			if ((abt[2 * p + 1] >= '0') && (abt[2 * p + 1] <= '9')) {
				k = abt[2 * p + 1] - '0';
			} else if ((abt[2 * p + 1] >= 'a') && (abt[2 * p + 1] <= 'z')) {
				k = abt[2 * p + 1] - 'a' + 0x0a;
			} else {
				k = abt[2 * p + 1] - 'A' + 0x0a;
			}
			int a = (j << 4) + k;
			byte b = (byte) a;
			bbt[p] = b;
		}
		return bbt;
	}
  	
  	//单个字节压缩成BCD
    public static byte ASCII_To_BCD(byte asc)
    {
        byte bcd;
        
        if ((asc >= '0') && (asc <= '9'))
            bcd = (byte)(asc - '0');
        else if ((asc >= 'A') && (asc <= 'F'))
            bcd = (byte)(asc - 'A' + 10);
        else if ((asc >= 'a') && (asc <= 'f'))
            bcd = (byte)(asc - 'a' + 10);
        else
            bcd = (byte)(asc - 48);
        return bcd;
    }
    
    //压缩成BCD码
    public static byte[] ASCII_To_BCD(byte[] ascii)
    {
    	int asc_len = ascii.length;
        byte[] bcd = new byte[asc_len / 2];
        int j = 0;
        for (int i = 0; i < (asc_len + 1) / 2; i++)
        {
            bcd[i] = ASCII_To_BCD(ascii[j++]);
            bcd[i] = (byte)(((j >= asc_len) ? 0x00 : ASCII_To_BCD(ascii[j++])) + (bcd[i] << 4));
        }
        return bcd;
    }
    
    //BCD码解压缩成string
    public static String BCD_To_Str(byte[] bytes)
    {
        char temp[] = new char[bytes.length * 2], val;
        
        for (int i = 0; i < bytes.length; i++)
        {
            val = (char)(((bytes[i] & 0xf0) >> 4) & 0x0f);
            temp[i * 2] = (char)(val > 9 ? val + 'A' - 10 : val + '0');
            
            val = (char)(bytes[i] & 0x0f);
            temp[i * 2 + 1] = (char)(val > 9 ? val + 'A' - 10 : val + '0');
        }
        return new String(temp);
    }
    
    public static byte[] sumList(List<byte[]> list) {
		int length = 0;
		for (byte[] b : list) {
			length += b.length;
		}
		byte[] bb = new byte[length];
		int index = 0;
		for (byte[] b : list) {
			System.arraycopy(b, 0, bb, index, b.length);
			index += b.length;
		}
		return bb;
	}
    
    //byte 与 int 的相互转换  
    public static byte intToByte(int x) {  
        return (byte) x;  
    }  
      
    public static int byteToInt(byte b) {  
        //Java 总是把 byte 当做有符处理；我们可以通过将其和 0xFF 进行二进制与得到它的无符值  
        return b & 0xFF;  
    }  
    
    //byte 数组与 int 的相互转换  
    public static int byteArrayToInt(byte[] b) {  
        return   b[3] & 0xFF |  
                (b[2] & 0xFF) << 8 |  
                (b[1] & 0xFF) << 16 |  
                (b[0] & 0xFF) << 24;  
    }  
  
    public static byte[] intToByteArray(int a) {  
        return new byte[] {  
            (byte) ((a >> 24) & 0xFF),  
            (byte) ((a >> 16) & 0xFF),     
            (byte) ((a >> 8) & 0xFF),     
            (byte) (a & 0xFF)  
        };  
    }  
    
    public static void main(String[] args) throws Exception {  
    	testBytes();
    }  
    
    public static void testBytes() throws Exception{
    	System.out.println("0".getBytes());
    	String source = "88888888";
    	System.out.println("字符串：" + source);
    	
    	byte[] bt = source.getBytes();
    	System.out.println("字符串的字节数组：" + Arrays.toString(bt));
    	
        //字节数组转16进制字符串
        String hexString = Bytes2HexString(bt);
        System.out.println("字节数组转16进制字符串：" + hexString);  
        
        //字符串转16进制字符串
        String hexStr = String2HexString("00000379");
        System.out.println("字符串转16进制字符串：" + hexStr);
        
        //16进制字符串转字符串
        String str = HexString2String("3838383838383838");
        System.out.println("16进制字符串转字符串：" + str);
        
        //16进制字符串转字节数组
        byte[] b = HexString2Bytes(hexString);
        System.out.println("16进制字符串转字节数组：" + Arrays.toString(b));
        
        System.out.println(Arrays.toString(HexString2Bytes("2660000006F5E0F00000")));
        
        System.out.println(Bytes2HexString(new byte[] {127, 66, -96, 67, 0, 0, 0, 0, 65, 0, 0, 5, 0, 0, 0, 0, 0, 0, 5, -16, -16, -32, 0, 127}));
        System.out.println("7F42A0420000000052000055000000000000000000350100000004370020032363000000000000000000000000000000000000008698266026602660000007F5E0F0000000004200000050260100000120170627150131007B971F00039950000400007B3C945D7F".length() / 2);
        System.out.println(byteArrayToInt(HexString2Bytes("0000017A")));
        
        System.out.println(Integer.toHexString(100));
        System.out.println(Bytes2HexString("100".getBytes()));
        
        System.out.println(Bytes2HexString(new byte[] {0, 0, 0, -121}));
        System.out.println(Bytes2HexString(new byte[] {0, 0, 0, -121}));
        
        System.out.println(Bytes2HexString(new byte[] {(byte) 0xFA}));
        System.out.println(Bytes2HexString(new byte[] {(byte) 0x76}));
        
    }
    
}
