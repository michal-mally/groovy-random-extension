package pl.helenium.showcase.groovy.extension.random

import org.testng.annotations.DataProvider
import org.testng.annotations.Test

class RandomExtensionTest {

    @DataProvider
    Object[][] collections() {
        [
                [['a', 'b', 'c']],
                [10..15],
                [[10]],
        ]
    }


    @Test(dataProvider = 'collections', timeOut = 1000L)
    void shallReturnAllRandomElementsWhenGettingRandomOnCollection(Collection col) {
        shallEventuallyReturnAllValues(col) {
            col.random()
        }
    }

    @Test(timeOut = 1000L)
    void shallReturnAllBooleanValuesWhenGettingRandomOnBooleanClass() {
        shallEventuallyReturnAllValues([true, false]) {
            Boolean.random()
        }
    }

    @Test(timeOut = 1000L)
    void shallReturnAllValuesFromRangeWhenGettingRandomOnIntegerWithUpperBound() {
        def lower = 10
        def upper = 100
        shallEventuallyReturnAllValues(lower..<upper) {
            lower.randomTo upper
        }
    }

    @Test
    void shallReturnNullOnEmptyCollection() {
        assert ! [].random()
    }

    void shallEventuallyReturnAllValues(Collection allElements, Closure select) {
        // given
        def elementsLeft = new HashSet(allElements)

        while (elementsLeft) {
            // when
            def selectedElement = select()

            // then
            assert selectedElement in allElements
            elementsLeft -= selectedElement
        }
    }

}
