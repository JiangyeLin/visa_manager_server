package migao.life.visa_manager.common.constant;



public enum CommonStatus {
  /**
   * 状态码-状态信息
   */
  SUCCESS(10000, "SUCCESS"),
  FAILED(10001, "FAILED"),
  SERVER_ERROR(10002, "服务器异常"),
  SYSTEMIC_CAN_NOT_ALTER(10003, "不能操作系统内置对象"),
  NOT_ALLOWED(10004, "没有权限"),
  INSERT_ERROR(10005, "新增失败"),
  DELETE_ERROR(10006, "删除失败"),
  UPDATE_ERROR(10007, "更新失败"),
  NAME_EXISTS(10008, "名字已存在"),
  UPLOAD_ERROR(10009, "上传失败"),
  NOT_LOGIN(10010, "未登录，或登录超时，请重新登录"),
  LOGIN_ERROR(10011, "登录失败，账号或密码错误"),
  LOGOUT_ERROR(10012, "登出失败"),
  EXISTS_REF_ERROR(10013, "存在引用，无法删除"),
  ASSIGN_ROLE_ERROR(10014, "分配角色信息失败"),
  RESET_PASSWORD_ERROR(10015, "重置密码失败"),
  OLD_PASSWORD_ERROR(10016, "旧密码不匹配"),
  USER_NOT_EXIST(10017, "用户不存在"),
  CAPTCHA_ERROR(10018, "验证码错误"),
  WX_LOGIN_ERROR(10019, "登录失败，请重新进入小程序"),
  QR_CODE_ERROR(10020, "二维码出错啦，请刷新"),
  ASSIGN_PERM_ERROR(10021, "分配权限错误"),
  ROLE_NOT_EXIST(10022, "角色不存在"),
  GET_PHONE_NUMBER_ERROR(10023, "获取手机号失败"),
  START_TIME_NOT_NULL(10024, "开始时间不能为空"),
  END_TIME_NOT_NULL(10025, "结束时间不能为空"),
  ID_NOT_EXISTS(10026, "ID不存在"),
  IS_EXISTS(10027,"对象已存在"),
  NOT_EXISTS(10027,"对象不存在"),
  NOT_MEMBER(10028,"会员未注册"),
  QR_CODE_EXPIRE(10029,"二维码失效"),
  NOT_STORE(10029,"门店不存在"),
  INSUFFICIENT_BALANCE(10029,"余额不足"),
  NOT_CARD(10030,"储值卡不存在"),
  NOT_ORDER(10031,"订单不存在"),
  PAY_ERROR(10032,"支付失败"),
  RECHARGE_ERROR(10032,"支付失败"),
  REFUND_ERROR(10033,"退款失败")
  ;

  /**
   * 状态码
   */
  Integer code;

  /**
   * 状态信息
   */
  String msg;

  CommonStatus(Integer code, String msg) {
    this.code = code;
    this.msg = msg;
  }

  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }
}
