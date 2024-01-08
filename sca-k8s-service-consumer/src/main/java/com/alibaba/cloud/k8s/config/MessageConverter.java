package com.alibaba.cloud.k8s.config;

import com.google.common.collect.Lists;

import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter;

/**
 * @author yuluo
 * @author 1481556636@qq.com
 */

@Configuration
public class MessageConverter {

	@Bean
	public HttpMessageConverters protobufHttpMessageConverter() {

		ProtobufHttpMessageConverter protobufHttpMessageConverter = new ProtobufHttpMessageConverter();
		protobufHttpMessageConverter.setSupportedMediaTypes(
				Lists.newArrayList(
						MediaType.APPLICATION_JSON,
						MediaType.parseMediaType(MediaType.TEXT_PLAIN_VALUE + ";charset=ISO-8859-1")
				));

		return new HttpMessageConverters(protobufHttpMessageConverter);
	}

}
