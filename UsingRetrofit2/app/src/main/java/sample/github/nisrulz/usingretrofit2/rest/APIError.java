/*
 *  Copyright (c) 2016 Omni, Inc.
 *
 *  DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 *  Project : Discovree
 *  Last Modified : 2/21/16 12:36 PM
 *
 *  All Rights Reserved
 *  Unauthorized copying of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 */

package sample.github.nisrulz.usingretrofit2.rest;

public class APIError {

  private String code;
  private String message;

  public APIError() {
  }

  public String code() {
    return code;
  }

  public String message() {
    return message;
  }
}
