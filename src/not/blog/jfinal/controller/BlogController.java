package not.blog.jfinal.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.ext.interceptor.Restful;
import com.jfinal.kit.JsonKit;
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

    }

    //GET		/Blog/id		--->	show
    public void show(){

    }

    //POST		/Blog			--->	save
    public void save(){
        JsonObject body = RequestKit.getBody(getRequest()).getAsJsonObject();
        String title = body.get("title").getAsString();
        String content = body.get("content").getAsString();
        Blog blog = new Blog();
        blog.set("title",title);
        blog.set("content",content);
        blog.save();
        renderJson(blog);
    }

    //PUT		/Blog/id		--->	update
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
    public void delete(){

    }
}
