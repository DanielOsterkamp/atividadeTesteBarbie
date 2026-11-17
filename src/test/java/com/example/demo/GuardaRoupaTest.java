package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GuardaRoupaTest {

    GuardaRoupa gr;

    @BeforeEach
    void setup(){
        gr = new GuardaRoupa(500);
    }

    @Test
    @DisplayName("Desconto de 10% em 200 reais deve dar 180")
    void precoComDesconto() {
        assertEquals(180,gr.precoComDesconto(200,10));

    }

    @Test
    @DisplayName("deve caber no orcamento corretamente")
    void deveCaberNoOrcamentoCorretamente() {
        assertTrue(gr.cabeNoOrcamento(300));
    }

    // o cabe no orcamento deveria funcionar caso fosse 500. Logo, deveria ser alterado de < para <=
    @Test
    @DisplayName("deve caber no orcamento corretamente")
    void deveCaberNoOrcamentoCorretamenteCasoForIgual() {
        assertTrue(gr.cabeNoOrcamento(500));
    }

    @Test
    @DisplayName("deve mostrar se nao é de gala corretamente")
    void deveMostrarSeNaoEDeGalaCorretamente() {
        assertFalse(gr.ehDeGala(199));
    }

    @Test
    @DisplayName("deve mostrar se é de gala corretamente caso seja exatamente 200")
    void deveMostrarSeEDeGalaCorretamenteCaso200() {
        assertTrue(gr.ehDeGala(200.0));
    }

    @Test
    @DisplayName("deve mostrar se é de gala corretamente")
    void deveMostrarSeEDeGalaCorretamente() {
        assertTrue(gr.ehDeGala(600));
    }

    // tanto o desconto negativo quanto o gigante nao estao mandando a exceçao

    @Test
    @DisplayName("Desconto negativo deve lançar exceção")
    void rejeitaDescontoNegativo() {
        assertThrows(IllegalArgumentException.class, () -> gr.precoComDesconto(100.00, -10));
    }

    @Test
    @DisplayName("Desconto negativo deve lançar exceção")
    void rejeitaDescontoGigante() {
        assertThrows(IllegalArgumentException.class, () -> gr.precoComDesconto(100.00, 1000));
    }

}