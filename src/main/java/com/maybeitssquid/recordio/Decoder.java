package com.maybeitssquid.recordio;

public interface Decoder<T> extends Element<T> {
  T read(CharSequence input);
}
