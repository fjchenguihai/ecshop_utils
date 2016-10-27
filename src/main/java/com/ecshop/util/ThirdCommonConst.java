package com.ecshop.util;


public class ThirdCommonConst {
	
	
	
	
	/**
	 * 密钥
	 */
	public static final String SECRET_KEY = "VVE_LINK";
	
	/**
	 * 威翼视联网商城对应的用户ID
	 */
	public static final String VVE_LINK_MALL_DEFAULT_USER_ID = "1";
	/**
	 * 威翼视联网商城对应的用户名称
	 */
	public static final String VVE_LINK_MALL_DEFAULT_USER_NAME = "VVE商城";
	/**
	 * 威翼视联网商城名称
	 */
	public static final String VVE_LINK_MALL_DEFAULT_MALL_NAME = "威翼视联网";
	/**
	 * 威翼视联网商城ID
	 */
	public static final String VVE_LINK_MALL_DEFAULT_MALL_ID = "1";
	
	/**
	 * 缓存KEY-官方威翼公众号AppID
	 */
	public static final String VVE_OFFICIAL_MALL_APPID = "VVE_OFFICIAL_MALL_APPID";
	/**
	 * 缓存KEY-官方威翼公众号原始ID
	 */
	public static final String VVE_OFFICIAL_MALL_USERNAME = "VVE_OFFICIAL_MALL_USERNAME";
	
	/**
	 * 缓存KEY-威翼授权地址域
	 */
	public static final String VVE_AUTHORIZE_DOMAIN = "VVE_AUTHORIZE_DOMAIN";
	
	/**
	 * 缓存KEY-公众号消息加解密Key
	 */
	public static final String VVE_MESSAGE_ENCRYPTION_KEY = "VVE_MESSAGE_ENCRYPTION_KEY";
	/**
	 * 缓存KEY-公众号消息校验Token
	 */
	public static final String VVE_MESSAGE_VALIDATION_TOKEN = "VVE_MESSAGE_VALIDATION_TOKEN";
	
	/**
	 * 缓存KEY-威翼微信开放平台AppID
	 */
	public static final String VVE_OPEN_PLAT_APPID = "VVE_OPEN_PLAT_APPID";
	
	/**
	 * 缓存KEY-威翼微信开放平台应用密钥
	 */
	public static final String VVE_OPEN_PLAT_APPSECRET = "VVE_OPEN_PLAT_APPSECRET";
	
	/**
	 * 缓存KEY-阿里云OSS域名地址
	 */
	public static final String VVE_ALIYUN_OSS_ADDRESS = "VVE_ALIYUN_OSS_ADDRESS";
	/**
	 * 缓存KEY-微信图文消息中注册入口图片URL
	 */
	public static final String VVE_REG_PICTURE_URL = "VVE_REG_PICTURE_URL";
	/**
	 * 缓存KEY-微信图文消息中注册入口图片URL
	 */
	public static final String VVE_REG_REQUEST_URL = "VVE_REG_REQUEST_URL";
	/**
	 * 缓存KEY-微信客户端校验开关
	 */
	public static final String VVE_CHECK_WECHAT_CLIENT_SWITCH = "VVE_CHECK_WECHAT_CLIENT_SWITCH";
	/**
	 * 缓存KEY-旧商城固定二维码场景ID与用户ID映射关系
	 */
	public static final String VVE_QR_SCENEID_MAP_USERID_ = "VVE_QR_SCENEID_MAP_USERID_";
	/**
	 * 缓存KEY-商城默认域名缓存
	 */
	public static final String MALL_HOST_DEFAULT_ = "MALL_HOST_DEFAULT_";
	/**
	 * SESSION缓存KEY-用户信息
	 * 与商城端要定义要一致
	 */
	public static final String  SESSION_USER_KEY="_user";
	/**
	 * SESSION缓存KEY-用户微信信息
	 * 与商城端要定义要一致
	 */
	public static final String  SESSION_WEIXIN_KEY="_weixin";
	
	/**
	 * 商城Host的Http前缀
	 */
	public static final String MALL_HOST_HTTP_PREFIX = "http://";
	
