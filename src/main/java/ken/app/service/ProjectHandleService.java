package ken.app.service;

import com.alibaba.fastjson.JSONObject;
import ken.app.pojo.ProjectInfo;

import java.util.Map;

/**
 * Created by fei on 2019/11/7.
 */

public interface ProjectHandleService {

    public JSONObject publishOrNeedProjects(ProjectInfo info);

    public JSONObject updateProjects(ProjectInfo info);

    public JSONObject deleteProjects(String info);

    public JSONObject queryProjectLists(Map<String, Object> queryMap);
}
