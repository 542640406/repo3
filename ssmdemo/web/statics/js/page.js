function next() {
    $("button[no]").click(function () {
        //获取no的值
        var no=$(this).attr("no");
        var url=location.href;
        var  urlArray=url.split("?");
        var url1=urlArray[0];
        //序列化查询表单
        var data=$("#searchForm").serialize();
        location.href=url1+"?pageNum="+no+"&"+data
    })
}