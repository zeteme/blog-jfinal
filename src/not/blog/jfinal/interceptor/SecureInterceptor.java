package not.blog.jfinal.interceptor;

import com.google.gson.JsonObject;
import com.jfinal.aop.Interceptor;
import com.jfinal.core.ActionInvocation;
import com.jfinal.core.Controller;
import not.blog.jfinal.model.User;

/**
 * Created with IntelliJ IDEA.
 * User: not
 * Date: 13-3-10
 * Time: 下午5:42
 * To change this template use File | Settings | File Templates.
 */
public class SecureInterceptor implements Interceptor{
    @Override
    public void intercept(ActionInvocation ai) {
        Controller controller = ai.getController();
        if (controller.getSessionAttr("user") != null && "admin".equals(controller.<User>getSessionAttr("user").getRole())){
            ai.invoke();
        }else {
            JsonObject json = new JsonObject();
            json.addProperty("status",405);
            json.addProperty("result",false);
            json.addProperty("error","405");
            controller.renderJson(json.toString());
        }
    }
}
