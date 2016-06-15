require(['dialog','frame','message']);

define('User',['admin/common','jquery','util','comjax','mtemplate','mselect2','casecade','pager'],function(common,$,util,comjax,mtemplate,mselect2,casecade){

    var User = {
        config : {
            model : 'User',
            url : {
                add : '/user/add',
                update : '/user/update',
                delete : '/user/delete',
                pagequery : '/user/pagequery'
            },
            search : {
                page : 1,
                pageSize : 10
            }
        },
        init : function(){
            this.initPager();
            common.bindA(this);
            common.bindS(this);
            common.search(this);
        },
        initPager : function(){
            window.pager = new Pager("#mypage",{
                fnJump : function(page){
                    common.search(User, page);
                }
            });
        },
        search : function(){
            common.search(User);
        }
    }
    return User;
});


require(['User'],function(User){
    User.init();
});