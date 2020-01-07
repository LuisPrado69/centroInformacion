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
        Ingrese nueva contraseña para: ${emailid}
        <form id="registerNewPasswordForm">
            <table>
                <tr>
                    <td colspan="2"><input type="hidden" name="token" value="${token}" id="token"> </td>
                </tr>
                <tr>
                    <td>Contraseña</td>
                    <td><input type="password" id="txtPassfirst" name="txtPassfirst"> </td>
                </tr>
                <tr>
                    <td>Repita contraseña</td>
                    <td><input type="password" id="txtPassSecond" name="txtPassSecond"> </td>
                </tr>
                <tr>
                    <td colspan="2"><center><input type="button" value="Guardar" id="guardarFormulario"> </center> </td>
                </tr>
            </table>
        </form>
    </body>
</html>

<script type="text/javascript">

    $(document).ready(function () {
        $("#registerNewPasswordForm").validate({
            rules: {
                txtPassfirst: {
                    required: true,
                    minlength: 4,
                    maxlength: 8
                },
                txtPassSecond: {
                    required: true,
                    minlength: 4,
                    maxlength: 8,
                    equalTo: "#txtPassfirst"
                }
            }
        });

        $('#guardarFormulario').click(function () {
            $.ajax({
                url: "${pageContext.request.contextPath}/RecuperarContrasenaControladorAjax",
                type: 'POST',
                data: {
                    asunto: 2,
                    password: $('#txtPassSecond').val(),
                    token: $('#token').val()
                },
                success: function (data) {
                    if (data === 'true') {
                        alert('Contraseña guardada existosamente');
                    } else {
                        alert('Token no coincide con el generado anteriormente');
                    }
                }
            });
        });

    });
</script>