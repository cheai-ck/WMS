package com.wcg.error;

public enum EmBusinessError implements CommonError {
    PARAMETER_VALIDATION_ERROR(10001, "参数不合法"),
    CODE_ERROR(10003,"验证码错误"),
    USER_NOT_EXIST(20001, "用户不存在或密码错误"),
    PASS_NOT_EXIST(20002,"密码有误"),
    UNKNOWN_ERROR(10002, "未知错误"),
    CARGO_NOT_EXIST(10005,"找不到货物"),
    ORDER_NOT_EXIST(10007,"找不到订单"),
    SUPPLIER_NOT_EXIST(10005,"找不到供应商"),
    OUT_OF_STOCK(10006,"库存不足");



    private int errCode;
    private String errMsg;


    private EmBusinessError(int errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    @Override
    public int getErrCode() {
        return this.errCode;
    }

    @Override
    public String getErrMsg() {
        return this.errMsg;
    }

    @Override
    public CommonError setErrMsg(String errMsg) {
        this.errMsg = errMsg;
        return this;

    }
}
