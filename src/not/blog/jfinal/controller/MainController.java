package not.blog.jfinal.controller;

import com.google.gson.Gson;
import com.jfinal.core.Controller;
import not.blog.jfinal.kit.ResponseData;
import not.blog.jfinal.model.User;

/**
 * Created with IntelliJ IDEA.
 * User: not
 * Date: 13-3-9
 * Time: 下午4:37
 * To change this template use File | Settings | File Templates.
 */
public class MainController extends Controller{
    public void index(){
        render("common/main.html");
    }

    public void login(){
        User user = new User();
        user.setRole("admin");
        renderJson(new ResponseData().set(true).set(user));
    }
}
