/*
 *  Copyright (c) 2016 Omni, Inc.
 *
 *  DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 *  Project : Discovree
 *  Last Modified : 2/21/16 12:29 PM
 *
 *  All Rights Reserved
 *  Unauthorized copying of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 */

package sample.github.nisrulz.usingretrofit2.rest;

import java.io.IOException;
import java.lang.annotation.Annotation;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Response;

public class NetworkErrorUtils {

  public static APIError parseError(RetrofitHelper retrofitHelper, Response<?> response) {
    Converter<ResponseBody, APIError> converter =
        retrofitHelper.getClient().responseBodyConverter(APIError.class, new Annotation[0]);

    APIError error;

    try {
      error = converter.convert(response.errorBody());
    } catch (IOException e) {
      return new APIError();
    }

    return error;
  }
}
