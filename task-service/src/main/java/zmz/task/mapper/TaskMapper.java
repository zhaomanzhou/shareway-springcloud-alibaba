package zmz.task.mapper;


import zmz.task.entity.po.Task;
import zmz.task.entity.vo.GetTask;
import zmz.task.entity.vo.SimpleTask;

import java.util.List;

public interface TaskMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Task record);

    int insertSelective(Task record);

    Task selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Task record);

    int updateByPrimaryKey(Task record);

    List<SimpleTask> queryAllSimple();

    List<Task> selectByPublicUserId(Long id);

    List<GetTask> selectBuGetUserId(Long id);
}