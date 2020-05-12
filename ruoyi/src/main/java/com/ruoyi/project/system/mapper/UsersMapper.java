package com.ruoyi.project.system.mapper;

import java.util.List;
import com.ruoyi.project.system.domain.Users;

/**
 * 用户管理Mapper接口
 * 
 * @author ruoyi
 * @date 2020-05-12
 */
public interface UsersMapper 
{
    /**
     * 查询用户管理
     * 
     * @param id 用户管理ID
     * @return 用户管理
     */
    public Users selectUsersById(Long id);

    /**
     * 查询用户管理列表
     * 
     * @param users 用户管理
     * @return 用户管理集合
     */
    public List<Users> selectUsersList(Users users);

    /**
     * 新增用户管理
     * 
     * @param users 用户管理
     * @return 结果
     */
    public int insertUsers(Users users);

    /**
     * 修改用户管理
     * 
     * @param users 用户管理
     * @return 结果
     */
    public int updateUsers(Users users);

    /**
     * 删除用户管理
     * 
     * @param id 用户管理ID
     * @return 结果
     */
    public int deleteUsersById(Long id);

    /**
     * 批量删除用户管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteUsersByIds(Long[] ids);
}
