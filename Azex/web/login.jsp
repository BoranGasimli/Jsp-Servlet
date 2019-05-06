<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <jsp:include page="WEB-INF/jsp/common/meta.jsp"/>
    <title>Admincast bootstrap 4 &amp; angular 5 admin template, Шаблон админки | Login</title>
    <jsp:include page="WEB-INF/jsp/common/css.jsp"/>
    <!-- PAGE LEVEL STYLES-->
    <link href="./assets/css/pages/auth-light.css" rel="stylesheet" />
</head>

<body class="bg-silver-300">
<div class="content">
    <div class="brand">
        <a class="link" href="index.jsp">AZEX</a>
    </div>
    ${sessionScope.errorMessage}
    <form id="login-form" action="login" method="post">
        <h2 class="login-title">Log in</h2>
        <div class="form-group">
            <div class="input-group-icon right">
                <div class="input-icon"><i class="fa fa-envelope"></i></div>
                <input class="form-control" type="email" name="email" placeholder="Email" autocomplete="off">
            </div>
        </div>
        <div class="form-group">
            <div class="input-group-icon right">
                <div class="input-icon"><i class="fa fa-lock font-16"></i></div>
                <input class="form-control" type="password" name="password" placeholder="Password">
            </div>
        </div>
        <div class="form-group d-flex justify-content-between">
            <label class="ui-checkbox ui-checkbox-info">
                <input type="checkbox">
                <span class="input-span"></span>Remember me</label>
            <a href="forgot_password.html">Forgot password?</a>
        </div>
        <div class="form-group">
            <button class="btn btn-info btn-block" type="submit">Login</button>
        </div>
        <div class="social-auth-hr">
            <span>Or login with</span>
        </div>
        <div class="text-center social-auth m-b-20">
            <a class="btn btn-social-icon btn-twitter m-r-5" href="javascript:;"><i class="fa fa-twitter"></i></a>
            <a class="btn btn-social-icon btn-facebook m-r-5" href="javascript:;"><i class="fa fa-facebook"></i></a>
            <a class="btn btn-social-icon btn-google m-r-5" href="javascript:;"><i class="fa fa-google-plus"></i></a>
            <a class="btn btn-social-icon btn-linkedin m-r-5" href="javascript:;"><i class="fa fa-linkedin"></i></a>
            <a class="btn btn-social-icon btn-vk" href="javascript:;"><i class="fa fa-vk"></i></a>
        </div>
        <div class="text-center">Not a member?
            <a class="color-blue" href="register.html">Create accaunt</a>
        </div>
    </form>
</div>

<jsp:include page="WEB-INF/jsp/common/paga.jsp"/>


<jsp:include page="WEB-INF/jsp/common/script.jsp"/>


<!-- PAGE LEVEL SCRIPTS-->
<script type="text/javascript">
    $(function() {
        $('#login-form').validate({
            errorClass: "help-block",
            rules: {
                email: {
                    required: true,
                    email: true
                },
                password: {
                    required: true
                }
            },
            highlight: function(e) {
                $(e).closest(".form-group").addClass("has-error")
            },
            unhighlight: function(e) {
                $(e).closest(".form-group").removeClass("has-error")
            },
        });
    });
</script>
</body>

</html>