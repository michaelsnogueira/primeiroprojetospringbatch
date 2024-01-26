package br.com.nogueira.primeiroprojetospringbatch;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class ImprimeOlaTasklet implements Tasklet {

    private final String nome;

    public ImprimeOlaTasklet(String nome) {
        this.nome = nome;
    }

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
            System.out.println(String.format("Olá, %s!", nome));
            return RepeatStatus.FINISHED;

    }
}
