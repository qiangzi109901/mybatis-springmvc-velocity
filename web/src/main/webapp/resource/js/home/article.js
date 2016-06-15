

require(['jquery','prism'],function($){
    Prism.highlightAll();


    var flag = "RUN";
    var period = 80;
    var timer = run();
    function run(){
        return setInterval(function(){
            var top = $(window).scrollTop();
            top ++;
            showT();
            if(flag == "STOP"){
                clearInterval(timer);
                period = 100;
                timer = run();
            }
            else if(flag == "RESUME"){
                clearInterval(timer);
                period = 80;
                timer = run();
            }
            $(window).scrollTop(top)
        }, period);
    }

    function showT(){
        $("pre").each(function(){
            if($(window).scrollTop() + 100 == $(this).offset().top){
                flag = "STOP";
            }
            else if($(window).scrollTop() - $(this).height() == $(this).offset().top){
                flag = "RESUME";
            }
        });
    }

    function getTimes(str){
       return str.length * 0.1;
    }
});