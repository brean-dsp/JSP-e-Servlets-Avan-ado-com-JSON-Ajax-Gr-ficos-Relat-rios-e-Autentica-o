<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Capturar Exce��es</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
</head>
<body>

	<h3>Capturando Exce��es com JQuery</h3>
	<input type="text" value="Valor Informado" id="txtValor">
	<input type="button" onclick="testarExcecao();" value="Testar Exce��o">
</body>

	<script type="text/javascript">
		function testarExcecao(){
			valorInformado = $('#txtValor').val();
			
			$.ajax({
				method: "POST";
				url: "capturarExcecao";
				data: { valorParam: valorInformado }
			})
			  .always(function(response) {
				alert(response);  
			  });
		}
	</script>

</html>