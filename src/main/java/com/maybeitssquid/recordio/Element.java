package com.maybeitssquid.recordio;

public interface Element<T> {
  String name();

  Class<T> type();
}
