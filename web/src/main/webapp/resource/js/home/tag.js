
define('Tag',['jquery','mtemplate','util','pager'],function($,mtemplate,util){
    var Tag = {
        config : {
            url : {
                'getHotestTag' : '/data/tag/hotest'
            }
        },
        init : function(){
            this.renderTags();
        },
        renderTags : function(){
            var tags = util.postAndGet(Tag.config.url.getHotestTag);
            $("#tag_content").html(mtemplate.render('temp_tags', {'tags' : tags}));
        },
        initArticlePagination : function(){
            window.pager = new Pager("#pagination",{
                nTotal : $("#page_total").val(),   // 总数量
                nCurrentPage : $("#page_now").val(), //当前页数
                nPageSize : $("#page_size").val(),  //每页显示的数量
                nTheme : 2,  //分页主题
                nItems : 8, //主题2的每页显示的数量
                bFirst : false,
                fnJump : function(page, pager){
                    location.href = "/tag/" + $("#cur_tag").val() + "/" + page;
                }
            })
        }
    };
    return Tag;
});
require(['Tag','jquery'], function(Tag,$){
    var pagejs = $("#pagejs").val() || 'init';
    Tag[pagejs]();
});