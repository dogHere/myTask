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

<#--用户修改的模态框-->
<div class="modal fade" tabindex="-1" role="dialog" id="userUpdateModel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">用户修改</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="userUpdateForm" >
                    <input type="hidden" name="_method" value="PUT">

                    <div class="form-group">
                        <label class="col-sm-2 control-label">userId:</label>
                        <div class="col-sm-10">
                            <p class="form-control-static" id="id_update_static"></p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">username:</label>
                        <div class="col-sm-10">
                            <input type="text" name="name" class="form-control" id="user_update_name" placeholder="username">
                            <#--<p class="form-control-static" id="name_update_static"></p>-->
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">age:</label>
                        <div class="col-sm-10">
                            <input type="text" name="age" class="form-control" id="user_update_age" placeholder="userage">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">useraddress:</label>
                        <div class="col-sm-10">
                            <input type="text" name="address" class="form-control" id="user_update_address" placeholder="useraddress">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">userhobby:</label>
                        <div class="col-sm-10">
                            <input type="text" name="hobby" class="form-control" id="user_update_hobby" placeholder="填入格式：hobby1;hobby2;...">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">description:</label>
                        <div class="col-sm-10">
                            <input type="text" name="discription" class="form-control" id="user_update_description" placeholder="填入格式：key1:value1;key2:value2;....">
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-sm-10">
                            <p id="error_update_tip"></p>
                        </div>
                    </div>

                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="submit" class="btn btn-primary" id="user_update_btn">Save changes</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<#--用户添加的模态框-->
