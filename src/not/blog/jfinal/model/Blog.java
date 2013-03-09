package not.blog.jfinal.model;

import com.jfinal.plugin.activerecord.Model;

/**
 * Created with IntelliJ IDEA.
 * User: not
 * Date: 13-3-9
 * Time: 下午4:16
 * To change this template use File | Settings | File Templates.
 */
public class Blog extends Model<Blog>{
    public static final Blog dao = new Blog();
}
