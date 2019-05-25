package edu.mum.bloodbankbatch.config;

import javax.sql.DataSource;

import edu.mum.bloodbankbatch.domain.Donation;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableBatchProcessing
public class SpringBatchConfig {
	
	@Autowired
	DataSource dataSource;


    @Bean
    public Job job(JobBuilderFactory jobBuilderFactory,
                   StepBuilderFactory stepBuilderFactory,
                   ItemReader<Donation> itemReader,
                   ItemProcessor<Donation, Donation> itemProcessor,
                   ItemWriter<Donation> itemWriter
    ) {

        Step step = stepBuilderFactory.get("ETL-db-load")
                .<Donation, Donation>chunk(100)
				.reader(itemReader)
//                .reader(reader())
                .processor(itemProcessor)
                .writer(itemWriter)
                .build();


        return jobBuilderFactory.get("ETL-Load")
                .incrementer(new RunIdIncrementer())
                .start(step)
                .build();
    }

}
