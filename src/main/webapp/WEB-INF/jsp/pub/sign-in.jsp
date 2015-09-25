<%@ page session="false"%><%@ page contentType="text/plain;charset=UTF-8" language="java" %><!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:useBean id="langProperty" class="apollo.datastore.utils.RequestPropertyVariableBean" />
<jsp:setProperty name="langProperty" property="name" value="LANG" />
<jsp:setProperty name="langProperty" property="value" value="${requestScope[langProperty.name]}" />
<fmt:setLocale value="${langProperty.value}" />
<fmt:setBundle basename="apollo.datastore.utils.i18n.SignInBundle" var="signInBundle" />
<jsp:useBean id="defaultLangProperty" class="apollo.datastore.utils.RequestPropertyVariableBean" />
<jsp:setProperty name="defaultLangProperty" property="name" value="DEFAULT_LANG" />
<jsp:setProperty name="defaultLangProperty" property="value" value="${requestScope[defaultLangProperty.name]}" />

<jsp:useBean id="userIdVariable" class="apollo.datastore.utils.FormVariableBean" />
<jsp:setProperty name="userIdVariable" property="name" value="USER_ID" />
<jsp:useBean id="passwordVariable" class="apollo.datastore.utils.FormVariableBean" />
<jsp:setProperty name="passwordVariable" property="name" value="PASSWORD" />
<jsp:useBean id="rememberMeVariable" class="apollo.datastore.utils.FormVariableBean" />
<jsp:setProperty name="rememberMeVariable" property="name" value="REMEMBER_ME" />

<jsp:useBean id="rememberMeCookie" class="apollo.datastore.utils.CookieVariableBean" />
<jsp:setProperty name="rememberMeCookie" property="name" value="REMEMBER_ME" />
<jsp:useBean id="userIdCookie" class="apollo.datastore.utils.CookieVariableBean" />
<jsp:setProperty name="userIdCookie" property="name" value="USER_ID" />
<c:if test="${not empty cookie[rememberMeCookie.name]}">
    <jsp:setProperty name="rememberMeVariable" property="value" value="${cookie[rememberMeCookie.name].value}" />
    <jsp:setProperty name="userIdVariable" property="value" value="${cookie[userIdCookie.name].value}" />
</c:if>
<html>
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <title><fmt:message key="TITLE" bundle="${signInBundle}" /></title>
        <!-- Bootstrap -->
        <link rel="stylesheet" href="/css/bootstrap.min.css" />
        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
        <script type="text/javascript" src="/js/jquery.min.js"></script>
        <script type="text/javascript" src="/js/jquery.validate.min.js"></script>
        <script type="text/javascript" src="/js/bootstrap.min.js"></script>
<c:if test="${langProperty.value ne defaultLangProperty.value}">
        <!-- Link messages file for localized validation. -->
        <script type="text/javascript" src="/js/messages_${langProperty.value}.min.js"></script>
</c:if>
        <link rel="stylesheet" href="/css/styles.css" />
        <script type="text/javascript">
