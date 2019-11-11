package ken.app.utils;

import ken.app.pojo.UserInfo;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Description openid util
 */
public class OpenidUtil {

	public static final String LOGINACCOUNT = "currentOpenid";
	public static final int SESSIONTIMEOUT = 900;


	/**
	 * @Description 获取Session对象
	 * @return HttpSession
	 * @author xfliang
	 * @date 2016年12月22日 下午7:43:11
	 */
	public  static HttpSession getSession() {
		HttpSession session = ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest().getSession();
		return session;
	}
	
	/**
	  * 获取request对象
	 * @return HttpServletRequest  request
	 */
	public HttpServletRequest getRequest() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest();
		return request;
	}

	/**
	 * @Description 设置SysUser-Session对象
	 * @param su
	 * @author xfliang
	 * @date 2016年12月22日 下午7:43:30
	 */
	public static void setLoginAccount(UserInfo su) {
		getSession().setAttribute(LOGINACCOUNT, su);
	}
	
	public static void setSessionAttr(String attrName
			,Object obj) {
		getSession().setAttribute(attrName, obj);
	}
	
	/**
	 * @Description 删除当前登录用户
	 * @author bpliang
	 * @date 2017年2月5日 下午17:56:30
	 */
	public static void removeLoginAccount() {
		getSession().removeAttribute(LOGINACCOUNT);
	}

	/**
	 * @Description 获取SysUser-Session对象
	 * @return SysUser系统用户对象
	 * @author xfliang
	 * @date 2016年12月22日 下午7:44:01
	 */
	public static  UserInfo getCurrentLoginAccount() {
		return (UserInfo) getSession().getAttribute(LOGINACCOUNT);
	}
	
}
