package response;



import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

//@JsonSerialize(include =  JsonSerialize.Inclusion.NON_NULL)
//保证序列化json的时候,如果是null的对象,key也会消失
public class CommonResponse<T> implements Serializable {

    public static int SUCCESS_CODE = 200;

    private int status;
    private String msg;
    private T data;

    //一般为错误返回
    private CommonResponse(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }


    private CommonResponse(int status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }



    @JsonIgnore
    //使之不在json序列化结果当中
    public boolean isSuccess() {
        return this.status == SUCCESS_CODE;
    }

    public int getStatus() {
        return status;
    }


    public static <T> CommonResponse<T> success(T data)
    {
        return new CommonResponse<>(SUCCESS_CODE, "success", data);
    }

    public static <T> CommonResponse<T> success() {
        return success(null);
    }

    public static <T> CommonResponse<T> error(int status, String msg)
    {
        return new CommonResponse<>(status, msg, null);
    }

    public static <T> CommonResponse<T> error(int status, String msg, T data)
    {
        return new CommonResponse<>(status, msg, data);
    }





    public T getData() {
        return data;
    }

    public String getMsg() {
        return msg;
    }

}
