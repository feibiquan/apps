package ken.app.dao;


import ken.app.pojo.ProjectInfo;

import java.util.List;
import java.util.Map;

public interface ProjectInfoDao {
    int deleteByPrimaryKey(String projectId);

    int insert(ProjectInfo record);

    int insertSelective(ProjectInfo record);

    ProjectInfo selectByPrimaryKey(String projectId);

    List<ProjectInfo> queryProjectList(Map<String,Object> queryMap);

    int updateByPrimaryKeySelective(ProjectInfo record);

    int updateByPrimaryKey(ProjectInfo record);
}