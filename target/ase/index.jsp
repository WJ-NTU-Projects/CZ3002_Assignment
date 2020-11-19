<!DOCTYPE html PUBLIC
"-//W3C//DTD XHTML 1.1 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@taglib prefix="s" uri="/struts-tags" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
    <head>
        <title>ASE Assignment</title>
        <s:head/>
    </head>

    <body>
        <s:form action = "loginaction" method = "post">
            Username:<br/><s:textfield type = "text" name = "username"/><br/>
            Password:<br/><s:textfield type = "password" name = "password"/><br/>
            <s:submit type = "submit" value = "Login"/>
        </s:form>
    </body>
</html>