	/**
	 * 商城Host的Https前缀
	 */
	public static final String MALL_HOST_HTTPS_PREFIX = "https://";
	
	
	/**
	 * 微信授权-state参数的unionid的key
	 */
	public static final String STATE_UNIONID = "ud";
	/**
	 * 微信授权-state参数的oldunionid的key
	 */
	public static final String STATE_OLD_UNIONID = "oud";
	/**
	 * 微信授权-state参数的official mall appid的key
	 */
	public static final String STATE_OFFICIAL_MALL_APPID = "oappid";
	/**
	 * 微信授权-state参数的current mall appid的key
	 */
	public static final String STATE_CURRENT_MALL_APPID = "cappid";
	/**
	 * 微信授权-state参数的current mall openid的key
	 */
	public static final String STATE_CURRENT_MALL_OPENID = "copenid";
	/**
	 * 微信授权-state参数的current mallid的key
	 */
	public static final String STATE_CURRENT_MALL_ID = "cmallid";
	
	/**
	 * URL
	 */
	public static final String URL = "url";
	/**
	 * URL非参数部分
	 */
	public static final String URL_PART = "urlf";
	/**
	 * URL参数部分
	 */
	public static final String URL_PARAM_PART = "urlp";
	
	/**
	 * 商城MALL KEY
	 */
	public static final String MALL = "MALL";
	/**
	 * 商城缓存KEY
	 */
	public static final String MALL_CACHE_KEY = "MALL_";
	/**
	 * 商城MALL_ID KEY
	 */
	public static final String MALL_ID = "MALL_ID";
	
	/**
	 * 商城默认host标志
	 */
	public static final Short MALL_HOST_DEFAULT_FLAG = 1;
	
	
	/**
	 * 第三方平台类型
	 */
	public static final String THIRD_PLAT_TYPE = "THIRD_PLAT_TYPE";
	/**
	 * 微信
	 */
	public static final int THIRD_PLAT_TYPE_1 = 1;
	/**
	 * QQ
	 */
	public static final int THIRD_PLAT_TYPE_2 = 2;
	/**
	 * 新浪
	 */
	public static final int THIRD_PLAT_TYPE_3 = 3;
	/**
	 * 人人网
	 */
	public static final int THIRD_PLAT_TYPEE_4 = 4;
	/**
	 * 支付宝
	 */
	public static final int THIRD_PLAT_TYPE_5 = 5;
	
	
	/**
	 * 公众号appid
	 */
	public static final String APP_ID = "APP_ID";
	
	
	/**
	 * 手机绑定类型-存在用户ID但手机缺失
	 */
	public static final String REG_TYPE_FOR_EXIST_USER = "EXIST_USER";
	/**
	 * 手机绑定类型-首次绑定
	 */
	public static final String REG_TYPE_FOR_NEW_USER = "NEW_USER";
	
	
	/*************用户相关BEGIN***************/
	/**
	 * 用户类型
	 */
	public static final String USER_TYPE = "USER_TYPE";
	/**
	 * 用户类型1-VIP消费者
	 */
	public static final String USER_TYPE_1 = "1";
	/**
	 * 用户类型2-V客（认证）
	 */
	public static final String USER_TYPE_2 = "2";
	/**
	 * 用户类型3-经销商
	 */
	public static final String USER_TYPE_3 = "3";
	/**
	 * 用户类型4-盟客
	 */
	public static final String USER_TYPE_4 = "4";
	/**
	 * 用户类型5-普通消费者
	 */
	public static final String USER_TYPE_5 = "5";
	/**
	 * 用户删除状态状态
	 */
	public static final String USER_DELETESTATUS = "DELETESTATUS";
	/**
	 * 用户删除状态状态-1表示正常
	 */
	public static final String USER_DELETESTATUS_1 = "1";
	/**
	 * 用户删除状态状态-1表示删除
	 */
	public static final String USER_DELETESTATUS_0 = "0";
	
	
	/*************用户类型 END***************/
	
	
	
	
	
	/*************用户相关BEGIN ***************/
	

	/**
	 * 用户ID
	 */
	public static final String USER_ID = "USER_ID";
	
	
	/**
	 * 用户信息
	 */
	public static final String USER_INFO = "USER_INFO";
	
