<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
<script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/additional-methods.min.js"></script>

<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <title>Inicio</title>
    </head>
    <body>
        Ingrese su correo electrónico:
        <form action="resetPassword" id="resetPassword" method="post">
            <table>
                <tr>
                    <td colspan="2"><input type="text" name="email" id="email"> </td>
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
        $("#resetPassword").validate({
            rules: {
                email: {
                    required: true,
                    email: true,
                    remote: {
                        url: "RecuperarContrasenaControladorAjax",
                        type: "post",
                        data: {
                            email: function () {
                                return $("#email").val();
                            }
                        }
                    }
                }
            },
            messages: {
                email: {
                    required: "Campo requerido", 
                    remote: "No existe un registro con este email"
                }
            }
        });
    });
</script>