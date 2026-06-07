package com.maybeitssquid.recordio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

class RawTest {

  private final Raw raw = new Raw("field");

  @Test
  void exposesName() {
    assertEquals("field", raw.name());
  }

  @Test
  void typeIsCharSequence() {
    assertEquals(CharSequence.class, raw.type());
  }

  @Test
  void readReturnsInputUnchanged() {
    CharSequence input = "hello";
    assertSame(input, raw.read(input));
  }

  @Test
  void writeAppendsValueToOutput() throws java.io.IOException {
    StringBuilder output = new StringBuilder("pre-");
    Appendable result = raw.write("value", output);
    assertSame(output, result);
    assertEquals("pre-value", output.toString());
  }

  @Test
  void asStringRendersValue() {
    assertEquals("value", raw.asString("value"));
  }
}
