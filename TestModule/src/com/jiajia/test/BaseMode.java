package com.jiajia.test;

/**
 * 后台发挥的数据格式
 * {
 *     errorCode: int
 *     errorMsg: String
 *     data: json
 * }
 * @param <T> 通过泛型直接将后台返回数据解析成对应实例
 */
public class BaseMode<T> {

    String errorMsg;

    int errorCode;

    T data;

    public BaseMode() {

    }
}
