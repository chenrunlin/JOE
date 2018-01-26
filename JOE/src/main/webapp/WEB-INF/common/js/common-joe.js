/*
* @title：common js method / 2017-12
* @author：JOE
* @version [version]
* @tips：1.部分方法需先加载layui库才能实现；
* @2.common-joe.js应该放在当前页面公共库文件下面，当前页面逻辑js的上面
**/

/* 初始化layui组件，(需在初始化之前加载layui.all.js) */
// var $ = layui.jquery, //日期
//     laydate = layui.laydate, //日期
//     laypage = layui.laypage, //分页
//     layer = layui.layer, //弹层
//     table = layui.table, //表格
//     element = layui.element, //元素操作
//     form = layui.form,
//     laytpl = layui.laytpl;

/**
* 接口地址
*/
var common_url = 'https://www.baidu.com/';
var img_common_url='https://www.baidu.com/';

/*时间戳*/
var timeStamp = new Date().getTime();

//文本框聚焦
function textFocus(obj) {
    $(obj).focus();
}

//未开发模块提示
function undevelopedPrompt()
{
    api.toast({msg: '攻城狮正在日夜开发中，敬请期待！',duration:1000,location: 'middle'});
}

//loading层
function loading() {
    var index = layer.load(1, {
        shade: [0.1,'#fff']  //0.1透明度的白色背景
    });
}

//加载中动画1
function loading1() {

}

//全局加载提示
function msg() {
    layer.msg('加载中···');
}




//返回上一页
function backPre() {
    history.go(-1);
    //history.back();
}

//返回下一页
function backNext() {
    history.go(1);
    //window.history.forward();
}

//返回启动页（index）
function backIndex() {
    location.href = "";
}

//返回首页（main）
function backMain() {
    location.href = "";
}

//刷新
function reload() {
    location.reload();
}


/*
* 正则验证 **********************************************************************
* */
//非空判断
function testEmpty(e) {
    if(e === ""){
        layer.open({
            type: 1,
            title: false,
            skin: 'layui-layer-demo', //样式
            closeBtn: 1,    //0不显示关闭按钮
            anim: 2,
            shadeClose: true,  //遮罩关闭
            content: '不能为空！'
        });
    }
}

//手机号码
var isMobile = /^([1][34578]+\d{9})$/;
function regPhone(e) {
    if(!isMobile.test(e)){
        alert("手机号码格式有误！");  //这里需要添加统一的UI弹出框提示
    }
}

//邮箱
var isEmail = new RegExp("^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$");
function regEmail(e) {
    if(!isEmail.test(e)){
        alert("邮箱格式有误！");
    }
}

//中文
var isChinese = /^[\u4e00-\u9fa5]*$/;
function regChinese(e) {
    if(!isChinese.test(e)){
        alert("请输入中文！");
    }
}

//MAC地址
var macReg = /^[A-Fa-f0-9]{2}[-|:][A-Fa-f0-9]{2}[-|:][A-Fa-f0-9]{2}[-|:][A-Fa-f0-9]{2}[-|:][A-Fa-f0-9]{2}[-|:][A-Fa-f0-9]{2}$/;
function regMac(e) {
    if(!macReg.test($.trim(e))){
        alert("mac有误！");
    }
}

//格式化当前时间为YYYY-MM-DD形式
function getNowFormatDate()
{
    var day = new Date();
    var Year = 0;
    var Month = 0;
    var Day = 0;
    var CurrentDate = "";
    //初始化时间
    //Year= day.getYear();//有火狐下2008年显示108的bug
    Year= day.getFullYear();//ie火狐下都可以
    Month= day.getMonth()+1;
    Day = day.getDate();
    CurrentDate += Year + "-";
    if (Month >= 10 )
    {
        CurrentDate += Month + "-";
    }
    else
    {
        CurrentDate += "0" + Month + "-";
    }
    if (Day >= 10 )
    {
        CurrentDate += Day ;
    }
    else
    {
        CurrentDate += "0" + Day ;
    }
    return CurrentDate;
}

/* input 一键清除 */
/*var input = document.getElementsByClassName('ipt-clr');
var input_clear = document.getElementsByClassName('ipt_clr_btn');
input.onfocus = function () {
    this.nextSibling.style.display = "block";
};
input.onblur = function () {
    if(this.value == ""){
        this.nextSibling.style.display = "none";
    }
};
input_clear.onclick = function () {
    this.nextSibling.value = "";
    this.style.display = "none";
};*/


$("input").focus(function(){
    $(this).parent().children(".ipt_clr_btn").show();
});
$("input").blur(function() {
    if($(this).val()=='')
    {
        $(this).parent().children(".ipt_clr_btn").hide();
    }
});

$(".ipt_clr_btn").click(function(){
    $(this).parent().find('input').val('');
    $(this).hide();
});


