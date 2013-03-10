package not.blog.jfinal.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.ext.interceptor.Restful;
import com.jfinal.kit.JsonKit;
import com.jfinal.plugin.activerecord.ActiveRecordException;
import not.blog.jfinal.interceptor.SecureInterceptor;
import not.blog.jfinal.kit.RequestKit;
import not.blog.jfinal.model.Blog;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: not
 * Date: 13-3-9
 * Time: 下午4:18
 * To change this template use File | Settings | File Templates.
 */

@Before({Restful.class})
public class BlogController extends Controller{

    //GET		/Blog			--->	index
    public void index(){
        renderJson(Blog.dao.paginate(1,10,"SELECT *","FROM blog").getList());
    }

    //GET		/Blog/id		--->	show
    public void show(){

    }

    //POST		/Blog			--->	save
    @Before({SecureInterceptor.class})
    public void save(){
        JsonObject body = RequestKit.getBody(getRequest()).getAsJsonObject();
        String title = null;
        String content = null;
        title = body.get("title").getAsString();
        content = body.get("content").getAsString();
        Blog blog = new Blog();
        blog.set("title",title);
        blog.set("content",content);
        try {
            blog.save();
            renderJson(blog);
        }catch (ActiveRecordException e){
            JsonObject json = new JsonObject();
            json.addProperty("error",e.getMessage());
            renderJson(json.toString());
        }
    }

    //PUT		/Blog/id		--->	update
    @Before({SecureInterceptor.class})
    public void update(){
        JsonObject body = RequestKit.getBody(getRequest()).getAsJsonObject();
        int id = body.get("id").getAsInt();
        String title = body.get("title").getAsString();
        String content = body.get("content").getAsString();
        Blog blog = Blog.dao.findById(id);
        blog.set("title",title);
        blog.set("content",content);
        blog.update();
        renderJson(blog);
    }

    //DELECT	/Blog/id		--->	delete
    @Before({SecureInterceptor.class})
    public void delete(){

    }
}
