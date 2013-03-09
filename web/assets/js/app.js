/**
 * Created with PyCharm.
 * User: not
 * Date: 13-3-6
 * Time: 下午4:45
 * To change this template use File | Settings | File Templates.
 */


var app = {};
app.model = new Backbone.Model({
    location: ""
});
var BlogModel = Backbone.Model.extend({
    url: "/blog"
});
var BlogCollection = Backbone.Collection.extend({
    url: "/blog",
    model: BlogModel
});
app.model.set({blogs:new BlogCollection()});

var Dialog = Backbone.View.extend({
    el: "#dialog",

    defaults: {
        header: "",

        body: "",

        footer: '<button class="btn btn-close">Close</button>' +
            '<button class="btn btn-primary">confirm</button>'
    },

    events: {
        "click .close,.btn-close": "hide",
        "click .btn-primary": "confirm"
    },

    initialize: function(){
        this.model.on("change",this.change,this)
    },

    change: function(){
        var location = this.model.get("location");
        if(!_.contains(["login","post"],location)) return this.hide();
        var me = this;
        ({
            login: function(){
                me.show({
                    header: "登陆",

                    body: '<label><input type="text" name="email"></label>' +
                        '<label><input type="password" name="password"></label>'
                });
                me.afterconfirm =  function(){
                    $.ajax({
                        type: "post",
                        url: "/login",
                        data: {
                            email: me.$('input[name="email"]').val(),
                            password: me.$('input[name="password"]').val()
                        },
                        success: function(data){
                            console.log(data);
                            if(data.result && data.message.role == "admin"){
                                me.hide();
                            }
                        }
                    });
                }
            },

            post: function(){
                var blog = new BlogModel();
                console.log("sssss")
                me.show({
                    header: "post",

                    body: '<label><input type="text" name="title"></label>' +
                        '<label><textarea name="content"></textarea></label>'
                });
                me.$('input[name="title"]').blur(function(e){
                    blog.set({title: me.$('input[name="title"]').val()});
                    console.log(blog);
                });
                me.$('textarea[name="content"]').blur(function(e){
                    blog.set({content: me.$('textarea[name="content"]').val()});
                    console.log(blog);
                });
                me.afterconfirm = function(){
                    blog.save({
                        title: blog.get("title"),
                        content: blog.get("content")
                    },{
                        success: function(model, resp, options){
                            console.log(model);
                            console.log(resp);
                            console.log(options);
                        }
                    });
                }
            }
        })[location]();
    },

    confirm: function(){
        this.afterconfirm();
    },

    show: function(options){
        if(options && options.confirm){
            if(options.confirm) this.afterconfirm = options.afterconfirm;
            if(options.afterShow) options.afterShow();
        }
        this.fill(options);
        this.$(".modal").addClass("in");
        this.$(".modal-backdrop").addClass("in").removeClass("hide");
    },

    hide: function(){
        this.$(".modal").removeClass("in");
        this.$(".modal-backdrop").removeClass("in").addClass("hide");
    },

    fill: function(options){
        var fills = options || {};
        this.header = fills.header || this.header;
        this.body = fills.body || this.body;
        this.$(".title").html(this.header);
        this.$(".modal-body").html(this.body);
    }
});

var Nav = Backbone.View.extend({
    el: ".navbar"
});
var SideNav = Backbone.View.extend({
    el: "#side_nav"
});
var BlogListView = Backbone.View.extend({
    el: "#blog_list",

    Row: Backbone.View.extend({
        template: _.template(   '<div data-id=<%= id %>>' +
                                    '<h3 class="blog-title"><%= title %></h3>' +
                                    '<div class="blog-content"><%= content %></div>' +
                                '</div>'),
        tagName: "li",

        initialize: function(){
            this.$el.html(this.template(this.model.toJSON()));
        }
    }),

    initialize: function(){
        this.$el.html("<ul></ul>");

        this.collection = app.model.get("blogs");
        this.collection.on("add",this.add,this);
    },

    add: function(){
        var row = new this.Row({model: this.collection.at(this.collection.length - 1)});
        this.$("ul").prepend(row.$el);
    },

    render: function(){
        var me = this;
        this.$("ul").html("");
        this.collection.forEach(function(blog){
            me.$("ul").prepend(new me.Row({model: blog}));
        });
    },

    unrender: function(){
    }
});

app.dialog = new Dialog({model: app.model});
app.nav = new Nav({model: app.model});
app.sideNav = new SideNav({model: app.model});
app.blogListView = new BlogListView({model: app.model});

$(function(){
    app.model.get("blogs").fetch({
        success: function(collection, resp, options){
        }
    });
});

app.Router = Backbone.Router.extend({

    routes: {
        "login": "login",
        "post": "post"
    },

    login: function(){
        app.model.set({
            location: "login"
        })
    },

    post: function(){
        app.model.set({
            location: "post"
        })
    }
});

new app.Router();
Backbone.history.start();




