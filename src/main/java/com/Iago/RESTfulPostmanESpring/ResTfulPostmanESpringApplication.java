/*
 * A UI pede ao agente para informar a placa do veículo e se o condutor é ou não habilitado
 * caso seja, os dados do condutor são preenchidos automaticamente (Metodo verificar CPF).
 * Caso não seja, o agente preenche os dados do condutor de forma manual e informa também
 * os dados do veículo enquadrado e o tipo de enquadramento (Metodo cadastrar infração).
 * A infração (Objeto) então é mandado para uma URL estrangeira para que seja aberta em outra
 * maquina para aprovação, ao ser aprovada ou rejeitada, é registrado então o resultado
 * no banco de dados dessa empresa estrangeira e mandado a infração (Objeto) de volta para
 * uma URL na minha maquina que registrará a infração no meu banco de dados para ser mostrada
 * em uma lista de infrações ao ser usado o método de mostrar as infrações.
 */

package com.Iago.RESTfulPostmanESpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ResTfulPostmanESpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResTfulPostmanESpringApplication.class, args);
	}

}
