package com.findinpath.step.definition

import com.findinpath.RpnCalculator
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import org.junit.jupiter.api.Assertions

class ShoppingStepDefinitions {
    private val calc = RpnCalculator()

    @Given("the following groceries:")
    fun the_following_groceries(groceries: List<Grocery>) {
        for (grocery in groceries) {
            calc.push(grocery.price)
            calc.push("+")
        }
    }

    @When("I pay {}")
    fun i_pay(amount: Int) {
        calc.push(amount.toDouble())
        calc.push("-")
    }

    @Then("my change should be {}")
    fun my_change_should_be_(change: Int) {
        Assertions.assertEquals(-calc.value()!!.toInt(), change)
    }

    class Grocery {
        var name: String = ""
        var price: Int = 0
    }
}
