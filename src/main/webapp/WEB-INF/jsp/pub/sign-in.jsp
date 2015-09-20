<%@ page session="false"%><%@ page contentType="text/plain;charset=UTF-8" language="java" %><!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:useBean id="langProperty" class="apollo.datastore.utils.RequestPropertyVariableBean" />
<jsp:setProperty name="langProperty" property="name" value="LANG" />
<jsp:setProperty name="langProperty" property="value" value="${requestScope[langProperty.name]}" />
<fmt:setLocale value="${langProperty.value}" />
<fmt:setBundle basename="apollo.datastore.utils.i18n.SignInBundle" var="signInBundle" />

<jsp:useBean id="userIdVariable" class="apollo.datastore.utils.FormVariableBean" />
<jsp:setProperty name="userIdVariable" property="name" value="USER_ID" />
<jsp:useBean id="passwordVariable" class="apollo.datastore.utils.FormVariableBean" />
<jsp:setProperty name="passwordVariable" property="name" value="PASSWORD" />
<jsp:useBean id="rememberMeVariable" class="apollo.datastore.utils.FormVariableBean" />
<jsp:setProperty name="rememberMeVariable" property="name" value="REMEMBER_ME" />
<html>
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <title><fmt:message key="title" bundle="${signInBundle}" /></title>
        <!-- Bootstrap -->
        <link rel="stylesheet" href="/css/bootstrap.min.css" />
        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
        <script type="text/javascript" src="/js/jquery.min.js"></script>
        <script type="text/javascript" src="/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="/css/styles.css" />
        <script type="text/javascript">
$(document).ready(function() {
    $('#reset-password-request-link').attr('href', '/utils/reset-password-request');
    $('#register-link').attr('href', '/utils/register');
});
        </script>
    </head>
    <body>
<%@ include file="/WEB-INF/jspf/pub/top-navbar.jspf" %>
        <div class="page-header">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-xs-12 col-sm-offset-2 col-sm-8">
                        <div class="row"><h3 class="col-xs-12 col-sm-offset-3 col-sm-9"><fmt:message key="page_header" bundle="${signInBundle}" /></h3></div>
                    </div>
                </div>
            </div>
        </div>

        <main role="main">
        <div class="container-fluid">
            <div class="row">
                <div class="col-xs-12 col-sm-offset-2 col-sm-8">

                    <form name="sign-in-form" class="form-horizontal" id="sign-in-form" role="form">
                    <fieldset>
                    <div class="form-group">
                        <label class="col-xs-12 col-sm-3 control-label" for="user-id"><fmt:message key="user_id_label" bundle="${signInBundle}" /></label>
                        <div class="col-xs-12 col-sm-8"><input name="${userIdVariable.name}" type="text" class="form-control" id="user-id" maxlength="32" required autofocus /></div>
                    </div>

                    <div class="form-group">
                        <label class="col-xs-12 col-sm-3 control-label" for="password"><fmt:message key="password_label" bundle="${signInBundle}" /></label>
                        <div class="col-xs-12 col-sm-8"><input name="${passwordVariable.name}" type="password" class="form-control" id="password" maxlength="64" /></div>
                    </div>

                    <div class="form-group">
                        <div class="col-xs-12 col-sm-offset-3 col-sm-8">
                            <input id="submit-btn" type="button" class="btn btn-default" value="<fmt:message key='sign_in_button' bundle='${signInBundle}' />" />
                            <input id="clear-btn" type="reset" class="btn btn-default" value="<fmt:message key='clear_button' bundle='${signInBundle}' />" />
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-xs-12 col-sm-offset-3 col-sm-8">
                            <div class="checkbox"><label><input name="${rememberMeVariable.name}" type="checkbox" id="remember-me" value="1" /> <fmt:message key="remember_me" bundle="${signInBundle}" /></label></div>
                        </div>
                    </div>
                    </fieldset>
                    </form>

                    <div class="row">
                        <div class="col-xs-12 col-sm-offset-3 col-sm-8"><fmt:message key="forgot_password" bundle="${signInBundle}" /></div>
                    </div>
                    <div class="row">
                        <div class="col-xs-12 col-sm-offset-3 col-sm-8"><fmt:message key="register_now" bundle="${signInBundle}" /></div>
                    </div>

                </div>
            </div>
        </div>
        </main>

    </body>
</html>
