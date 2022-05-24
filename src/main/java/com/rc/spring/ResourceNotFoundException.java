package com.rc.spring;

public class ResourceNotFoundException extends RuntimeException {

  public ResourceNotFoundException(String ex) {
    super(ex);
  }
}
