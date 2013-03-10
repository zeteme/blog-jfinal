package not.blog.jfinal.controller;

import com.google.gson.Gson;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.ext.interceptor.POST;
import not.blog.jfinal.kit.ResponseData;
import not.blog.jfinal.model.User;
import org.apache.commons.codec.digest.DigestUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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

    @Before({POST.class})
    public void login(){
        User user = new User();
        String username = getPara("username");
        String password = getPara("password");
        if ("eb1f09cd3fee9caf7ea15d9e8f941edc".equals(DigestUtils.md2Hex(password.getBytes())) &&
            "3e3e6b0e5c1c68644fc5ce3cf060211d".equals(DigestUtils.md2Hex(password.getBytes()))){
            user.setRole("admin");
        }else {
            user.setRole("guest");
        }
        setSessionAttr("user",user);
        renderJson(new ResponseData().set(true).set(user));
    }
}
