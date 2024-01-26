package br.com.nogueira.primeiroprojetospringbatch.config;

import br.com.nogueira.primeiroprojetospringbatch.ImpirmeParOuImpar;
import br.com.nogueira.primeiroprojetospringbatch.ImprimeOlaTasklet;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class StepSpringBatchConfig {
    private final JobRepository jobRepository;
    private final PlatformTransactionManager transactionManager;

    public StepSpringBatchConfig(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        this.jobRepository = jobRepository;
        this.transactionManager = transactionManager;
    }

    @Bean
    public Step imprimeParOuImpar() {
        return new StepBuilder("imprimeParOuImpaStep", this.jobRepository)
                .<Integer, String>chunk(1, transactionManager)
                .reader(ImpirmeParOuImpar.contaAteDezReader())
                .processor(ImpirmeParOuImpar.parOuImparProcessor())
                .writer(ImpirmeParOuImpar.imprimeWriter())
                .build();
    }

    @Bean
    public Step imprimeOlaStep() {

        return new StepBuilder("imprimeOlaStep", this.jobRepository)
                .tasklet(new ImprimeOlaTasklet(null), this.transactionManager)
                .build();
    }
}
