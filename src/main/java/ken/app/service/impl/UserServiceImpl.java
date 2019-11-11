package ken.app.service.impl;

import ken.app.dao.UserInfoMapper;
import ken.app.pojo.UserInfo;
import ken.app.service.UserService;
import ken.app.utils.DateUtil;
import ken.app.utils.GenerateIdsUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by fei on 2019/11/5.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserInfoMapper userInfoDao;
    private static Logger logger = LoggerFactory.getLogger(WeChatLoginImpl.class);

    public UserInfo getUserInfoByOpenId(String openid){
        UserInfo info =new UserInfo();
        info.setUseropenid(openid);
        UserInfo userInfo = userInfoDao.selectByUserOpenId(info);
        return userInfo;
    }

    @Override
    public void initUserInfo(String openid) {
        UserInfo info =new UserInfo();
        info.setUseropenid(openid);
        UserInfo userInfo = userInfoDao.selectByUserOpenId(info);
        if (null == userInfo) {
            logger.info("【用户初始化】openid: {} 用户不存在，正在创建", openid);
            String userId = GenerateIdsUtil.generateId();
            UserInfo initUser = new UserInfo();
            initUser.setUserId(userId);
            initUser.setUseropenid(openid);
            initUser.setCreateTime(DateUtil.formatDateTime(new Date()));
            if (userInfoDao.insertSelective(initUser) > 0) {
                logger.info("【用户初始化】创建会员成功，会员id为： {} ", userId);
            }
        } else {
            logger.info("【用户初始化】用户已存在： {} ", openid);
        }
    }
}
