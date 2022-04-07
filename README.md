POST para Cliente 
{
    "nome":"NOME AQUI",    		    -- STRING
    "documento":"DOCUMENTO",	 	-- STRING 	(Não implementado nenhum tipo de tratamento para documento)
    "email":"EMAIL",	 	        -- STRING	(Não implementado nenhum tipo de tratamento para email)
    "telefone":"NUMERO DE TELEFONE"	-- STRING	(não implementado nenhum tipo de tratamento para telefone) 
}
GET: http://localhost:8080/clientes
GET: http://localhost:8080/clientes/page?size=0&number=1


-----------------------------------------------------------//--------------------------------------------------------

POST para Produto
{
    "nome":"NOME PRODUTO",						-- STRING
    "descricao":"DESCRIÇÃO DO PRODUTO",	     	-- STRING	
    "categoria":"CATEGORIA PARA O PRODUTO",  	-- STRING
    "valor":1.00								-- double (não usar aspas)
}
GET http://localhost:8080/vendas
-----------------------------------------------------------//--------------------------------------------------------
POST para venda
{
    "cliente":{"id":1},			-- INT (colocar o id referente ao cliente cadastrado anteriormente)
    "produto":{"id":1}			-- INT (colocar o id referente ao produto cadastrado anteriormente)
}
GET http://localhost:8080/vendas


