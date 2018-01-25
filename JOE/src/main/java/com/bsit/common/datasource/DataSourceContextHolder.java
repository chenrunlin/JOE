package com.bsit.common.datasource;

public class DataSourceContextHolder {
	
	private static  final ThreadLocal<String> threadLocal = new ThreadLocal<String>();
	
	/**
	 * 设置数据源
	 *
	 * @param dataSource
	 */
	public static  void setDbType(String dataSource){
		threadLocal.set(dataSource);
	}
	/**
	 * 获取数据源
	 * @return
	 */
	public static  String getDbType(){
		return threadLocal.get();
	}
	/**
	 * 移除数据源
	 */
	public static  void clearDbType(){
		threadLocal.remove();
	}
}
