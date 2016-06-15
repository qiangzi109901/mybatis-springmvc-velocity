package cn.jmo.hello.helper;

import java.io.Serializable;

/**
 * Created by qiangzi on 16/6/11.
 */
public class JsonResult implements Serializable{

    private static final long serialVersionUID = 2835203657762600856L;
    private String message;
    private boolean success;
    private Object data;

    public JsonResult(){
        this.success = true;
    }
    public JsonResult(boolean success){
        this.success = success;
    }
    public JsonResult(boolean success, String message){
        this.success = success;
        this.message = message;
    }
    public JsonResult(Object data){
        this.success = true;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
