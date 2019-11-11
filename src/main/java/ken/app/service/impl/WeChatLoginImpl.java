package ken.app.service.impl;

import com.alibaba.fastjson.JSON;
import ken.app.dao.UserInfoMapper;
import ken.app.pojo.UserInfo;
import ken.app.service.UserService;
import ken.app.service.WeChatLogin;
import ken.app.utils.DateUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ken.app.pojo.Status;
import ken.app.utils.AesCbcUtil;
import ken.app.utils.UrlRequest;
import net.sf.json.JSONObject;

import java.util.Date;
import java.util.Map;

@Service
public class WeChatLoginImpl implements WeChatLogin {
    static String wxspAppid = "wx942a0dab22f5d96b";
    static String wxspSecret = "1c4644e6df9c58722ba3d16a0e3feca8";
    static String grant_type = "authorization_code";

    private static Logger logger = LoggerFactory.getLogger(WeChatLoginImpl.class);

    @Autowired
    private UserService userService;

    @Autowired
    private UserInfoMapper userInfoDao;

    public JSONObject ResolvingWeChatCode(String code) {
        logger.info("用户获取openId,code=:{} ", code);
        JSONObject answer = new JSONObject();
        if (StringUtils.isBlank(code)) {
            answer.put("status", Status.wrong);
            answer.put("msg", "code不能为空");
            return answer;
        }
        String params = "appid=" + wxspAppid + "&secret=" + wxspSecret + "&js_code=" + code + "&grant_type="
                + grant_type;
        try {
            String result = UrlRequest.sendGet(params);
            logger.info("【用户获取openId】,url:{} result=:{} ", params, result);
            if (null != result && result.length() > 0) {
                answer.put("status", Status.ok);
                answer.put("msg", "初始化openid成功");
                answer.put("result", result);
            }
            //初始化用户open数据
            Map<String, String> map = JSON.parseObject(result, Map.class);
            userService.initUserInfo(map.get("openid"));
        } catch (Exception e) {
            answer.put("status", Status.wrong);
            answer.put("msg", "初始化openid失败");
            e.printStackTrace();
        }
        return answer;
    }


    @Override
    public JSONObject ResolvingWeChatTel(String openid, String encryptedData, String sessionKey, String iv) {
        JSONObject answer = new JSONObject();
        if (StringUtils.isBlank(openid)) {
            answer.put("status", Status.wrong);
            answer.put("msg", "openid不能为空");
            return answer;
        }
        try {
            logger.info("【解析用户数据】,encryptedData:{} sessionKey={}  iv=:{} ", encryptedData, sessionKey, iv);
            String result = AesCbcUtil.decrypt(encryptedData, sessionKey, iv, "UTF-8");
            logger.info("【解析用户数据】,result=:{} ", result);
            if (null != result && result.length() > 0) {
                answer.put("status", Status.ok);
                answer.put("msg", "信息解密成功");
                answer.put("result", result);
                //更新用户数据
                Map<String, String> map = JSON.parseObject(result, Map.class);
                UserInfo user = new UserInfo();
                user.setUserPhoneNo(map.get("phoneNumber"));
                user.setUseropenid(openid);
                user.setUpdateTime(DateUtil.formatDateTime(new Date()));
                if (userInfoDao.updateByPrimaryKeySelective(user) > 0) {
                    logger.info("【更新用户手机号】,解析完成后，更新用户手机号成功");
                }
            }
        } catch (Exception e) {
            answer.put("status", Status.wrong);
            answer.put("msg", "信息解密失败");
            e.printStackTrace();
        }
        return answer;
    }


    public void test(String code) {
        if (code.equalsIgnoreCase("1")) {
            userService.initUserInfo("q2543654ygsdgwg");
        }
    }

}
