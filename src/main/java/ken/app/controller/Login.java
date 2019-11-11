package ken.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ken.app.service.WeChatLogin;
import net.sf.json.JSONObject;

import javax.servlet.http.HttpServletRequest;

@Controller
public class Login {
	@Autowired
	private WeChatLogin weChatLogin;

	@RequestMapping("weChatLogin")
	@ResponseBody
	public JSONObject weChatLogin(String code){	
		return weChatLogin.ResolvingWeChatCode(code);
	}
	
	@RequestMapping("weChatLoginTel")
	@ResponseBody
	public JSONObject weChatLoginTel(HttpServletRequest request,String encryptedData, String sessionKey, String iv){
		String openid = request.getParameter("openid");
		return weChatLogin.ResolvingWeChatTel(openid,encryptedData, sessionKey, iv);
	}





	@RequestMapping("test")
	@ResponseBody
	public JSONObject test(String code){
		 weChatLogin.test(code);
		 return new JSONObject();
	}



}
