package ken.app.pojo;

/**
 * Created by fei on 2019/11/5.
 */
public class UserInfo {
    private String userId;
    private String useropenid;
    private String userName;
    private String userPhoneNo;
    private String userStatus;
    private String userHeaderUrl;
    private String userNickName;
    private String createTime;
    private String userUnionId;
    private String updateTime;
    private String userClarify;//用户类型

    public String getUserClarify() {
        return userClarify;
    }

    public void setUserClarify(String userClarify) {
        this.userClarify = userClarify;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUseropenid() {
        return useropenid;
    }

    public void setUseropenid(String useropenid) {
        this.useropenid = useropenid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhoneNo() {
        return userPhoneNo;
    }

    public void setUserPhoneNo(String userPhoneNo) {
        this.userPhoneNo = userPhoneNo;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public String getUserHeaderUrl() {
        return userHeaderUrl;
    }

    public void setUserHeaderUrl(String userHeaderUrl) {
        this.userHeaderUrl = userHeaderUrl;
    }

    public String getUserNickName() {
        return userNickName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUserUnionId() {
        return userUnionId;
    }

    public void setUserUnionId(String userUnionId) {
        this.userUnionId = userUnionId;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
