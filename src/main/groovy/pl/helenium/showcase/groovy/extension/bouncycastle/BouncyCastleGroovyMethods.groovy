package pl.helenium.showcase.groovy.extension.bouncycastle

import org.bouncycastle.bcpg.sig.KeyFlags
import org.bouncycastle.openpgp.PGPPublicKey
import org.bouncycastle.openpgp.PGPPublicKeyRing

import static org.bouncycastle.bcpg.SignatureSubpacketTags.KEY_FLAGS

class BouncyCastleGroovyMethods {

    static PGPPublicKey getPublicKeyByUsage(PGPPublicKeyRing keyRing, int keyUsage) {
        keyRing.publicKeys.toList().find { PGPPublicKey key ->
            key.getSignaturesOfType(KEY_FLAGS).toList().any { KeyFlags flags ->
                flags & keyUsage
            }
        }
    }

    private BouncyCastleGroovyMethods() {
        // intentionally left blank
    }

}
