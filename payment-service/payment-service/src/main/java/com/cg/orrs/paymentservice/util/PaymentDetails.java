package com.cg.orrs.paymentservice.util;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Component
@ConfigurationProperties("paytm.payment.sandbox")
public class PaymentDetails {

	private String merchantId;

	private String merchantKey;

	private String channelId;

	private String website;

	private String industryTypeId;

	private String paytmUrl;

	private Map<String, String> details;
}
