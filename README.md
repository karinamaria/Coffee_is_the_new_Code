<html>
<h1>Wishlist</h1>
<h2>Sobre o Projeto</h2>
<!--Inserir link do projeto-->
<p>O objetivo desse projeto é construir uma API para simular uma WishList. A Wishlist é umas das funcionalidades mais interessantes em um e-commerce. No e-commerce o cliente pode realizar a busca de produtos, ou pode acessar a tela de detalhes do produto.<br>
Em ambas as telas ele pode selecionar os produtos de sua preferência e armazená-los na sua Wishlist. A qualquer momento o cliente pode visualizar sua Wishlist completa, com todos os produtos que ele selecionou e uma única tela.</p>

<!--Inserir Badges-->
<h2>Diagrama de Classes</h2> 
<!--![Diagrama](https://github.com/gabikenaga/Coffee_is_the_new_Code/blob/master/assets/Diagrama.png)-->  
<img src="https://github.com/gabikenaga/Coffee_is_the_new_Code/blob/master/assets/Diagrama.png" alt="Diagrama de classes" width="300"/>  

<h2>Pré-requisitos</h2>
<p>-Cadastro de produto<br>
  -Cadastro de cliente<br>
  -Adicionar um produto na Wishlist do cliente<br>
  -Remover um produto da Wishlist do cliente<br>
  -Consultar todos os produtos da Wishlist do cliente<br>
  -Consultar se um determinado produto está na Wishlist do cliente<br>
  </p>
  
<h2>Desenvolvimento</h2>

Caso queira rodar o projeto ou incluir novas funcionalidades é necessário cloná-lo, importá-lo para o Inteliij IDEA, instalar o JDK do Java e o MySQL.

Além disso, é necessário adicionar as variáveis de ambiente na sua IDE para configurar a conexão com o banco de dados. As variáveis que precisam ser configuradas estão no arquivo `application.properties`. A variável `${datasource_url}` deve ter o valor `jdbc:mysql://localhost:3306/coffeIsTheNewCode?useSSL=false&createDatabaseIfNotExist=true`

Para mais detalhes com relação a configuração das variáveis de ambiente, acesse esse [link](https://www.jetbrains.com/help/objc/add-environment-variables-and-program-arguments.html#add-environment-variables)

Por fim, basta executar o projeto através da classe `CoffeeIsTheNewCodeApplication.java` ou pelo Maven através do seguinte comando
```
mvn spring-boot:run
```

<h2>Acesso a API</h2>
  
Primeiro, verifique em qual porta a API foi iniciada, geralmente é na porta 8080.Logo depois, para acessar os endpoints é necessário entrar neste link: [http://localhost:8080/swagger-ui/](http://localhost:8080/swagger-ui/)

<h2>Metodologias ágeis</h2>

Para o desenvolvimento do projeto foi utilizada o Scrum e Kanban, verifique neste [link](https://github.com/gabikenaga/Coffee_is_the_new_Code/projects/1)
  
<h2>Tecnologias Utilizadas</h2>
<p><b>Back-end</b><br>
  -Java<br>
  -Spring Boot<br>
  -JPA / Hibernate<br>
  -Maven<br>
  -MapStruct<br>
  -MySQL<br>
  -Swagger<br>

<h2>Desenvolvedoras</h2>
 <p>- Gabriela Ikenaga<br>
 - Júlia Falconi<br>
 - Karina Maria<br>
 - Lara Yasmin<br>
 - Munique Garcia</p>
  
</html>
