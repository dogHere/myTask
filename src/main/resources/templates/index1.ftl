<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="/webjars/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="webjars/jquery/3.4.0/jquery.min.js"></script>
    <script src="webjars/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <#--标题-->
    <div class="row">
        <div class="col-12">
            <h1>Task2  交互页面</h1>
        </div>
    </div>
    <#--查询按钮，添加按钮-->
    <div class="row">
            <div class="col-md-4 col-md-offset-10">
                <button class="btn btn-primary">新增</button>
                <button class="btn btn-primary">查询</button>
            </div>
    </div>
    <#--数据表格-->
    <div class="row">
        <div class="col-md-12">
            <table class="table table-hover">
                <tr>
                    <td>id</td>
                    <td>name</td>
                    <td>age</td>
                    <td>address</td>
                    <td>hobby</td>
                    <td>discription</td>
                    <td>操作</td>
                </tr>
                <#list list as val>
                    <tr>
                        <td>${val.id}</td>
                        <td>${val.name}</td>
                        <td>${val.age}</td>
                        <td>${val.address}</td>
                        <td>
                            <#list val.hobby as l>
                                ${l}
                            </#list>
                        </td>

                        <td>
                            <#list val.description?values as value>
                                ${value}
                            </#list>
                        </td>
                        <td>
                            <button class="btn btn-primary">
                                <span class="glyphicon glyphicon-pencil" aria-hidden="true">修改</span>
                            </button>
                        </td>
                    </tr>
                </#list>
            </table>
        </div>
    </div>

    <#--统计页面-->
    <div class="row">
        <#--分页文字信息-->
        <div class="col-md-6">
            当前记录数
        </div>
        <#--分页条信息-->
        <div class="col-md-6 col-md-offset-8">
            <nav aria-label="Page navigation">
                <ul class="pagination">
                    <li><a href="#">首页</a></li>
                    <li>
                        <a href="#" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                    <li><a href="#">1</a></li>
                    <li><a href="#">2</a></li>
                    <li><a href="#">3</a></li>
                    <li><a href="#">4</a></li>
                    <li><a href="#">5</a></li>
                    <li>
                        <a href="#" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                    <li><a href="#">末页</a></li>
                </ul>
            </nav>
        </div>
    </div>

    <#--统计页面-->
    <div class="row">
        统计页面
    </div>
</div>
<script type="text/javascript">
    //页面加载完成的以后，直接发送ajax请求，要到数据
    $(function () {
        $.ajax({
            url:"http://localhost:8080/index1",
            type:"GET",
            success:function (result) {
                //console.log(result);
                //解析json
                user_table(result);
            }
        });
    });
    function user_table(result) {
        $.each(result,function (index,item) {
            alert(item.name)
        });
    }
</script>
</body>
</html>