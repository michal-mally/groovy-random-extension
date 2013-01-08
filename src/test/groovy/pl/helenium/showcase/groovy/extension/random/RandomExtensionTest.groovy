package pl.helenium.showcase.groovy.extension.random

import org.testng.annotations.DataProvider
import org.testng.annotations.Test

class RandomExtensionTest {

    @Test(invocationCount = 200)
    void shallReturnRandomNumberFromRangeZeroToGivenNumberExclusively() {
        // given
        def upperBound = 100

        // when
        def random = upperBound.random()

        // then
        assert random in 0..<upperBound
    }

    @Test(invocationCount = 200)
    void shallReturnRandomNumberFromRangeLowerBoundToGivenNumberExclusively() {
        // given
        def lowerBound = 10
        def upperBound = 100

        // when
        def random = lowerBound.randomTo upperBound

        // then
        assert random in lowerBound..<upperBound
    }

    @DataProvider
    Object[][] collections() {
        [
                [['a', 'b', 'c']],
                [10..15],
                [[10]],
        ]
    }


    @Test(dataProvider = 'collections')
    void shallReturnRandomElementFromCollection(col) {
        // given
        def elementsLeft = new HashSet(col)

        while (elementsLeft) {
            // when
            def randomElement = col.random()

            // then
            assert randomElement in col
            elementsLeft -= randomElement
        }
    }

}
