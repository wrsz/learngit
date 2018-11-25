package com.core.util.back;

/**
 * 应用程序上下文配置
 * @author timo
 */
public class ReTurnAppConfig {
	/** 分页中一页内数据条数 ： 默认值(10条) */
	public static final int PAGE_SIZE_DEFAULT = 10;
	/** 请求返回的数据中"错误信息"的key */
	public static final String KEY_MSG = "codeTxt";
	/** 请求返回的数据中"数据信息"的key */
	public static final String KEY_DATA = "data";
	public static final String KEY_ROWS = "rows";
	/** 请求返回的数据中"页码"的key */
	public static final String KEY_PAGE = "page";
	/** 请求返回的数据中"下一页"的key */
	public static final String KEY_NEXT = "next";
	/** 请求返回的数据中"数据总条数"的key */
	public static final String KEY_TOTAL = "total";
	/** 请求返回的数据中"数据总页数"的key */
	public static final String KEY_TOTAL_PGE = "totalPage";
	/** 请求返回的数据中"每页显示数"的key */
	public static final String KEY_TOTAL_PGESZIE = "pageSize";
	/** 请求返回的数据中"标识"的key */ 
	public static final String KEY_FLAG = "reCode";
	/** 排序类型：正序排列 */
	public static final String SORT_TYPE_ASC = "asc";
	/** 排序类型：倒叙排列 */
	public static final String SORT_TYPE_DESC = "desc";
	
}
