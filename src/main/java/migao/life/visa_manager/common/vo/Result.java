package migao.life.visa_manager.common.vo;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Data;
import migao.life.visa_manager.common.constant.CommonStatus;
import migao.life.visa_manager.common.exception.CommonException;

import java.io.IOException;
import java.io.Serializable;


/**
 * @Author ls
 * @Description TODO
 * @Date 2024/11/27 16:32
 */
@Data
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 响应码
     */
    private Integer code;

    /**
     * 响应信息
     */
    private String msg;

    /**
     * 响应数据
     */
    private T data;

    public Result() {
        this.code = 200;
        this.msg = "success";
    }

    public Result(String msg) {
        this();
        this.msg = msg;
    }

    public Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(Integer code, String msg, T data) {
        this(code, msg);
        this.data = data;
    }

    public Result(CommonStatus commonStatus) {
        this(commonStatus.getCode(), commonStatus.getMsg());
    }

    public static Result<Void> success() {
        return new Result<>();
    }

    public static <R> Result<R> success(R data) {
        Result<R> result = new Result<>();
        result.setData(data);
        return result;
    }

    public static Result<Void> error(int code, String msg) {
        return new Result<>(code, msg);
    }

    public static void success(HttpServletResponse httpServletResponse, Object data) throws IOException {
        httpServletResponse.setContentType("application/json; charset=UTF-8");
        ServletOutputStream outputStream = httpServletResponse.getOutputStream();

        Result<Object> result = Result.success(data);
        //outputStream.write(JsonUtil.toJson(result).getBytes(StandardCharsets.UTF_8));
        outputStream.flush();
        outputStream.close();
    }


    public static Result<Void> error(CommonStatus commonStatus) {
        return new Result<>(commonStatus);
    }

    public static Result<Void> error(CommonException commonException) {
        return new Result<>(commonException.getCode(), commonException.getMsg());
    }

    public static void error(HttpServletResponse httpServletResponse, CommonStatus commonStatus) throws IOException {
        httpServletResponse.setContentType("application/json; charset=UTF-8");
        ServletOutputStream outputStream = httpServletResponse.getOutputStream();
        Result<Void> result = Result.error(commonStatus);
        //outputStream.write(JsonUtil.toJson(result).getBytes(StandardCharsets.UTF_8));
        outputStream.flush();
        outputStream.close();
    }

    public static void error(HttpServletResponse httpServletResponse, String message) throws IOException {
        httpServletResponse.setContentType("application/json; charset=UTF-8");
        ServletOutputStream outputStream = httpServletResponse.getOutputStream();
        Result<Void> result = Result.error(CommonStatus.FAILED.getCode(), message);
        //outputStream.write(JsonUtil.toJson(result).getBytes(StandardCharsets.UTF_8));
        outputStream.flush();
        outputStream.close();
    }
}