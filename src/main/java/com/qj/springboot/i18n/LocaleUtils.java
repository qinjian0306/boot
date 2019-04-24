package com.qj.springboot.i18n;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
public class LocaleUtils {

	private MessageSource messageSource;

	public LocaleUtils(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	/**
	 * 获取单个国际化翻译值
	 */
	public String get(String msgKey) {
		try {
//			LocaleContextHolder.setLocale(Locale.ENGLISH);
			return messageSource.getMessage(msgKey, null, LocaleContextHolder.getLocale());
		} catch (Exception e) {
			return msgKey;
		}
	}





}
