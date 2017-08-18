# 2017.2 Revendedora

## Sobre o Projeto

<p align="justify"> Este software tem como intuito auxiliar no controle de vendas de revendedoras de produtos cosméticos. Afim de se obter um maior controle, tanto de estoque de produtos, como controle financeiro, proporcionando uma melhor gestão sobre os produtos que serão vendidos e proporcionar um melhor controle deses clientes pela revendedora destes produtos.</p>

## Instalação

Para contribuir com esse repositório é necessário a instalação do VirtualBox e Vagrant em um ambiente linux como o ubuntu.

Veja informações e resoluções de alguns problemas com Vagrant em https://pt.wikiversity.org/wiki/Vagrant_e_Docker

Faça clone ou download do repositório.

```console
$ git clone https://github.com/EduardoBrasil/Revendedora
```

Entre no arquivo clonado e execute o seguinte comando para fazer o boot na máquina virtual e executa os o que está definido no VagrantFile

```console
$ vagrant up
```

Após isso, entre na maquina virtual criada
```console
$ vagrant ssh
```

Agora já na máquina virtual criada entre no bash
```console
$ vim ~/.bashrc
```

E adicione a seguinte linha no final do arquivo para que na próxima vez que abrir com ssh já abra na pasta do projeto.

```console
cd /vagrant/revendedora
```

Para entrar na pasta, reinicie o vagrant ssh ou digite
```console
$ cd
$ cd vagrant/
```

Já na máquina virtual, configure o postgree com:

Entre no modo root
```console
$ sudo su
```
Abra o seguinte arquivo
```console
$ nano /etc/postgresql/9.5/main/pg_hba.conf
```

Altere as linhas do arquivo de:
```console
local all postgres peer
local all all peer
```

Para:
```console
local all postgres trust
local all all trust
```

Reinicie o postgree
```console
service postgresql reload
```

Ainda no modo root, entre com o usuário postgres
```console
su postgres
```

Entre no postgresql
```console
psql -U postgres
```

Crie o usuário vagrant e autorize-o a criar databases
```console
CREATE USER vagrant WITH createdb;
```

Saia do postgres
```console
\q
```

Saia do usuário postgres e root
```console
exit
exit
```

Entre na pasta do projeto em rails revendedora e execute
```console
rake db:setup
rake db:migrate
```

Rode o servidor
```console
$ rails s
```
Abra seu navegador em localhost:8080

## Principais Features

O projeto Revedora tem como principais features:

* Cadastro de Fornecedores 
* Cadastro de Clientes
* Gerenciamento dos clientes 
* Criação e gerenciamento de itens cosméticos
* Realizar criação de kits


## Documentação do Projeto

Visualize a documentação na nossa [wiki](https://github.com/EduardoBrasil/Revendedora/wiki).

## Licença

[GNU AGPL v3.0](https://www.gnu.org/licenses/agpl-3.0.html)
