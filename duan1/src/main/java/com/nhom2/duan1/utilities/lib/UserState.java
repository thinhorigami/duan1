package com.nhom2.duan1.utilities.lib;

public enum UserState {
  ON("đang hoạt động"),
  OFF("không còn hoạt động");

  private final String value;
  
  UserState(String _value) {
    value = _value;
  }

  @Override
  public String toString() {
    return value;
  }
}
