package br.com.yohandev6.modelsTests;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.yohandev6.models.Product;

public class ProductTest {

	@Test
	@DisplayName("Deve criar um produto com builder corretamente")
	void shouldBuildProductCorrectly() {
		Product p = Product.builder()
				.ID(1L)
				.name("Arroz 5kg")
				.validate(LocalDate.of(2025, 12, 31))
				.price(new BigDecimal("25.90"))
				.build();

		assertThat(p.getID()).isEqualTo(1L);
        assertThat(p.getName()).isEqualTo("Arroz 5kg");
        assertThat(p.getValidate()).isEqualTo(LocalDate.of(2025, 12, 31));
        assertThat(p.getPrice()).isEqualByComparingTo("25.90");
	}

	@Test
    @DisplayName("Deve comparar produtos iguais corretamente (equals e hashCode)")
    void shouldCompareProductsCorrectly() {
        Product p1 = Product.builder()
                .ID(1L)
                .name("Feijão")
                .validate(LocalDate.of(2026, 1, 10))
                .price(new BigDecimal("10.50"))
                .build();

        Product p2 = Product.builder()
                .ID(1L)
                .name("Feijão")
                .validate(LocalDate.of(2026, 1, 10))
                .price(new BigDecimal("10.50"))
                .build();

        assertThat(p1).isEqualTo(p2);
        assertThat(p1.hashCode()).isEqualTo(p2.hashCode());
    }

	@Test
    @DisplayName("Deve gerar uma representação de texto legível (toString)")
    void shouldGenerateReadableToString() {
        Product p = Product.builder()
                .ID(2L)
                .name("Café 500g")
                .validate(LocalDate.of(2025, 9, 30))
                .price(new BigDecimal("14.99"))
                .build();

        String result = p.toString();
        assertThat(result).contains("Café 500g");
        assertThat(result).contains("14.99");
    }
}
