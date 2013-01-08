package pl.helenium.showcase.groovy.extension.random

import java.util.concurrent.ThreadLocalRandom

class RandomGroovyMethods {

    static Integer random(Integer self) {
        ThreadLocalRandom.current().nextInt(self)
    }

    static Integer randomTo(Integer self, Integer upperBound) {
        ThreadLocalRandom.current().nextInt(self, upperBound)
    }

    static <T> T random(Collection<T> self) {
        self[self.size().random()]
    }

    private RandomGroovyMethods() {
        // intentionally left blank
    }

}
