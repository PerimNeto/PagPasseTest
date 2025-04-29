package model;

package br.com.fiap.PagPasse.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;

class LinhaApiTest {

    @BeforeAll
    static void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
    }

    @Test
    @DisplayName("Deve buscar uma Linha existente por ID com sucesso")
    void deveBuscarLinhaComSucesso() {
        Long linhaId = 1L; // Você pode mudar conforme seu banco de dados de teste

        RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .get("/api/linha/{id}", linhaId)
                .then()
                .statusCode(200)
                .body("id", equalTo(linhaId.intValue()))
                .body(matchesJsonSchemaInClasspath("schemas/LinhaSchema.json"));
    }
}
