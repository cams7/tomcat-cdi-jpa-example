<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Salvar Contato</title>
<style type="text/css">
form.box p label {
	display: block;
}

form.box p input {
	width: 200px;
}
</style>
</head>
<body>
	<form class="box" action="vaisalvar">
		<p>
			<label>id</label> <input name="id" />
		</p>
		<p>
			<label>nome</label> <input name="nome" />
		</p>
		<p>
			<label>telefone</label> <input name="telefone" />
		</p>
		<p>
			<input type="submit" value="Salvar" />
		</p>
	</form>
</body>
</html>