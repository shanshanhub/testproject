package codeservice;

import java.util.List;

/**
 * @author WanChuanLai
 * @create 7/21/16.
 */
public interface PaymentModeService {
    /**
     * 作用:批量修改支付方式状态
     *
     * @param status 支付方式状态 false-停用 true-启用
     * @param ids 批量修改ids
     * @return 返回是否修改成功
     */
    boolean updateStatus(boolean status, List<String> ids);

    /**
     * 作用:指定支付方式匹配的分站
     * 1,启用状态下指定分站
     * @param id 支付方式id
     * @param subsiteIds 分站ids
     * @return 返回是否修改成功
     */
    boolean updateSubsite(Integer id,List<Integer> subsiteIds);

    /**
     * 作用:指定支付方式匹配的渠道
     * 1,启用状态下指定渠道
     * @param id 支付方式id
     * @param channelIds 分站ids
     * @return 返回是否修改成功
     */
    boolean updateChannel(Integer id,List<Integer> channelIds);

    /**
     * 作用:修改支付展示顺序
     * @param id
     * @param sequence
     * @return
     */
    boolean updateSequence(Integer id,int sequence);

    /**
     * 作用:查询所有的支付方式
     * 1,按照升序查询所有的支付方式
     * @return
     */
    List<PaymentMode> find();




}
