package com.wuchao.pay.service.impl;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeWapPayModel;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.wuchao.pay.config.AlipayConfig;
import com.wuchao.pay.service.PayService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;
@Service
public class PayServiceImpl implements PayService
{
    @Override
    public String PayMoney(Map<String, String> PayMap) throws IOException {
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.URL,AlipayConfig.APPID,AlipayConfig.RSA_PRIVATE_KEY,AlipayConfig.FORMAT,AlipayConfig.CHARSET,AlipayConfig.ALIPAY_PUBLIC_KEY,AlipayConfig.SIGNTYPE);
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
        AlipayTradeWapPayModel alipayTradeWapPayModel = new AlipayTradeWapPayModel();
        alipayTradeWapPayModel.setOutTradeNo(PayMap.get("out_trade_no"));
        alipayTradeWapPayModel.setProductCode("FAST_INSTANT_TRADE_PAY");
        alipayTradeWapPayModel.setTotalAmount(PayMap.get("total_amount"));
        alipayTradeWapPayModel.setSubject("测试使用");//标题
        alipayTradeWapPayModel.setBody(PayMap.get("body"));
        alipayRequest.setBizModel(alipayTradeWapPayModel);
        String form="";
        try {
            form = alipayClient.pageExecute(alipayRequest).getBody();
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return form;
    }


}
