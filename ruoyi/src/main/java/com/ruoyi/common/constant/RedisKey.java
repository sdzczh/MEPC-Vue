package com.ruoyi.common.constant;

/**
 * @描述 Redis-Key值声明类<br>
 * @author administrator
 * @版本 v1.0.0
 * @日期 2017-10-13
 */
public class RedisKey {

	public static final String TEST="TEST";
	
	public static final String TOKEN = "coinorder:token:%s";
	
	public static final String SYSTEM_PARAM = "coinorder:systemParam:%s";
	
	public static final String LATEST_TRANS_PRICE = "coinorder:order:%s:%s:price";/*最新成交价*/

	public static final String ORDER_PASSWORD_ERROR_TIMES = "coinorder:orderPassword:%s:errorTimes"; /*交易密码错误次数限制*/
	public static final String ORDER_PASSWORD_ERROR_TIMESTAMP = "coinorder:orderPassword:%s:errorTimestamp"; /*错误次数累计时间范围*/
	public static final String ORDER_PASSWORD_LOCK_TIMESTAMP = "coinorder:orderPassword:%s:lockTimestamp"; /*锁定时长*/
	public static final String SMS_ERROR_TIMES = "coinorder:smsRecord:%s"; /*验证码错误次数*/

	//C2C最新成交价   %s:币种
	public static final String C2C_PRICE = "coinorder:C2CPrice:%s";
	
	//C2C超时订单列表名称
	public static final String C2C_ORDERS_NOTPAY_KEY_NAME = "coinorder:C2COrders:notPayName";
	public static final String C2C_ORDERS_NOTCONFIRM_KEY_NAME = "coinorder:C2COrders:notConfirmName";
	//C2C超时订单列表:超时分钟数
	public static final String C2C_ORDERS_NOTPAY = "coinorder:C2COrders:notPay:%s";
	public static final String C2C_ORDERS_NOTCONFIRM = "coinorder:C2COrders:notConfirm:%s";
	
	//撤销次数统计:用户id:用户角色:日期
	public static final String C2C_ORDERS_CANCEL = "coinorder:cancelCounts:%s:%s:%s";
	
	public static final String MARKET = "coinorder:market:%s:%s:%s";//行情 marketType(1一币2主流):计价币种:交易币种
}
