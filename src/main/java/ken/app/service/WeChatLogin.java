package ken.app.service;

import net.sf.json.JSONObject;

import javax.swing.*;

public interface WeChatLogin {
	/**
	 * @note 获取小程序发送的code，通过UrlRequest找微信服务器解析
	 * @param request
	 * @param response
	 * @return
	 */
	JSONObject ResolvingWeChatCode(String code);
	
	/**
	 * @note 解析微信绑定的手机号
	 * @param encryptedData
	 * @param sessionKey
	 * @param iv
	 * @return
	 */
	JSONObject ResolvingWeChatTel(String openid,String encryptedData, String sessionKey, String iv);
	
	/**解析后的用户数据，查询数据库校验是否有此用户，如没有，存用户到本地数据库
	 * @param User
	 */
//	CheckSaveUser(User);

	public void test(String code);

}
