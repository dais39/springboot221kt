package com.dais39.springboot221kt

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.context.properties.ConstructorBinding
import org.springframework.boot.runApplication
import org.springframework.stereotype.Component

/*
    Spring Boot 2.2.1では、@ConfigurationPropertiesの自動スキャンが無効になったので、
    @ConfigurationPropertiesScanをJavaConfigに付与する必要がある

 */
@SpringBootApplication
//@EnableConfigurationProperties(SampleConfig::class)
@ConfigurationPropertiesScan
class Springboot221KtApplication

fun main(args: Array<String>) {
    runApplication<Springboot221KtApplication>(*args)
}

@ConstructorBinding
@ConfigurationProperties(prefix = "sample")
class SampleConfig(
    val foo: String,
    val bar: String
)

@ConfigurationProperties(prefix = "sample")
class SampleConfig2 {
    lateinit var foo: String
    lateinit var bar: String
}

@Component
class SampleLauncher(private val config: SampleConfig, private val config2: SampleConfig2) : CommandLineRunner {

    override fun run(vararg args: String?) {

        println(config.foo)
        println(config.bar)
        println(config2.foo)
        println(config2.bar)
    }
}
