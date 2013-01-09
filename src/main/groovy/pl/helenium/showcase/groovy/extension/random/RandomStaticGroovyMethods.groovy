package pl.helenium.showcase.groovy.extension.random

import java.util.concurrent.ThreadLocalRandom

class RandomStaticGroovyMethods {

    static Boolean random(Boolean self) {
        ThreadLocalRandom.current().nextBoolean()
    }

}
