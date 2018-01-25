package com.bsit.common.pack;

public enum ErrorCodeEnum {
	
	E000("E000", "正确，正常，有效"),
	
	E001("E001", "结算单元不存在"), E002("E002", "结算单元未启用"),
	
	E004("E004", "验证码错误 "), 
	
	E005("E005", "终端机编号不存在 "), E006("E006", "终端机编号未注册 "), E007("E007", "终端机编号已使用 "), 
	
	E008("E008", "会话码错误"),
	
	E009("E009", "访问拒绝（未登录验证）"),
	
	E010("E010", "充值信誉额度不足"), E012("E012", "充值额度超过上限"),
	
	E013("E013", "定额卡，不能充值"),
	
	E014("E014", "POS机充值请求失败"), E015("E015", "POS机充值提交失败"), E016("E016", "POS机充值写卡失败，删除灰记录失败 "),
	E017("E017", "POS机取消充值请求失败 "), E018("E018", "POS机取消充值提交失败"), E019("E019", "POS机取消充值写卡失败，删除灰记录失败"),
	
	E020("E020", "密钥索引不存在"), E021("E021", "计算MAC1失败"), E022("E022", "计算MAC2失败 "), 
	
	E023("E023", "联机账户状态异常"), E024("E024", "联机账户密码错误 "), E025("E025", "联机账户余额不足 "), E026("E026", "联机账户交易失败"),
	
	E027("E027", "非本城市卡"), E028("E028", "此卡已租出"), E029("E029", "无此卡应用类型 "),
	
	E030("E030", "租卡请求失败 "), E031("E031", "租卡提交失败"),
	
	E032("E032", "没有权限"), E033("E033", "有灰记录,请到联机网点程序处理"), 
	
	E034("E034", "员工卡验证失败"), E035("E035", "员工卡未绑定"), 
	
	E036("E036", "提交的冲正数据异常,请重试 "), E037("E037", "未找到充值灰记录 "), E038("E038", "无法进行自动异常冲正,请联系后台管理员进行人工冲正"), 
	
	E040("E040", "登卡金额错误"), E041("E041", "登卡请求失败"), E042("E042", "登卡提交失败"),
	E043("E043", "未找到登卡灰记录数据 "), E044("E044", "登卡冲正失败"), E045("E045", "登卡灰记录无法进行自动异常冲正,请联系后台管理员进行人工冲正"),
	
	E046("E046", "通过结算单元编号获取分中心标志失败 "), 
	
	E047("E047", "该卡有未登卡金额请先登卡"), 
	
	E048("E048", "连接加密机失败"), 
	
	E049("E049", "老年卡年检失败 "), 
	
	E0FF("E0FF", "系统未知异常 ");
	
	//错误代码
	private String errorCode;
	
	//错误信息
	private String errorInfo;
	
	
	private ErrorCodeEnum(String errorCode, String errorInfo) {
		this.errorCode = errorCode;
		this.errorInfo = errorInfo;
	}
	
	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorInfo() {
		return errorInfo;
	}

	public void setErrorInfo(String errorInfo) {
		this.errorInfo = errorInfo;
	}
	
	public static String getErrorInfoByErrorCode(String errorCode){
		for (ErrorCodeEnum error : ErrorCodeEnum.values()) {
			if (error.getErrorCode().equals(errorCode)) {
				return error.getErrorInfo();
			}
		}
		return "未知异常信息";
	}
	
	public static void main(String[] args) {
		System.out.println(getErrorInfoByErrorCode("E008"));
	}

}
