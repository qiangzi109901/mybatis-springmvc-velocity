

define('Article',['jquery','mtemplate','util','infinite'],function($,mtemplate,util,Infinite){

    var Article = {
        config : {
            url : {
                page : '/data/article/query'
            }
        },
        init : function(){
             new Infinite({
                container : "#page_list",
                pagination : "#pagination",
                item : ".article_item",
                autoTimes : 100,
                nCurrentPage : 1, //当前页数
                nPageSize : 25, //每页条数'
                fnLoadData : function(page,infinite){
                    var data = util.postAndGet(Article.config.url.page,{'page':page,'pageSize':infinite.pageSize});
                    if(data == null){
                        return '';
                    }
                    return mtemplate.render('temp_item',{'articles':data});
                }
            })
        }
    };

    return Article;
});


require(['Article'], function(Article){
    Article.init();
});

