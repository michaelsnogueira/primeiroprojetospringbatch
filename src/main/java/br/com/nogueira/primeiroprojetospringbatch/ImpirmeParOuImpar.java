package br.com.nogueira.primeiroprojetospringbatch;

import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.function.FunctionItemProcessor;
import org.springframework.batch.item.support.IteratorItemReader;

import java.util.List;

public class ImpirmeParOuImpar {


    public static ItemWriter<String> imprimeWriter() {
        return itens -> itens.forEach(System.out::println);
    }
    public static FunctionItemProcessor<Integer, String> parOuImparProcessor() {
        return new FunctionItemProcessor<Integer, String>(item -> item % 2 == 0
                ?
                String.format("Item %s é Par", item)
                :
                String.format("Item %s é Impar", item));
    }
    public static IteratorItemReader<Integer> contaAteDezReader() {
        List<Integer> numerosDeUmAteDez = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        return new IteratorItemReader<Integer>(numerosDeUmAteDez.iterator());
    }

}
