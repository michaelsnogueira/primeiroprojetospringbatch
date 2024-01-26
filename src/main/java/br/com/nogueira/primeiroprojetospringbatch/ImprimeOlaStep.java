package br.com.nogueira.primeiroprojetospringbatch;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

public class ImprimeOlaStep {

    @StepScope
    @Bean
    public Tasklet imprimeOlaTaskclet(@Value("#{jobParameters['nome']}") String nome) {
        return new ImprimeOlaTasklet(nome);
    }
}
