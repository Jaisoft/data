package com.jaisoft.datajdbc.config;

import com.jaisoft.datajdbc.model.User;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jdbc.core.convert.JdbcCustomConversions;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.data.relational.core.mapping.event.BeforeConvertEvent;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.lang.Nullable;

import javax.sql.DataSource;
import java.sql.Clob;
import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.Arrays.asList;

@Configuration
@EnableJdbcRepositories
public class DataJdbcConfig extends AbstractJdbcConfiguration {

    final AtomicInteger id = new AtomicInteger(0);

    @Bean
    public ApplicationListener<?> idSetting() {

        return (ApplicationListener<BeforeConvertEvent>) event -> {

            if (event.getEntity() instanceof User) {
                setIds((User) event.getEntity());
            }
        };
    }

    private void setIds(User user) {

        if (user.getUserId() == 0) {
            user.setUserId(id.incrementAndGet());
        }

       /* var manual = legoSet.getManual();

        if (manual != null) {
            manual.setId((long) legoSet.getId());
        }*/
    }

    @Override
    public JdbcCustomConversions jdbcCustomConversions() {

        return new JdbcCustomConversions(asList(new Converter<Clob, String>() {

            @Nullable
            @Override
            public String convert(Clob clob) {

                try {

                    return Math.toIntExact(clob.length()) == 0 //
                            ? "" //
                            : clob.getSubString(1, Math.toIntExact(clob.length()));

                } catch (SQLException e) {
                    throw new IllegalStateException("Failed to convert CLOB to String.", e);
                }
            }
        }));
    }

    @Bean
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(JdbcOperations operations) {
        return new NamedParameterJdbcTemplate(operations);
    }



    @Bean
    DataSourceInitializer initializer(DataSource dataSource) {

        var initializer = new DataSourceInitializer();
        initializer.setDataSource(dataSource);

        var script = new ClassPathResource("ddl.sql");
        var populator = new ResourceDatabasePopulator(script);
        initializer.setDatabasePopulator(populator);

        return initializer;
    }

}
