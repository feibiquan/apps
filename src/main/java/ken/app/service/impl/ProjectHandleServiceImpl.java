package ken.app.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import ken.app.dao.ProjectInfoDao;
import ken.app.pojo.ProjectInfo;
import ken.app.pojo.response.AppResponse;
import ken.app.service.ProjectHandleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by fei on 2019/11/7.
 */
@Service
public class ProjectHandleServiceImpl implements ProjectHandleService {

    private static Logger logger = LoggerFactory.getLogger(ProjectHandleServiceImpl.class);


    @Autowired
    ProjectInfoDao projectInfoDao;

    @Override
    public JSONObject publishOrNeedProjects(ProjectInfo info) {
        logger.info("【项目发布/需求】 info: {}", info);
        //参数校验。。
        int i = projectInfoDao.insertSelective(info);
        if (i > 0) {
            return AppResponse.succ();
        }
        return AppResponse.wrong("插入失败");
    }


    @Override
    public JSONObject updateProjects(ProjectInfo info) {
        logger.info("【项目更新】 info: {}", info);
        int i = projectInfoDao.updateByPrimaryKeySelective(info);
        if (i > 0) {
            return AppResponse.succ();
        }
        return AppResponse.wrong("更新失败");
    }


    @Override
    public JSONObject deleteProjects(String projectId) {
        logger.info("【项目删除】 projectId: {}", projectId);
        int i = projectInfoDao.deleteByPrimaryKey(projectId);
        if (i > 0) {
            return AppResponse.succ();
        }
        return AppResponse.wrong("删除失败");
    }


    @Override
    public JSONObject queryProjectLists(Map<String, Object> queryMap) {
        logger.info("【项目查询】 queryMap: {}", JSON.toJSON(queryMap));
        List<ProjectInfo> infos = projectInfoDao.queryProjectList(queryMap);
        return AppResponse.succ(infos);
    }


}