<div class="modal fade" tabindex="-1" role="dialog" id="userAddModel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">用户添加</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="userAddForm" >

                    <div class="form-group">
                        <label class="col-sm-2 control-label">userId:</label>
                        <div class="col-sm-10">
                            <input type="text" name="id" class="form-control" id="user_add_id" placeholder="userid">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">username:</label>
                        <div class="col-sm-10">
                            <input type="text" name="name" class="form-control" id="user_add_name" placeholder="username">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">age:</label>
                        <div class="col-sm-10">
                            <input type="text" name="age" class="form-control" id="user_add_age" placeholder="userage">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">useraddress:</label>
                        <div class="col-sm-10">
                            <input type="text" name="address" class="form-control" id="user_add_address" placeholder="useraddress">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">userhobby:</label>
                        <div class="col-sm-10">
                            <input type="text" name="hobby" class="form-control" id="user_add_hobby" placeholder="填入格式：hobby1;hobby2;...">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">description:</label>
                        <div class="col-sm-10">
                            <input type="text" name="discription" class="form-control" id="user_add_description" placeholder="填入格式：key1:value1;key2:value2;....">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-10">
                            <p id="error_add_tip"></p>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="submit" class="btn btn-primary" id="user_save_btn">Save changes</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<div class="container">
    <#--标题-->
    <div class="row">
        <div class="col-12">
            <h1>Task2  交互页面</h1>
        </div>
    </div>
    <#--查询按钮，添加按钮-->
    <div class="row">
        <div class="col-md-2">
            <button class="btn btn-info" id="user_add_model">新增</button>&nbsp;
        </div>
        <div class="col-md-6 col-md-offset-4">
                查询条件:<select name="tj" id="tiaojian">
                    <option value="id">id</option>
                    <option value="name">name</option>
                    <option value="age">age</option>
                    <option value="address">address</option>
                </select>&nbsp;
                条件内容:<input type="text" name="val" id="check_val">
                <button class="btn btn-primary" id="check_btn">查询</button>
        </div>
    </div>
    <#--数据表格-->
    <div class="row">
        <div class="col-md-12">
            <table class="table table-hover" id="user_table">
                <thead>
                    <tr>
                        <td>id</td>
                        <td>name</td>
                        <td>age</td>
                        <td>address</td>
                        <td>hobby</td>
                        <td>discription</td>
                        <td>操作</td>
                    </tr>
                </thead>
                <tbody id="tb">

                </tbody>
            </table>
        </div>
    </div>

    <#--统计页面-->
    <div class="row">
        <#--分页文字信息-->
        <div class="col-md-6">
            当前记录数:n
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
        <a href="#">年龄统计图</a>
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
            var userId = $("<td></td>").append(item.id);
            var userName = $("<td></td>").append(item.name);
            var userAge = $("<td></td>").append(item.age);
            var userAddress = $("<td></td>").append(item.address);
            //遍历数组
            var re = "";
            $.each(item.hobby,function (index,item) {
                //分号做分割
                re += item +"; ";
            });
            var userHobby = $("<td></td>").append(re);
            re = "";
            //遍历嵌套对象
            $.each(item.description,function (index,item) {
                //分号做分割
                re += item +"; ";
            });
            var userDescription = $("<td></td>").append(re);
            //按钮
            var editBtn = $("<button></button>").addClass("btn btn-primary edit_btn").append("<span></span>").addClass("glyphicon glyphicon-pencil").append("修改");
            //为编辑按钮添加自定义属性，自定义属性的值就是id
            editBtn.attr("edit-id",item.id);
            //添加对象
            $("<tr></tr>").append(userId).append(userName).append(userAge).append(userAddress).append(userHobby).append(userDescription).append(editBtn).appendTo("#user_table tbody");
        });
    }

    //点击新增按钮，打开模态框
    $("#user_add_model").click(function(){
        $("#userAddModel").modal({
            backdrop:"static",
            keyboard:true
        });
        //将模态框中的数据置为空
        $("#user_add_id").val("");
        $("#user_add_name").val("");
        $("#user_add_age").val("");
        $("#user_add_address").val("");
        $("#user_add_hobby").val("");
        $("#user_add_description").val("");
        $("#error_tip").html("");
    })

    //模态框点击保存按钮
    $("#user_save_btn").click(function () {
        //先进行数据校验
        var temp = $("#user_add_description").val();
        var rex = new RegExp(/([\u4E00-\u9FA5A-Za-z0-9_]+:[\u4E00-\u9FA5A-Za-z0-9_]+;)+/)
        if(!rex.test(temp)){
            $("#error_add_tip").css("color","red").html("description格式错误！请重新输入！");
            return;
        }else{
            $("#error_add_tip").html("");
        }
        //模态框中的表单数据，提交给服务器
        var params = $("#userAddForm").serialize();
        params = decodeURIComponent(params,true);
        $.post("http://localhost:8080/user",params,function () {
            alert("发送成功！");
            $("#userAddModel").modal("hide");
            $("#tb").html("");
            $.ajax({
                url:"http://localhost:8080/index1",
                type:"GET",
                success:function (result) {
                    user_table(result);
                }
            });
        });
        /*$.ajax({
            url: "http://localhost:8080/user",
            type:"POST",
            data:params,
            success:function (result) {
                alert("添加成功！");
                $("#userAddModel").modal("hide");
                $("#tb").html("");
                $.ajax({
                    url:"http://localhost:8080/index2",
                    type:"GET",
                    success:function (result) {

                    }
                });
            }
        });*/

        /*$("#userAddForm").submit();
        alert("添加成功！");
        $("#userAddModel").modal('hide');
        $("#tb").html("");
        $.ajax({
            url:"http://localhost:8080/index2",
            type:"GET",
            success:function (result) {
                //解析json
                user_table(result);
            }
        });*/
    });

    //不能用click方法的原因是，按钮在创建之前就绑定了click，所以绑定不上
    $(document).on("click",".edit_btn",function () {
        //根据id找到对应的User数据,并将数据添加到接下来弹出的模态框中
        getUser($(this).attr("edit-id"));

        //把用户的id传递给模态框的更新按钮
        $("#user_update_btn").attr("edit-id",$(this).attr("edit-id"));
        //弹出模态框
        $("#userUpdateModel").modal({
            backdrop:"static",
            keyboard:true
        });
    });

    //修改员工前需要先获得员工共信息，将所有信息显示到模态框中
    function getUser(id) {
        $.ajax({
            url:"http://localhost:8080/user/" + id,
            type:"GET",
            success:function (result) {
                $("#id_update_static").text(result.id);
                $("#user_update_name").val(result.name);
                $("#user_update_age").val(result.age);
                $("#user_update_address").val(result.address);
                var re = "";
                $.each(result.hobby,function (index,item) {
                    re += item + ";";
                });
                re = "";
                $.each(result.hobby,function (index,item) {
                    re += item + ";";
                });
                $("#user_update_hobby").val(re);
                $("#user_update_description").val(re);
            }
        });
    }

    //更新数据
    $("#user_update_btn").click(function () {
        //先进行数据校验
        var temp = $("#user_update_description").val();
        var rex = new RegExp(/([\u4E00-\u9FA5A-Za-z0-9_]+:[\u4E00-\u9FA5A-Za-z0-9_]+;)+/)
        if(!rex.test(temp)){
            $("#error_update_tip").css("color","red").html("description格式错误！请重新输入！");
            return;
        }else{
            $("#error_update_tip").html("");
        }
        //发送ajax请求，保存更新的数据
        var params = $("#userUpdateForm").serialize();
        params = decodeURIComponent(params,true);
        $.ajax({
            url:"http://localhost:8080/update/"+$(this).attr("edit-id"),
            type:"POST",
            data:params,
            success:function (result) {
                alert("修改成功！");
                $("#userUpdateModel").modal("hide");
                $("#tb").html("");
                $.ajax({
                    url:"http://localhost:8080/index1",
                    type:"GET",
                    success:function (result) {
                        user_table(result);
                    }
                });
            }
        });
    });
    $("#check_btn").click(function () {
        /*var params = $("#check_form").serialize();
        alert(params);
        params = decodeURIComponent(params,true);
        alert(params);*/
        var tj = $("#tiaojian option:selected").text();
        var val = $("#check_val").val();
        $.ajax({
            url:"/check?tj="+tj + "&val=" + val,
            type:"GET",
            success:function (result) {
                $("#tb").html("");
                user_table(result);
            }
        });
    });
</script>
</body>
</html>