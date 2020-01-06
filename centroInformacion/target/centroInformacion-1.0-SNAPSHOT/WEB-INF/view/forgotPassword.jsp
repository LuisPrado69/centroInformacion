<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.0/jquery.validate.min.js"></script>
<script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>

<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <title>Inicio</title>
    </head>
    <body>
        Ingrese su correo electrónico:
        <form action="resetPassword" method="post">
            <table>
                <tr>
                    <td colspan="2"><input type="text" name="email"> </td>
                </tr>
                <tr>
                    <td><input type="Submit" value="Recuperar contraseña">  </td>
                    <td><input type="reset" value="Cancelar">  </td>
                </tr>
            </table>
        </form>
    </body>
</html>

<script type="text/javascript">

    $(document).ready(function () {
        $("#form").validate({
            rules: {
                username: {

                    required: true,

                    remote: {
                        url: "deneme.jsp",
                        async: false,
                        type: "post",
                        data: {
                            username: function () {
                                return $("#username").val()
                            }
                        }
                    }


                }
            },
            messages: {
                username: {
                    required: "Require Field", remote: "already exist"
                }
            }
        });
    });
</script>