	/*************用户相关END***************/
	
	
	/*************微信报文区域 BEGIN***************/
	/**
	 * 微信关注状态-1：已关注
	 */
	public static final int SUBSCRIBE_STATE_1 = 1;
	/**
	 * 微信关注状态-0：未关注
	 */
	public static final int SUBSCRIBE_STATE_0 = 0;
	/**
	 * 新增微信信息类型
	 */
	public static final String ADD_WEIXIN_TYPE = "ADD_WEIXIN_TYPE";
	/**
	 * 新增微信信息类型-微信二维码、直接关注
	 */
	public static final String ADD_WEIXIN_FOR_SUBSCRIBE = "SUBSCRIBE";
	/**
	 * 新增微信信息类型-授权时
	 */
	public static final String ADD_WEIXIN_FOR_AUTHORIZATION = "AUTHORIZATION";
	/**
	 * 新增微信信息类型-分享链接二维码
	 */
	public static final String ADD_WEIXIN_FOR_SHARE_LINK = "SHARE_LINK";
	/**
	 * 新增微信信息类型-商城page页访问静默授权
	 */
	public static final String ADD_WEIXIN_FOR_PAGE_OAUTH = "PAGE_OAUTH";
	/**
	 * 微信消息类型-事件类型
	 */
	public static final String MSGTYPE_EVENT = "event";
	/**
	 * 微信消息类型-文本消息
	 */
	public static final String MSGTYPE_TEXT = "text";
	/**
	 * 微信关注事件类型-用户未关注时，进行关注后的事件推送
	 */
	public static final String EVENT_SUBSCRIBE = "subscribe";
	/**
	 * 微信关注事件类型-用户关注时，进行取消关注后的事件推送
	 */
	public static final String EVENT_UNSUBSCRIBE = "unsubscribe";
	/**
	 * 微信菜单点击事件
	 */
	public static final String EVENTKEY_CLICK= "CLICK";
	/**
	 * 微信关注事件类型-用户已关注时的事件推送
	 */
	public static final String EVENT_SCAN = "SCAN";
	
	/**
	 * 微信关注事件返回XML报文KEY-开发者微信号
	 */
	public static final String TO_USERNAME = "ToUserName";
	/**
	 * 微信关注事件返回XML报文KEY-发送方帐号（一个OpenID）
	 */
	public static final String FROM_USERNAME = "FromUserName";
	/**
	 * 微信关注事件返回XML报文KEY-消息创建时间 （整型）
	 */
	public static final String CREATE_TIME = "CreateTime";
	/**
	 * 微信关注事件返回XML报文KEY-事件类型
	 */
	public static final String EVENT = "Event";
	/**
	 * 微信关注事件返回XML报文KEY-事件KEY值，qrscene_为前缀，后面为二维码的参数值
	 */
	public static final String EVENTKEY = "EventKey";
	/**
	 * 微信关注事件返回XML报文KEY-二维码的ticket，可用来换取二维码图片
	 */
	public static final String TICKET = "Ticket";
	
	/**
	 * 创建微信二维码类型：临时-QR_SCENE
	 */
	public static final String QR_SCENE = "QR_SCENE";
	/**
	 * 创建微信二维码类型：永久-QR_LIMIT_STR_SCENE
	 */
	public static final String QR_LIMIT_STR_SCENE = "QR_LIMIT_STR_SCENE";
	
	/**
	 * 微信图文消息报文中的item结构List的key
	 */
	public static final String WE_CHAT_NEWS_MSG_XML_ITEM_LIST = "WE_CHAT_MSG_XML_ITEM_LIST";
	
	/**
	 * 微信关注事件返回XML报文KEY-事件KEY值，qrscene_为前缀，后面为二维码的参数值对应系统的USERID
	 */
	public static final String EVENT_KEY_TO_USERID = "EVENT_KEY_TO_USERID";
	
	/*************微信报文区域  END***************/
	
	
	/**
	 * 通信的ACCESS_TOKEN
	 */
	public static final String ACCESS_TOKEN = "ACCESS_TOKEN";
	/**
	 * 模板库中模板的编号
	 */
	public static final String TEMPLATE_NO = "TEMPLATE_NO";
	/**
	 * 公众号内模板消息的ID
	 */
	public static final String TEMPLATE_ID = "template_id";
	/**
	 * 模板库中模板
	 */
	public static final String TEMPLATE = "TEMPLATE";
	/**
	 * 模板库中模板
	 */
	public static final String TEMPLATE_KEY = "TEMPLATE_KEY";
	/**
	 * 新会员加入提醒
	 */
	public static final String REGISTER_SUCCESS_NOTIFICATION = "REGISTER_SUCCESS_NOTIFICATION";
	/**
	 * 新会员加入通知
	 */
	public static final String NEW_REGISTER_SUCCESS_NOTIFICATION = "NEW_REGISTER_SUCCESS_NOTIFICATION";
	/**
	 * 邀请关注成功提醒
	 */
	public static final String ATTENTION_SUCCESS_NOTIFICATION = "ATTENTION_SUCCESS_NOTIFICATION";
	/**
	 * 在调用模板消息接口后，会返回JSON数据包。正常时的返回JSON数据包示例：
	 * {"errcode":0,"errmsg":"ok","template_id":"Doclyl5uP7Aciu-qZ7mJNPtWkbkYnWBWVja26EGbNyk"}
	 */
	public static final String ERRMSG = "errmsg";
	/**
	 * 在调用模板消息接口后，会返回JSON数据包。正常时的返回JSON数据包示例：
	 * {"errcode":0,"errmsg":"ok","template_id":"Doclyl5uP7Aciu-qZ7mJNPtWkbkYnWBWVja26EGbNyk"}
	 */
	public static final String ERRMSG_OK = "ok";
	
