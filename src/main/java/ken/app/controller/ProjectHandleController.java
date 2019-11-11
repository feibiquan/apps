package ken.app.controller;

import com.alibaba.fastjson.JSONObject;
import ken.app.pojo.ProjectInfo;
import ken.app.service.ProjectHandleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by fei on 2019/11/7.
 * 项目操作处理controller
 */
@Controller
@RequestMapping("project")
public class ProjectHandleController {
    @Autowired
    ProjectHandleService projectHandleService;


    @RequestMapping("publish")
    public JSONObject publishOrNeedProjects(ProjectInfo info, HttpServletRequest request) {

        return projectHandleService.publishOrNeedProjects(info);
    }

    @RequestMapping("update")
    public JSONObject update(ProjectInfo info, HttpServletRequest request) {
        return projectHandleService.updateProjects(info);
    }


    @RequestMapping("delete")
    public JSONObject delete(String projectId, HttpServletRequest request) {
        return projectHandleService.deleteProjects(projectId);
    }



    @RequestMapping("query")
    public JSONObject delete(@RequestBody Map<String, Object> queryMap, HttpServletRequest request) {
        return projectHandleService.queryProjectLists(queryMap);
    }



}
