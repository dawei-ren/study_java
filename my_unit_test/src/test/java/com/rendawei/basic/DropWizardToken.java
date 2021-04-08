package com.rendawei.basic;

import org.junit.Test;

import java.util.Base64;

public class DropWizardToken {

  @Test
  public void testGetAUTHORIZATION(){

    /**
     *
     *
     * 请求添加请求头
     * Response response = resourceExtension
     *             .target("/protected")
     *             .request()
     *             .header(HttpHeaders.AUTHORIZATION, credential)
     *             .get();
     */

    String credential = "Basic " + Base64.getEncoder().encodeToString("zhonglibo:foshan".getBytes());
    System.out.println(credential);

  }
}
