package com.core.util.back;

/**
 * 返回状态定义
 * @author yanhan
 *
 */
public enum CodeEnum {
	// 成功状态
	SUCCESS("200"),
	// 系统内部错误
	ERROR("500"),
	// 不支持GET请求
	NotSupportMethod("405"),
	// 参数值不合法
	InvalidParameter("400"),
	//登录时为完成资料
	NOPERFECTDATA("901"),
	//未实名认证
	NO_REAL_NAME_AUTH("905"),
	//失败状态
	Failed("900");

	private final String value;

	private CodeEnum(final String value) {
		this.value = value;
	}

	public String value() {
		return this.value;
	}
}
