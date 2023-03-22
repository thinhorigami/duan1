package com.nhom2.duan1.utilities.lib;

public enum Gender {
  MALE("Nam"),
  FEMALE("Nu");

  private final String value;

  Gender(String _value) {
    value = _value;
  }

  @Override
  public String toString() {
    return value;
  }
}
