package com.core.util.back;


import java.util.HashMap;
import java.util.Map;

/**
 * @Description:  返回给客户端的参数信息
 * @ClassName: ResultJsonFormat
 * @Author: yanhan
 */
public class ResultJsonFormat {

	/** 请求返回的Json中的信息MSG */
	private String msg;
	/** 请求返回数据对象(json || obj) */
	private Object data;
	/** 请求返回数据对象(json || obj) */
	private Object rows;
	/** 是否存在下一页 */
	private Boolean next;
	/** 页码 */
	private Long pageNumber;
	/** 每页显示数 */
	private Long pageSize;
	/** 数据的总条数 */
	private Long totalElements;
	/**总页数**/
	private Long pageTotal;
	/** 是否成功 默认1为成功 */
	private String flag = "200";
	/** 排序时的排序字段及方式*/
	private String orderBy;

	public ResultJsonFormat(String flag) {
		super();
		this.flag = flag;
	}
	/**
	 * 适用于添加、修改、删除
	 * 
	 * @param msg  消息
	 * @param flag 是否成功 true成功 false失败
	 */
	public ResultJsonFormat(String flag,String msg) {
		super();
		this.msg = msg;
		this.flag = flag;
	}

	/**
	 * 只返回数据和标记成功和失败
	 * 
	 * @param data
	 * @param flag
	 */
	public ResultJsonFormat(Object data, String flag) {
		super();
		this.data = data;
		this.rows = data; //用于easyui数据封装
		this.flag = flag;
	}

	/**
	 * 适用于添加、修改、删除
	 * 
	 * @param msg 	消息
	 * @param data 	操作后的返回数据
	 * @param flag  是否成功
	 */
	public ResultJsonFormat(String msg, Object data, String flag) {
		super();
		this.msg = msg;
		this.rows = data; //用于easyui数据封装
		this.data = data;
		this.flag = flag;
	}
	public ResultJsonFormat(String flag,Long pageSize,Long pageNumber,String orderBy) {
		this.flag = flag;
		this.pageSize = pageSize;
		this.pageNumber = pageNumber;
		this.orderBy = orderBy;
	}

	/**
	 * 集合数据
	 * 
	 * @param msg	消息
	 * @param data	数据
	 * @param next	是否有下一页
	 * @param pageNumber	页码
	 * @param totalElements	总条数
	 * @param pageSize 每页条数
	 * @param flag	是否成功
	 */
	public ResultJsonFormat(String msg, Object data, boolean next, Long pageNumber,Long pageSize,
			Long totalElements, String flag) {
		super();
		this.msg = msg;
		this.data = data;
		this.rows=data; //用于easyui数据封装
		this.next = next;
		this.pageNumber = pageNumber;
		this.totalElements = totalElements;
		this.pageTotal= totalElements%pageSize ==0 ? totalElements/pageSize : totalElements/pageSize+1;
		this.flag = flag;
	}
	public ResultJsonFormat(String msg,Object rows, boolean next, Integer pageNumber,Integer pageSize,
			Long totalElements, String flag) {
		super();
		this.msg = msg;
		this.data = rows;
		this.rows=rows; //用于easyui数据封装
		this.next = next;
		this.pageNumber = pageNumber.longValue();
		this.totalElements = totalElements;
		this.pageTotal= totalElements%pageSize ==0 ? totalElements/pageSize : totalElements/pageSize+1;
		this.flag = flag;
	}
	/**
	 * 集合数据 easyui
	 * 
	 * @param msg	消息
	 * @param rows	数据
	 * @param next	是否有下一页
	 * @param pageNumber	页码
	 * @param totalElements	总条数
	 * @param flag	是否成功
	 */
	public ResultJsonFormat(String msg,Object rows, boolean next, Long pageNumber,
			Long totalElements, String flag) {
		super();
		this.msg = msg;
		this.rows = rows;
		this.next = next;
		this.pageNumber = pageNumber;
		this.totalElements = totalElements;
		this.flag = flag;
	}

