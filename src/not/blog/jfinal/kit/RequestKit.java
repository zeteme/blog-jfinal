package not.blog.jfinal.kit;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;

/**
 * Created with IntelliJ IDEA.
 * User: not
 * Date: 13-3-9
 * Time: 下午11:41
 * To change this template use File | Settings | File Templates.
 */
public class RequestKit {
    public static JsonElement getBody(HttpServletRequest request){
        JsonParser jsonParser = new JsonParser();
        JsonElement body = null;
        try {
            body = jsonParser.parse(request.getReader());
        }catch (Exception e){
            body = new JsonObject();
        }
        return body;
    }
}
