package com.nhom2.duan1.utilities.lib;

public enum UserState {
  ON("dang hoat dong"),
  OFF("lhong con hoat dong");

  private final String value;
  
  UserState(String _value) {
    value = _value;
  }

  @Override
  public String toString() {
    return value;
  }
}