	/**
	 * 自动处理需要传递到客户端或则网页的数据(包含rows)
	 * @return
	 */
	public Map<String, Object> convertResultJsonForRows() {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if (msg != null && !"".equals(msg)) {
			resultMap.put(ReTurnAppConfig.KEY_MSG, msg);
		}
		if (rows != null) {
			resultMap.put(ReTurnAppConfig.KEY_ROWS, rows);
		}
		if (next != null) {
			resultMap.put(ReTurnAppConfig.KEY_NEXT, next);
		}
		if (pageNumber != null) {
			pageNumber = pageNumber>0?pageNumber:1;
			resultMap.put(ReTurnAppConfig.KEY_PAGE, pageNumber);
		}
		if (totalElements != null) {
			resultMap.put(ReTurnAppConfig.KEY_TOTAL, totalElements);
		}
		if(pageTotal !=null){
			pageTotal = pageTotal>0?pageTotal:1;
			resultMap.put(ReTurnAppConfig.KEY_TOTAL_PGE, pageTotal);
		}
		resultMap.put(ReTurnAppConfig.KEY_FLAG, flag);
		return resultMap;
	}
	/**
	 * 自动处理需要传递到客户端或则网页的数据(只包含data)
	 * @return
	 */
	public Map<String, Object> convertResultJsonForData() {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if (msg != null && !"".equals(msg)) {
			resultMap.put(ReTurnAppConfig.KEY_MSG, msg);
		}
		if (data != null) {
			resultMap.put(ReTurnAppConfig.KEY_DATA, data);
		}
		if (rows != null) {
			resultMap.put(ReTurnAppConfig.KEY_ROWS, rows);
		}
		if (next != null) {
			resultMap.put(ReTurnAppConfig.KEY_NEXT, next);
		}
		if (pageNumber != null) {
			pageNumber = pageNumber>0?pageNumber:1;
			resultMap.put(ReTurnAppConfig.KEY_PAGE, pageNumber);
		}
		if (totalElements != null) {
			resultMap.put(ReTurnAppConfig.KEY_TOTAL, totalElements);
		}
		if(pageTotal != null){
			pageTotal = pageTotal>0?pageTotal:1;
			resultMap.put(ReTurnAppConfig.KEY_TOTAL_PGE, pageTotal);
		}
		if(pageSize != null){
			resultMap.put(ReTurnAppConfig.KEY_TOTAL_PGESZIE, pageSize);
		}
		resultMap.put(ReTurnAppConfig.KEY_FLAG, flag);
		return resultMap;
	}
	/**
	 * 分页查询完成后放入数据
	 * @param totalElements 总记录数
	 * @param data 显示的当前页内容
	 */
	public ResultJsonFormat setTotalAndData(Long totalElements,Object data){
		this.data = data;
		this.rows = data;
		this.totalElements = totalElements;
		this.pageTotal= totalElements%pageSize ==0 ? totalElements/pageSize : totalElements/pageSize+1;
		this.next = pageTotal>pageNumber;
		return this;
	}
	public String getMsg() {
		return msg;
	}
	public ResultJsonFormat setMsg(String msg) {
		this.msg = msg;
		return this;
	}
	public Object getRows() {
		return rows;
	}
	public ResultJsonFormat setRows(Object rows) {
		this.rows = rows;
		return this;
	}
	public Object getData() {
		return data;
	}
	public ResultJsonFormat setData(Object data) {
		this.data = data;
		return this;
	}
	public Boolean getNext() {
		return next;
	}
	public ResultJsonFormat setNext(Boolean next) {
		this.next = next;
		return this;
	}
	public Long getPageNumber() {
		return pageNumber;
	}
	public ResultJsonFormat setPageNumber(Long pageNumber) {
		this.pageNumber = pageNumber;
		return this;
	}
	public Long getTotalElements() {
		return totalElements;
	}
	public ResultJsonFormat setTotalElements(Long totalElements) {
		this.totalElements = totalElements;
		return this;
	}
	public String getFlag() {
		return flag;
	}
	public ResultJsonFormat setFlag(String flag) {
		this.flag = flag;
		return this;
	}
	public Long getPageTotal() {
		return pageTotal;
	}
	public ResultJsonFormat setPageTotal(Long pageTotal) {
		this.pageTotal = pageTotal;
		return this;
	}
	public Long getPageSize() {
		return pageSize;
	}
	public ResultJsonFormat setPageSize(Long pageSize) {
		this.pageSize = pageSize;
		return this;
	}
	public String getOrderBy() {
		return orderBy;
	}
	public ResultJsonFormat setOrderBy(String orderBy) {
		this.orderBy = orderBy;
		return this;
	}
}
