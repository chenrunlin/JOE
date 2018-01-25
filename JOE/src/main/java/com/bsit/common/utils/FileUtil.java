package com.bsit.common.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class FileUtil {
	
	//判断文件是否存在，不存在则创建
	public static void createFileIfNotExists(String filePath){
		File file = new File(filePath);
		if (file.exists()) {
			file.delete();
		}
		if (!file.exists()) {
			try {    
		     //   try {
		        	file.createNewFile(); 
			/*		Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} */  
		    } catch (IOException e) {    
		        e.printStackTrace();    
			}   
		}  
	}
	
	//判断文件目录是否存在，不存在则创建
	public static void createDirIfNotExists(String fileDir){
		File file = new File(fileDir);
		if(!file.exists() && !file.isDirectory()) {
			file.mkdirs();// 创建多级目录
		}
	}
	
	/**
	 * 从文件指定字节处读取1000byte的字节，返回
	 * @param fileFullPath
	 * @param position
	 * @return
	 */
	@SuppressWarnings("resource")
	public static byte[] readFile(String fileFullPath, int position) {
		byte[] bytes = new byte[1000];
		RandomAccessFile randomFile;
		try {
			randomFile = new RandomAccessFile(fileFullPath, "r");
			// 将读文件的开始位置移到beginIndex位置。
			randomFile.seek(position);
			int byteRead = 0;
			if ((byteRead = randomFile.read(bytes)) != -1) {
				byte[] bt = new byte[byteRead];
				System.arraycopy(bytes, 0, bt, 0, byteRead);
				return bt;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 写字节到文件，提前会创建文件
	 * @param bt
	 * @param fileName
	 * @return
	 */
    public static boolean writeFileData(byte[] bt, String filePath, String fileName) {
		RandomAccessFile randomWriteFile = null;
		try {
			FileUtil.createDirIfNotExists(filePath);
			FileUtil.createFileIfNotExists(filePath + fileName);
			randomWriteFile = new RandomAccessFile(filePath + fileName, "rw");
			long fileLength = randomWriteFile.length();
			randomWriteFile.seek(fileLength);
			randomWriteFile.write(bt);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				randomWriteFile.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return true;
	}
    
}
