package edu.swfu.core.util;


import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

/**
 * 控制层辅助类
 * 
 * @author cuijin
 *
 */
public final class ControllerHelper {

	private static final Logger LOGGER = Logger.getLogger(ControllerHelper.class);
	
	public static String getUUID(){
		return UUID.randomUUID().toString().replace("-", "");
	}

	private ControllerHelper(){
		//无参，防止实例化
	}

	/**
	 * 创建一个成功结果Map 
	 * @param data 需要返回的数据
	 * @param total 总的记录数
	 * @return 返回客户端的map
	 */
	public static Map<String, Object> getSuccessMap(Object data,long total) {
		Map<String, Object> map = new HashMap<>();
		map.put("status", 200);
		map.put("rows", data);
		map.put("total",total);
		map.put("count",total);
		return map;
	}
	
	
	/**
	 * 创建一个成功结果Map
	 * 
	 * @return 返回客户端的map
	 */
	public static Map<String, Object> getSuccessMap() {
		Map<String, Object> map = new HashMap<>();
		map.put("success", "true");

		return map;
	}
	/**
	 * 创建一个成功结果Map 
	 * @param data 需要返回的数据
	 * @return 返回客户端的map
	 */
	public static Map<String, Object> getSuccessMap(Object data) {
		Map<String, Object> map = new HashMap<>();
		map.put("status", 200);
		map.put("success", "true");
		map.put("data", data);
		return map;
	}
	
	
	
	/**
	 * 创建一个成功结果Map 
	 * @param data 需要返回的数据
	 * @return 返回客户端的map
	 */
	public static Map<String, Object> getSuccessMap(Object data,String sessionId) {
		Map<String, Object> map = new HashMap<>();
		map.put("status", 200);
		map.put("success", "true");
		map.put("sessionId", sessionId);
		map.put("data", data);
		return map;
	}
	
	/**
	 * 创建一个失败结果Map
	 * @param msg 错误信息
	 * @return
	 */
	public static Map<String, Object> getErrorMap(String msg) {
		Map<String, Object> map = new HashMap<>();
		map.put("success", "false");
		map.put("error", msg);
		return map;
	}

	public static Map<String,Object> getErrorMap(String msg,Object data) {
		Map<String, Object> map = new HashMap<>();
		map.put("success", "false");
		map.put("error", msg);
		map.put("data",data);
		return map;
	}

	/**
	 * 创建一个失败Map
	 * @param e 异常
	 * @return
	 */
	public static Map<String, Object> getErrorMap(Exception e) {
		Map<String, Object> map = new HashMap<>();

		map.put("success", "false");
		map.put("error", getExceptionMsg(e));
		
		return map;
	}	
	
	/**
	 * 读取异常的错误信息
	 * @param 
	 * @return
	 */
	public static String getExceptionMsg(Exception e) {
		LOGGER.error(e.getMessage());
		return e.getMessage();
	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	public static TQueryPara readQueryPara(HttpServletRequest request) {
		TQueryPara result = new TQueryPara();
		Map<String, String[]> map = request.getParameterMap();

		Iterator<String> it = map.keySet().iterator();
		while (it.hasNext()) {
			String key = it.next();
			String val = request.getParameter(key);
			if (key.startsWith("wh_") && val!=null && !"".equals(val)){
				result.addExp(key.substring("wh_".length()), val.trim());
			}
		}
		return result;
	}
}
