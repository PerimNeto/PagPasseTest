package model;

package br.com.fiap.PagPasse.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;

    class CartaoTransporteApiTest {

        @BeforeAll
        static void setup() {
            RestAssured.baseURI = "http://localhost";
            RestAssured.port = 8080;
        }

        @Test
        @DisplayName("Deve cadastrar um novo Cartão de Transporte com sucesso")
        void deveCadastrarCartaoComSucesso() {
            String requestBody = """
            {
                "numeroCartao": 1234567890,
                "tipoCartao": "Comum",
                "saldoCartao": 50.0,
                "dataEmissao": "2024-04-01"
            }
        """;

            RestAssured.given()
                    .contentType(ContentType.JSON)
                    .body(requestBody)
                    .when()
                    .post("/api/cartao-transporte/adicionar")
                    .then()
                    .statusCode(200)
                    .body("numeroCartao", equalTo(1234567890))
                    .body(matchesJsonSchemaInClasspath("schemas/CartaoTransporteSchema.json"));
        }
    }


