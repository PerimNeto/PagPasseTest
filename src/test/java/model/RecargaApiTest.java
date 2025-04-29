package model;

package br.com.fiap.PagPasse.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;

class RecargaApiTest {

    @BeforeAll
    static void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
    }

    @Test
    @DisplayName("Deve recusar recarga com valor negativo")
    void deveRecusarRecargaValorNegativo() {
        String requestBody = """
            {
                "valorRecarga": -10.0,
                "metodoPagamento": "CartaoCredito",
                "dataRecarga": "2024-04-10",
                "status": true
            }
        """;

        RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/api/recarga/adicionar")
                .then()
                .statusCode(400);
    }
}
