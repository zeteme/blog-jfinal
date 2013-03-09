package not.blog.jfinal.model;

import com.jfinal.plugin.activerecord.Model;

/**
 * Created with IntelliJ IDEA.
 * User: not
 * Date: 13-3-9
 * Time: 下午5:18
 * To change this template use File | Settings | File Templates.
 */
public class User{

    private String role;

    public void setRole(String role){
        this.role = role;
    }

    public String getRole(){
        return this.role;
    }
}
