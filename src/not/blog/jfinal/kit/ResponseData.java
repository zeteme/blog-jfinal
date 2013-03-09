package not.blog.jfinal.kit;

/**
 * Created with IntelliJ IDEA.
 * User: not
 * Date: 13-3-9
 * Time: 下午4:59
 * To change this template use File | Settings | File Templates.
 */
public class ResponseData {
    private boolean result;
    private Object message;


    public void setResult(boolean result) {
        this.result = result;
    }

    public boolean isResult(){
        return this.result;
    }

    public void setMessage(Object message){
        this.message = message;
    }

    public Object getMessage(){
        return this.message;
    }

    public ResponseData set(boolean result){
        this.result = result;
        return this;
    }

    public ResponseData set(Object message){
        this.message = message;
        return this;
    }

}
