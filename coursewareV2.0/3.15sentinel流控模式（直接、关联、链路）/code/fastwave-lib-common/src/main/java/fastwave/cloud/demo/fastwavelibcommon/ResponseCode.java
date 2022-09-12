package fastwave.cloud.demo.fastwavelibcommon;

public class ResponseCode {
    /**
     * 成功
     */
    public static final int API_CODE_CALL_SUCCESS=200;
    /**
     * 业务错误通用
     */
    public static final int API_CODE_CALL_ERROR=500;
    /**
     * 未知错误
     */
    public static final int API_CODE_CALL_FAIL=101;


    /**
     * 不存在该接口
     */
    public static final int API_CODE_NOT_FOUND=404;
    /**
     * 缺少参数
     */
    public static final int API_CODE_PARAM_REQUIRED=201;
    /**
     * 参数错误
     */
    public static final int API_CODE_PARAM_ERROR=202;
    /**
     * 参数类型错误
     */
    public static final int API_CODE_PARAM_TYPE_ERROR=203;
    /**
     * 重复请求API
     */
    public static final int API_CODE_REQUEST_REPEAT=205;
    /**
     * sql错误
     */
    public static final int API_CODE_SQL_ERROR=211;

    /**
     * 签名错误
     */
    public static final int API_CODE_SIGN_ERROR=301;
    /**
     * 用户未找到
     */
    public static final int API_CODE_USER_NOT_FOUND=302;
    /**
     * 用户未登陆
     */
    public static final int API_CODE_USER_NOT_LOGIN=303;
    /**
     * 用户没有权限
     */
    public static final int API_CODE_USER_NOT_HAS_PERM=304;
    /**
     * 用户操作超时
     */
    public static final int API_CODE_USER_TIMEOUT=305;
    /**
     * 用户被锁定
     */
    public static final int API_CODE_USER_LOCK=306;

    /**
     * 上传错误
     */
    public static final int API_CODE_UPLOAD_ERROR=307;

    /**
     * 插入数据成功
     */
    public static final int INSERT_DATA_SUCCESS=200;

    /**
     * 插入数据失败
     */
    public static final int INSERT_DATA_FAIL=400;

    /**
     * 校验数据失败
     */
    public static final int CHECK_DATA_OK=200;
}
