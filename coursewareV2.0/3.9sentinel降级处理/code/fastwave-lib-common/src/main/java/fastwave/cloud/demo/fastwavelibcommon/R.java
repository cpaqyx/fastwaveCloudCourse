package fastwave.cloud.demo.fastwavelibcommon;

import java.util.HashMap;
import java.util.Map;

public class R extends HashMap<String, Object> {

    private static final long serialVersionUID = 1L;

    public R() {
        put("code", ResponseCode.API_CODE_CALL_SUCCESS);
        put("message", "操作成功");
    }

    public boolean isOk()
    {
        return this.get("code").equals(ResponseCode.API_CODE_CALL_ERROR);
    }

    public boolean isSuccess()
    {
        return this.get("code").equals(ResponseCode.API_CODE_CALL_SUCCESS);
    }

    public static R error() {
        return error(ResponseCode.API_CODE_CALL_ERROR, "操作失败");
    }

    public static R error(String message) {
        return error(ResponseCode.API_CODE_CALL_ERROR, message);
    }

    public static R error(int code, String message) {
        R r = new R();
        r.put("code", code);
        r.put("message", message);
        return r;
    }

    public static R error(Map<String, Object> map) {
        R r = new R();
        r.putAll(map);
        return r;
    }

    public static R error(int code) {
        R r = new R();
        r.put("code", code);
        r.put("message", "");
        return r;
    }

    public static R ok(String message) {
        R r = new R();
        r.put("message", message);
        return r;
    }

    public static R ok(Map<String, Object> map) {
        R r = new R();
        r.putAll(map);
        return r;
    }

    public static R ok() {
        return new R();
    }

    @Override
    public R put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    public static R buildEmptyR(String message) {
        R r = new R();
        r.put("code", ResponseCode.API_CODE_CALL_ERROR);
        r.put("message", message+"超时，熔断器返回");
        return r;
    }

    public boolean insertDataOk(){
        return this.get("code").equals(ResponseCode.INSERT_DATA_SUCCESS);
    }

    public boolean checkRowDataOk(){
        return this.get("code").equals(ResponseCode.CHECK_DATA_OK);
    }
}

