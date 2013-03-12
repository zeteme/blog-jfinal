package not.blog.jfinal.controller;

import com.jfinal.core.Controller;
import not.blog.jfinal.model.Category;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: not
 * Date: 13-3-12
 * Time: 下午12:44
 * To change this template use File | Settings | File Templates.
 */
public class CategoryController extends Controller{
    public void index(){
        List<Category> categories = Category.dao.find("SELECT * FROM category");
    }
}
