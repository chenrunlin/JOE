/*
* 项目JS主入口（模块化的用法）
*
* Joe Jackson 2017-12-22
* */
layui.define(['jquery','laypage', 'layer', 'table', 'element', 'form' ,'laytpl' ], function(exports){
    var $ = layui.jquery,
        laydate = layui.laydate,
        laypage = layui.laypage,
        layer = layui.layer,
        table = layui.table,
        element = layui.element,
        form = layui.form,
        laytpl = layui.laytpl;

    exports('index', {}); //注意，这里是模块输出的核心，模块名必须和use时的模块名一致
});
