package com.ruoyi.project.system.service;

import java.util.List;
import com.ruoyi.project.system.domain.IdcardValidate;

/**
 * 实名认证记录Service接口
 * 
 * @author ruoyi
 * @date 2020-05-12
 */
public interface IIdcardValidateService 
{
    /**
     * 查询实名认证记录
     * 
     * @param id 实名认证记录ID
     * @return 实名认证记录
     */
    public IdcardValidate selectIdcardValidateById(Long id);

    /**
     * 查询实名认证记录列表
     * 
     * @param idcardValidate 实名认证记录
     * @return 实名认证记录集合
     */
    public List<IdcardValidate> selectIdcardValidateList(IdcardValidate idcardValidate);

    /**
     * 新增实名认证记录
     * 
     * @param idcardValidate 实名认证记录
     * @return 结果
     */
    public int insertIdcardValidate(IdcardValidate idcardValidate);

    /**
     * 修改实名认证记录
     * 
     * @param idcardValidate 实名认证记录
     * @return 结果
     */
    public int updateIdcardValidate(IdcardValidate idcardValidate);

    /**
     * 批量删除实名认证记录
     * 
     * @param ids 需要删除的实名认证记录ID
     * @return 结果
     */
    public int deleteIdcardValidateByIds(Long[] ids);

    /**
     * 删除实名认证记录信息
     * 
     * @param id 实名认证记录ID
     * @return 结果
     */
    public int deleteIdcardValidateById(Long id);
}