	/**
	 * 模板消息全局应用标志 1-是
	 */
	public static final int GLOBAL_FLAG_1 = 1;
	
	/**
	 * 模板消息全局应用标志 0-否
	 */
	public static final int GLOBAL_FLAG_0 = 0;
	
	
	/**
	 * 
	 *WEIXIN对象KEY 	
	 */
	public static final String WEIXIN = "WEIXIN";
	/**
	 * 用户的唯一标识KEY
	 */
	//public static final String OPEN_ID = "OPEN_ID";
	/**
	 * 用户昵称
	 */
	//public static final String NICK_NAME = "NICK_NAME";
	/**
	 * 推荐人名称
	 */
	public static final String REFERRER_NAME = "REFERRER_NAME";
	/**
	 * 推荐人ID
	 */
	public static final String REFERRER_ID = "REFERRER_ID";
	/**
	 * 微信关注信息用户ID存在标志
	 */
	public static final String EXIST_WEIXIN_USERID = "EXIST_WEIXIN_USERID";
	/**
	 * 微信关注信息推荐人ID存在标志
	 */
	public static final String EXIST_WEIXIN_REFERRERID = "EXIST_WEIXIN_REFERRERID";
	
	
	
	/*************微信网页授权区域 BEGIN***************/
	/*************通过网页授权access_token获取用户基本信息***************/

	/**
	 * 用户的唯一标识
	 */
	public static final String OPENID = "openid";
	/**
	 * 用户昵称
	 */
	public static final String NICKNAME = "nickname";

	/**
	 * 语言
	 */
	public static final String LANGUAGE = "language";
	/**
	 * 用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
	 */
	public static final String SEX = "sex";
	/**
	 * 用户关注状态
	 */
	public static final String SUBSCRIBE = "subscribe";
	
	
	/**
	 * 用户个人资料填写的省份
	 */
	public static final String PROVINCE = "province";
	/**
	 * 普通用户个人资料填写的城市
	 */
	public static final String CITY = "city";
	/**
	 * 国家，如中国为CN
	 */
	public static final String COUNTRY = "country";
	/**
	 * 用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），
	 * 用户没有头像时该项为空。若用户更换头像，原有头像URL将失效。
	 */
	public static final String HEADIMGURL = "headimgurl";
	/**
	 * 用户特权信息，json 数组，如微信沃卡用户为（chinaunicom）
	 */
	public static final String PRIVILEGE = "privilege";
	/**
	 * 只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段
	 */
	public static final String UNIONID = "unionid";
	
	/**
	 * 重定向后会带上state参数
	 */
	public static final String STATE = "STATE";
	/**
	 * 是否注册标志-是
	 */
	public static final String REG_YES = "1";
	/**
	 * 是否注册标志-否
	 */
	public static final String REG_NO = "0";
	
	
	/*************微信网页授权区域 END***************/
	
	/*************微信模板消息行业代码区域 BEGIN***************/
	
	/**
	 * 主行业：IT科技  
	 * 副行业：互联网/电子商务
	 */
	public static final int INDUSTRY_CODE_1 = 1;
	
	/**
	 * 主行业：消费品 
	 * 副行业：消费品
	 */
	public static final int INDUSTRY_CODE_31 = 31;
	
	
	
	/*************微信模板消息行业代码区域 END***************/
	
	/*************短信相关区域BEGIN***************/
	
