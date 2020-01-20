package com.wuchao.pay.service;

import java.io.IOException;
import java.util.Map;

public interface PayService {


    String PayMoney(Map<String, String> PayMap) throws IOException;

}
