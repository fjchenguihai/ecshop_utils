

package com.ecshop.util;

/**
 * 
 * 订单常量
 *
 */
public class OrderConstants {
	public static final int NOT_PAY = 0;//待支付
	public static final int NOT_DELIVERY = 1;//待发货
	public static final int DELIVERED = 2;//已发货
	public static final int PART_DELIVERED = 3;//部分已发货
	public static final int CANCEL = 4;//已取消
	public static final int NOT_COMMENTS = 5;//待评价
	public static final int FINISH = 6;//交易完成
	public static final int AFTER_SALE = 7;//售后中
	//待付款
	public static final int ORDER_AWAIT_PAY=0;
	//已付款
	public static final int ORDER_END_PAY=1;
	//确认订单
	public static final int AFFIRM_ORDER=1;
	//未发货
	public static final int LOGISTICS_NOT_SEND=0;
	//已发货
	public static final int LOGISTICS_YET_SEND=1;
	//部分发货
	public static final int LOGISTICS_PART_SEND=2;
	//已收货
	public static final int LOGISTICS_RECEIVING=3;
	//是包邮
	public static final int FREE_MAIL=1;
	//否包邮
	public static final int NO_FREE_MAIL=0;
	//未评价
	public static final int NO_COMMENT=0;
	// 用户类型Id 未登陆用户
	public static final int NOT_LOGIN_USER=0;
	//普通消费者
	public static final int COMMON_USER=5;
	//订单状态:取消
	public static final int ORDER_CANCEL=2;
}
