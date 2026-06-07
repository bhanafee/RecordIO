package com.maybeitssquid.recordio;

import java.io.IOException;

public record Raw(String name) implements Codec<CharSequence> {

  @Override
  public Class<CharSequence> type() {
    return CharSequence.class;
  }

  @Override
  public CharSequence read(final CharSequence input) {
    return input;
  }

  @Override
  public Appendable write(final CharSequence value, final Appendable output) throws IOException {
    return output.append(value);
  }
}
