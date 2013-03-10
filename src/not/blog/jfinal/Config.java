package not.blog.jfinal;

import com.jfinal.config.*;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.render.ViewType;
import not.blog.jfinal.controller.BlogController;
import not.blog.jfinal.controller.MainController;
import not.blog.jfinal.model.Blog;

/**
 * Created with IntelliJ IDEA.
 * User: not
 * Date: 13-3-9
 * Time: 下午3:48
 * To change this template use File | Settings | File Templates.
 */
public class Config extends JFinalConfig{
    @Override
    public void configConstant(Constants me) {
        me.setDevMode(true);
        me.setViewType(ViewType.JSP);
    }

    @Override
    public void configRoute(Routes me) {
        me.add("/", MainController.class);
        me.add("/blog", BlogController.class);
    }

    @Override
    public void configPlugin(Plugins me) {
        C3p0Plugin cp = new C3p0Plugin("jdbc:mysql://localhost:3306/blog?characterEncoding=utf8","root","password");
        me.add(cp);
        ActiveRecordPlugin arp = new ActiveRecordPlugin(cp);
        me.add(arp);

        arp.addMapping("blog", Blog.class);
    }

    @Override
    public void configInterceptor(Interceptors me) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void configHandler(Handlers me) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
