<<<<<<< HEAD
package cdu_pfms.services;

/**
 * @description:
 * @author: meng.pc
 * @date: 2018-11-01 10:50
 */
public interface AdminService {

    /**
     * 查看所有用户信息（按accountId 查询）
     * @return
     * @throws Exception
     */
  String checkAllAccounts(String accountId,Integer pageNumber) throws Exception;

    /**
     *查看所有冻结账户（可按userName查询）  accountState为0时为冻结
     */
    String checkFrozenAccounts(String accountId,Integer pageNumber) throws Exception;

    /**
     * 查看所有开启账户
     * @param accountId 可作为查询参数  accountState为1时开启
     * @return
     * @throws Exception
     */
    String checkOpenedAccounts(String accountId,Integer pageNumber) throws Exception;

    /**
     * 开户
     * @param account
     * @throws Exception
     */
//    String openAnAccount(Account account) throws Exception;

    /**
     * 改变管理员密码
     * @param currentPassword ：当前密码
     * @param newPassword ：新密码
     */
    String changePassword(String currentPassword,String newPassword);

    /**
     * 冻结账户(根据账户户名)
     * @param accountId
     * @throws Exception
     */
    String frozenAccount(String accountId) throws  Exception;

    /**
     * 恢复被冻结的账户（按用户名）
     * @param accountId
     * @throws Exception
     */
    String resumeAccount(String accountId) throws Exception;

    /**
     * 删除指定的账户
     * @param accountId
     * @throws Exception
     */
    String deleteAccount(String accountId) throws Exception;


}
=======
package cdu_pfms.services;

/**
 * @description:
 * @author: meng.pc
 * @date: 2018-11-01 10:50
 */
public interface AdminService {

    /**
     * 查看所有用户信息（按accountId 查询）
     * @return
     * @throws Exception
     */
  String checkAllAccounts(String accountId,Integer pageNumber) throws Exception;

    /**
     *查看所有冻结账户（可按userName查询）  accountState为0时为冻结
     */
    String checkFrozenAccounts(String accountId,Integer pageNumber) throws Exception;

    /**
     * 查看所有开启账户
     * @param accountId 可作为查询参数  accountState为1时开启
     * @return
     * @throws Exception
     */
    String checkOpenedAccounts(String accountId,Integer pageNumber) throws Exception;

    /**
     * 开户
     * @param account
     * @throws Exception
     */
//    String openAnAccount(Account account) throws Exception;

    /**
     * 改变管理员密码
     * @param currentPassword ：当前密码
     * @param newPassword ：新密码
     */
    String changePassword(String currentPassword,String newPassword);

    /**
     * 冻结账户(根据账户户名)
     * @param accountId
     * @throws Exception
     */
    String frozenAccount(String accountId) throws  Exception;

    /**
     * 恢复被冻结的账户（按用户名）
     * @param accountId
     * @throws Exception
     */
    String resumeAccount(String accountId) throws Exception;

    /**
     * 删除指定的账户
     * @param accountId
     * @throws Exception
     */
    String deleteAccount(String accountId) throws Exception;


}
>>>>>>> second commit
