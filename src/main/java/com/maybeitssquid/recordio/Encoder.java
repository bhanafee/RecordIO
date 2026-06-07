package com.maybeitssquid.recordio;

import java.io.IOException;

public interface Encoder<T> extends Element<T> {
  Appendable write(T value, Appendable output) throws IOException;

  default String asString(T value) {
    StringBuilder output = new StringBuilder();
    try {
      Appendable _ = write(value, output);
    } catch (final IOException e) {
      throw new RuntimeException("Unexpected exception appending StringBuilder", e);
    }
    return output.toString();
  }
}
