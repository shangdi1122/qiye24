package qiye.util;

/**
 * Created by THINKPAD on 2017/9/17.
 */
public class Message {

    private String code;
    private String msg;

    public static Message success() {
        Message message = new Message();
        message.setCode("0000");
        message.setMsg("操作成功");
        return message;
    }

    public static Message error() {
        Message message = new Message();
        message.setCode("0001");
        message.setMsg("操作失败");
        return message;
    }
    @Override
    public String toString() {
        return "Message{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Message() {
    }

    public Message(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
