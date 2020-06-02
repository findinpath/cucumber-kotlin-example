package com.findinpath

import io.cucumber.junit.Cucumber
import io.cucumber.junit.CucumberOptions
import org.junit.runner.RunWith

@RunWith(Cucumber::class)
@CucumberOptions(
    tags = ["not @ignored"],
    strict = false,
    plugin = ["html:target/cucumber-html-report", "json:target/cucumber-json-report.json", "pretty", "junit:target/cucumber-junit-report.log"]
)
class RunCucumberTest
