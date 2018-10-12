package demo

import spock.lang.Specification

class BasketWeightCalculatorSpec extends Specification {

    def "one-item"() {
        given:
        def weightCalculator = new BasketWeightCalculator()

        when: "add only one item"
        weightCalculator.addItem(5)

        then: "expect value of the item"
        weightCalculator.getTotalWeight() == 5
    }

    def "two-items"() {
        given:
        def weightCalculator = new BasketWeightCalculator()

        when: "add two items in the basket"
        weightCalculator.addItem(5)
        weightCalculator.addItem(13)

        then: "expect the sum of both items"
        weightCalculator.getTotalWeight() == 18
    }

    def "order-of-items-does-not-matter"() {
        given:
        def weightCalculator1 = new BasketWeightCalculator()
        def weightCalculator2 = new BasketWeightCalculator()

        when: "add same items but with different order"
        weightCalculator1.addItem(5)
        weightCalculator1.addItem(13)

        weightCalculator2.addItem(13)
        weightCalculator2.addItem(5)

        then: "expect both baskets to weigh the same"
        weightCalculator1.getTotalWeight() == 18
        weightCalculator2.getTotalWeight() == 18
    }

    def "one-item-1"() {
        given:
        def weightCalculator = new BasketWeightCalculator()

        when: "add only one item"
        weightCalculator.addItem(5)

        then: "expect value of the item"
        weightCalculator.getTotalWeight() == 3
    }

    def "totalWeightCalculatorTest"(){
        setup:
        BasketWeightCalculator basketWeightCalculator=new BasketWeightCalculator();

        when:
        basketWeightCalculator.getTotalWeight();

        then:"expect total weight of the basket is never null"
        notThrown(NullPointerException);
    }

    def "weight of the item can never be negative"() {
        setup:
        BasketWeightCalculator basketWeightCalculator = new BasketWeightCalculator()

        when: "add same items but with different negative weight"
        basketWeightCalculator.addItem(-6)

        then: "expect weigh"
        basketWeightCalculator.getTotalWeight() == -6
        noExceptionThrown()

    }
}
