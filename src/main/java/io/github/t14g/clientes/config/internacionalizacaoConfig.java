package io.github.t14g.clientes.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import java.util.Locale;

@Configuration
public class internacionalizacaoConfig {

    //@Bean coloca esse bean dentro do contexto de injeção de dep quando a classe for scaneada
    //Bean de message source
    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        //arquivo.properties , dentro do classpath na raiz
        messageSource.setBasename("classpath:messages");
        //Caracteres BR
        messageSource.setDefaultEncoding("ISO-8859-1");
        //Brasil
        messageSource.setDefaultLocale(Locale.getDefault());

        return messageSource;
    }

    //Objeto que integra as mensagens e a validação da especificação de validações do java
    @Bean
    public LocalValidatorFactoryBean validatorFactoryBean() {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource());
        return bean;
    }
}
