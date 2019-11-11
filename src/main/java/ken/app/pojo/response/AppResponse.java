package ken.app.pojo.response;

import com.alibaba.fastjson.JSONObject;
import ken.app.pojo.Status;

/**
 * Created by fei on 2019/11/10.
 * <p>
 * 统一返回
 */
public class AppResponse {


    /**
     * 返回指定信息
     *
     * @param dataObj
     * @return
     */
    public static JSONObject toResult(int status, String msg, Object dataObj) {
        JSONObject response = new JSONObject();
        response.put("status", status);
        response.put("msg", msg);
        response.put("data", dataObj);
        return response;
    }

    /**
     * 返回成功信息
     *
     * @param dataObj
     * @return
     */
    public static JSONObject succ(Object dataObj) {
        return toResult(Status.ok, "请求成功", dataObj);
    }

    /**
     * 返回成功信息
     *
     * @param
     * @return
     */
    public static JSONObject succ() {
        return toResult(Status.ok, "请求成功", null);
    }

    /**
     * 返回错误信息
     *
     * @param
     * @return
     */
    public static JSONObject wrong(String msg) {
        return toResult(Status.wrong, msg, null);
    }
}
