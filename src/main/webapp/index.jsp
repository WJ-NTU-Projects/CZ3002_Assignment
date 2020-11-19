<!DOCTYPE html PUBLIC
"-//W3C//DTD XHTML 1.1 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@taglib prefix="s" uri="/struts-tags" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
    <head>
        <title>ASE Assignment</title>
        <link rel="stylesheet" type="text/css" href="style.css">
        <s:head/>
    </head>

    <body>
        <div class="form-div">
            <s:form action = "login_action" method = "post" cssClass="form">
                <s:fielderror fieldName="error-field" cssClass="form-error" />

                <div class="form-input-div">
                    Username:<br/>
                    <s:textfield type = "text" name = "username" cssClass="form-input" />
                </div>

                <div class="form-input-div">
                    Password:<br/>
                    <s:textfield type = "password" name = "password" cssClass="form-input" />
                </div>

                <div class="form-input-div">
                    <s:submit value = "Login" cssClass="form-submit" />
                </div>
            </s:form>
        </div>
    </body>
</html>