$(document).ready(function() {
    signInModal = $('#sign-in-modal');
    signInModal.modal({backdrop: 'static', keyboard: false, show: false});
    signInForm = $('#sign-in-form');
    userIdInput = $('#user-id');
    userIdInput.attr('value', '<c:out value="${userIdVariable.value}" />');
    userIdInput.popover({placement: 'bottom', trigger: 'manual', content: '_'});
    passwordInput = $('#password');
    rememberMeCheckbox = $('#remember-me');
<c:if test="${not empty rememberMeVariable.value}">
    rememberMeCheckbox.attr('checked', true);
</c:if>
    $('#clear-btn').click(function () {
        signInFormValidator.resetForm();
        this.form.reset();
    });
    $('#reset-password-request-link').attr('href', '/utils/reset-password-request');
    $('#register-link').attr('href', '/utils/register');

    function hideModal() {
        signInModal.modal('hide');
        signInModal.off('shown.bs.modal');
    }

    signInFormValidator = signInForm.validate({
        submitHandler: function(form) {
            var formData = {
                '${userIdVariable.name}': userIdInput.val(),
                '${passwordVariable.name}': passwordInput.val(),
                '${rememberMeVariable.name}': rememberMeCheckbox.prop('checked')
            };
            signInModal.on('shown.bs.modal', function(event) {
                $.ajax({
                    cache: false,
                    accepts: 'application/json',
                    contentType: 'application/json',
                    dataType: 'json',
                    type: 'POST',
                    url: '/utils/sign-in',
                    data: JSON.stringify(formData)
                }).done(function(data, textStatus, jqXHR) {
                    setTimeout(hideModal, 500);
                }).fail(function(jqXHR, textStatus, errorThrown) {
                    signInModal.find('.modal-content').html(textStatus);
                    signInModal.addClass('text-danger');
                    setTimeout(hideModal, 500);
                });
            });
            signInModal.find('.modal-content').html('<fmt:message key="SIGNING_IN" bundle="${signInBundle}" />');
            signInModal.removeClass('text-danger');
            signInModal.modal('show');
        },
        rules: {
            '${userIdVariable.name}': {
                minlength: 5,
                maxlength: 32,
                required: true
            }
        },
        showErrors: function(errorMap, errorList) {
            for(var i = 0; i < errorList.length; ++i) {
                var errorListItem = $(errorList[i].element);
                var popoverDiv = errorListItem.next();
                if(!popoverDiv.length) {
                    errorListItem.popover('show');
                    popoverDiv = errorListItem.next();
                    // must be added to override computed left property
                    popoverDiv.css({'left': '0px', 'margin-left': '10px', 'margin-right': '10px'});
                    popoverDiv.find('.popover-content').addClass('text-danger');
                }
                popoverDiv.find('.popover-content').html(errorList[i].message);
            }
        },
        onkeyup: function(element, event) {
            if(signInFormValidator.element(element))
                $(element).popover('hide');
        },
        onfocusout: function(element, event) {
            if(signInFormValidator.element(element))
                $(element).popover('hide');
        }
    });
});
        </script>
    </head>
    <body>
<%@ include file="/WEB-INF/jspf/pub/top-navbar.jspf" %>
        <div class="page-header">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-xs-12 col-sm-offset-2 col-sm-8">
                        <div class="row"><h3 class="col-xs-12 col-sm-offset-3 col-sm-9"><fmt:message key="PAGE_HEADER" bundle="${signInBundle}" /></h3></div>
                    </div>
                </div>
            </div>
        </div>

        <div class="modal fade" id="sign-in-modal" tabindex="-1" role="dialog">
            <div class="modal-dialog modal-sm">
                <div class="modal-content"></div>
            </div>
        </div>

        <main role="main">
        <div class="container-fluid">
            <div class="row">
                <div class="col-xs-12 col-sm-offset-2 col-sm-8">

                    <form name="sign-in-form" class="form-horizontal" id="sign-in-form" role="form">
                    <fieldset>
                    <div class="form-group">
                        <label class="col-xs-12 col-sm-3 control-label" for="user-id"><fmt:message key="USER_ID_LABEL" bundle="${signInBundle}" /></label>
                        <div class="col-xs-12 col-sm-8"><input name="${userIdVariable.name}" type="text" class="form-control" id="user-id" maxlength="32" required autofocus /></div>
                    </div>

                    <div class="form-group">
                        <label class="col-xs-12 col-sm-3 control-label" for="password"><fmt:message key="PASSWORD_LABEL" bundle="${signInBundle}" /></label>
                        <div class="col-xs-12 col-sm-8"><input name="${passwordVariable.name}" type="password" class="form-control" id="password" maxlength="64" /></div>
                    </div>

                    <div class="form-group">
                        <div class="col-xs-12 col-sm-offset-3 col-sm-8">
                            <input id="submit-btn" type="submit" class="btn btn-default" value="<fmt:message key='SIGN_IN_BUTTON' bundle='${signInBundle}' />" />
                            <input id="clear-btn" type="reset" class="btn btn-default" value="<fmt:message key='CLEAR_BUTTON' bundle='${signInBundle}' />" />
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-xs-12 col-sm-offset-3 col-sm-8">
                            <div class="checkbox"><label><input name="${rememberMeVariable.name}" type="checkbox" id="remember-me" value="1" /> <fmt:message key="REMEMBER_ME" bundle="${signInBundle}" /></label></div>
                        </div>
                    </div>
                    </fieldset>
                    </form>

                    <div class="row">
                        <div class="col-xs-12 col-sm-offset-3 col-sm-8"><fmt:message key="FORGOT_PASSWORD" bundle="${signInBundle}" /></div>
                    </div>
                    <div class="row">
                        <div class="col-xs-12 col-sm-offset-3 col-sm-8"><fmt:message key="REGISTER_NOW" bundle="${signInBundle}" /></div>
                    </div>

                </div>
            </div>
        </div>
        </main>

    </body>
</html>
