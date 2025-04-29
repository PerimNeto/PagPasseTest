package model;

package br.com.fiap.PagPasse.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AutenticacaoApiTest {

    @BeforeAll
    static void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
    }

    @Test
    @DisplayName("Deve bloquear acesso a endpoint privado sem autenticação")
    void deveBloquearAcessoSemToken() {
        RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .get("/api/private/hello")
                .then()
                .statusCode(401);
    }
}
