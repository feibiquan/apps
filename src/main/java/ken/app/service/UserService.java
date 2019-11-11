package ken.app.service;

import ken.app.pojo.UserInfo;

/**
 * Created by fei on 2019/11/5.
 */
public interface UserService {

    /**
     * 根据openid获取用户信息
     * @param openId
     * @return
     */
    public UserInfo getUserInfoByOpenId(String openId);

    void initUserInfo(String openid);
}
