package com.dummy.networkapp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import com.dummy.networkapp.domain.EmoticonConverter;

public class EmoticonConverterTest {

	@Test
	public void testEmoticonConverter() {
		EmoticonConverter converter = new EmoticonConverter();
		assertEquals(converter.convert("Hallo :) und tschüss :-P"), "Hallo 🙂 und tschüss 😛");
		assertEquals(converter.convert(":-) :("), "🙂 🙁");
	}
}
