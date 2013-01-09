package pl.helenium.showcase.groovy.extension.random

import java.util.concurrent.ThreadLocalRandom

class RandomGroovyMethods {

    static Integer random(Integer self) {
        ThreadLocalRandom.current().nextInt(self)
    }

    static <T> T random(Collection<T> self) {
        if (!self) {
            return null
        }

        self[self.size().random()]
    }

    static Integer randomTo(Integer self, Integer upperBound) {
        ThreadLocalRandom.current().nextInt(self, upperBound)
    }

    private RandomGroovyMethods() {
        // intentionally left blank
    }

}