	/**
	 * 短信业务类型
	 */
	public static final String SEND_TYPE = "SEND_TYPE";
	/**
	 * 短信业务类型-0：发送验证码
	 */
	public static final String SEND_TYPE_0 = "0";
	/**
	 * 短信业务类型-1：其他
	 */
	public static final String SEND_TYPE_1 = "1";
	/**
	 * 手机号码
	 */
	public static final String MOBILE = "MOBILE";
	/**
	 * 平台类型
	 */
	public static final String DELIVERYTYPE = "DELIVERYTYPE";
	/**
	 * 短信用途
	 */
	public static final String PURPOSE = "PURPOSE";
	/**
	 * 短信内容
	 */
	public static final String CONTENT = "CONTENT";
	/**
	 * 短信验证码状态
	 */
	public static final String CAPTCHASSTATUS = "CAPTCHASSTATUS";
	/**
	 * 短信验证码状态-0表示未验证，
	 */
	public static final int CAPTCHASSTATUS_0 = 0;
	/**
	 * 短信验证码状态-1表示已验证
	 */
	public static final int CAPTCHASSTATUS_1 = 1;
	
	
	/*************短信相关区域 END***************/
	
	
	/*************日期相关区域BEGIN***************/
	/**
	 * 日期格式：YYYY-MM-dd HH:mm:ss
	 */
	public static final String DEFAULT_PATTERN = "yyyy-MM-dd HH:mm:ss";
	
	
	/*************日期相关区域 END***************/

	
	
	/*************分享链接区域BEGIN***************/
	/**
	 * 分享链接的微信二维码地址
	 */
	public static final String SHARE_LINK_WECHAT_QRCODE_URL = "SHARE_LINK_WECHAT_QRCODE_URL";
	/**
	 * 分享链接
	 */
	public static final String SHARE_LINK = "SHARE_LINK";
	/**
	 * 分站ID
	 */
	public static final String SUB_STATION_ID = "SUB_STATION_ID";	
	/**
	 * 链接所有者ID
	 */
	public static final String OWNER_ID = "OWNER_ID";	
	/**
	 * 商品ID
	 */
	public static final String GOODS_ID = "GOODS_ID";	
	/**
	 * 链接标题
	 */
	public static final String LINK_TITLE = "LINK_TITLE";	
	/**
	 * 链接简介
	 */
	public static final String LINK_INTRO = "LINK_INTRO";	
	/**
	 * 链接图片地址
	 */
	public static final String LINK_PICTURE = "LINK_PICTURE";	
	/**
	 * 链接原始地址
	 */
	public static final String LINK_SOURCE_ADDRESS = "LINK_SOURCE_ADDRESS";	
	/**
	 * 链接新地址
	 */
	public static final String LINK_NEW_ADDRESS = "LINK_NEW_ADDRESS";	
	/**
	 * 链接类型
	 */
	public static final String LINK_TYPE = "LINK_TYPE";
	/**
	 * 链接类型1-URL地址
	 */
	public static final int LINK_TYPE_1 = 1;
	/**
	 * 链接类型2-二维码地址
	 */
	public static final int LINK_TYPE_2 = 2;
	/**
	 * 链接总访问数
	 */
	public static final String TOTAL_SHARE_COUNT = "TOTAL_SHARE_COUNT";
	/**
	 * 链接总访问数
	 */
	public static final String TOTAL_ACCESS_COUNT = "TOTAL_ACCESS_COUNT";
	/**
	 * 链接总注册数
	 */
	public static final String TOTAL_REG_COUNT = "TOTAL_REG_COUNT";
	
	/**
	 * 链接访问唯一域名地址
	 */
	public static final String LINK_UNIQUE_DOMAIN = "LINK_UNIQUE_DOMAIN";
	/**
	 * 链接访问唯一域名默认地址
	 */
	public static final String LINK_UNIQUE_DOMAIN_DEFAULT = "http://wxserver.vvelink.com/share/link.html?linkid=";
	/**
	 * 分享链接解析完成后的回调地址
	 */
	public static final String LINK_PARSE_CALL_BACK_URL = "LINK_PARSE_CALL_BACK_URL";
	
	/*************分享链接区域END***************/
	
	
	
	
	/*************其他区域BEGIN***************/
	/**
	 * 结果代码KEY
	 */
	public static final String RESULT_CODE = "RESULT_CODE";
	
	/**
	 * 缓存失效时间(秒)
	 */
	public static final int CACHE_EXPIRY_TIME = 3600;
	
	/**
	 * 提示页面错误类型的图片名称
	 * notification.jsp
	 */
	public static final String NOTIFICATION_ERROR_IMG_NAME = "yumen";
	
	
	
	
	/*************其他区域BEGIN***************/
}
