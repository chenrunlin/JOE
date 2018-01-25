package com.bsit.common.properties;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesInfo {
	
	private String serverIp;	//服务端IP
	
	private int serverPort;		//服务器端口
	
	public PropertiesInfo() throws FileNotFoundException, IOException  {
		Properties pps = new Properties();
		pps.load(PropertiesInfo.class.getClassLoader().getResourceAsStream("param.properties"));
		this.serverIp = pps.getProperty("SERVER_IP");
		this.serverPort = Integer.valueOf(pps.getProperty("20104"));
	}
	
	public String getServerIp() {
		return serverIp;
	}
	public void setServerIp(String serverIp) {
		this.serverIp = serverIp;
	}
	public int getServerPort() {
		return serverPort;
	}
	public void setServerPort(int serverPort) {
		this.serverPort = serverPort;
	}

}
