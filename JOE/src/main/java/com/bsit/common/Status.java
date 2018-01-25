package com.bsit.common;

public enum Status {
	
	DATA_INIT("0000", "初始数据"),
	
	DATA_ALREADY_EXIST("1011", "正式数据已存在"), 
	
	//验证数据
	PSAM_NOT_REGISTER("2001", "psam卡号未注册"), DATA_FLASH("2002", "闪卡数据(Tac全F)"), DATA_TEST("2003", "测试数据"),
	NO_EXIST_CITY_BY_PSAM("2004", "未能获取psam对应城市"), NO_EXIST_FIRM_BY_PSAM("2005", "未能获取psam对应分公司"),
	NO_EXIST_LINE_BY_PSAM("2006", "未能获取psam对应线路"), NO_EXIST_BUS_BY_PSAM("2007", "未能获取psam对应车辆"),
	
	//上传结果
	DATA_UPLOAD_OK("UPF0", "数据上传正确"),  DATA_UPLOAD_REPEAT("UPF1", "数据上传重复"), DATA_UPLOAD_EXCEPTION("UPF2", "数据上传解析异常"), 
	
	//清算结果
	DATA_CLEAR_CODE_OK("CRFF", "已清分"),
	DATA_CLEAR_OK("CRF0", "验证通过,未清分"), DATA_NOT_VERIFY("CRFA", "数据还未验证"),
	DATA_CLEAR_ERROR("CRF1", "验证失败"), DATA_CLEAR_ACCOUNT("CRF2", "无此卡账户"), DATA_CLEAR_CARD_STATUS("CRF3", "卡状态异常"),
	DATA_CLEAR_FORMAT_ERROR("CRF4", "交易记录格式错误"), DATA_CLEAR_UNIT_NO("CRF5", "结算单元不存在"), DATA_CLEAR_ACCOUNT_BALANCE("CRF6", "账户余额不足"),
	DATA_CLEAR_TIME_OUT("CRF7", "此卡已超时"), DATA_CLEAR_TERM_EXCEPTION("CRF8", "终端号异常"), DATA_CLEAR_BLACK_LIST("CRF9", "商户未及时下载黑名单"), 
	
	DATA_CLEAR_CODE_01("CR01", "无效的交易类型"), DATA_CLEAR_CODE_02("CR02", "交易重复"), DATA_CLEAR_CODE_04("CR04", "tac或tac校验不正确"), 
	DATA_CLEAR_CODE_05("CR05", "交易逾期"), DATA_CLEAR_CODE_06("CR06", "无效发卡方"), DATA_CLEAR_CODE_07("CR07", "找不到原交易记录"), 
	DATA_CLEAR_CODE_08("CR08", "与原交易信息不相符"), DATA_CLEAR_CODE_09("CR09", "黑名单状态错"), DATA_CLEAR_CODE_10("CR10", "交易发卡机构和白名单登记不一致"), 
	DATA_CLEAR_CODE_11("CR11", "手续费规则未配置"), DATA_CLEAR_CODE_12("CR12", "收单机构状态无效"), DATA_CLEAR_CODE_13("CR13", "非白名单卡bin"), 
	DATA_CLEAR_CODE_14("CR14", "非有效地收单机构"), DATA_CLEAR_CODE_16("CR16", "TLV数据错"), DATA_CLEAR_CODE_17("CR17", "无效的可疑账申诉机构"), 
	DATA_CLEAR_CODE_18("CR18", "不支持的申诉/调整类型"), DATA_CLEAR_CODE_19("CR19", "接收方拒绝"), DATA_CLEAR_CODE_22("CR22", "段3交易状态有误"), 
	DATA_CLEAR_CODE_24("CR24", "发卡方拒付"), DATA_CLEAR_CODE_25("CR25", "尚有未处理结束的差错，不能提起新的差错"), DATA_CLEAR_CODE_26("CR26", "交易金额异常"), 
	DATA_CLEAR_CODE_27("CR27", "调整申诉接收方待定"), DATA_CLEAR_CODE_29("CR29", "机构类型和申诉类型不匹配"), DATA_CLEAR_CODE_30("CR30", "超过申述期限"), 
	DATA_CLEAR_CODE_31("CR31", "超过应答期限"), DATA_CLEAR_CODE_32("CR32", "不符合调整条件"), DATA_CLEAR_CODE_33("CR33", "不允许有其他差错或前一差错类型不符合要求"), 
	DATA_CLEAR_CODE_34("CR34", "差错金额异常"), DATA_CLEAR_CODE_36("CR36", "CM记录与原交易信息不符"), DATA_CLEAR_CODE_37("CR37", "非补票交易的段0受理机构代码与段3不一致"), 
	DATA_CLEAR_CODE_38("CR38", "受理机构代码必须等于收单机构或其子机构"), DATA_CLEAR_CODE_39("CR39", "段0发卡机构与段2不一致"), DATA_CLEAR_CODE_40("CR40", "确认查询回复02找不到贷记调整交易"), 
	DATA_CLEAR_CODE_41("CR41", "无效的收单机构"), DATA_CLEAR_CODE_50("CR50", "不能重复退单"), DATA_CLEAR_CODE_51("CR51", "找不到回复03确认查询"), 
	DATA_CLEAR_CODE_52("CR52", "已有其他差错，不能发起异常交易验证"), DATA_CLEAR_CODE_55("CR55", "例外协商-贷记调整，找不到贷记调整"), DATA_CLEAR_CODE_60("CR60", "例外协商-退单，找不到退单"),
	DATA_CLEAR_CODE_65("CR65", "例外协商，差错未解决-找不到原来的差错"), DATA_CLEAR_CODE_70("CR70", "例外长款，找不到例外协商"), DATA_CLEAR_CODE_75("CR75", "该差错未到发起时限"),
	DATA_CLEAR_CODE_76("CR76", "卡bin已禁用");
	
	private String code;
	
	private String message;

	private Status(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public static String getErrorInfoByCode(String code) {
		for (Status status : Status.values()) {
			if (code.equals(status.getCode())) {
				return status.getMessage();
			}
		}
		return "未定义";
	}
	
	public static void main(String[] args) {
		System.out.println(getErrorInfoByCode("CRF0"));
	}

}
