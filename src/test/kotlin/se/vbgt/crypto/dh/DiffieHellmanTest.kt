package se.vbgt.crypto.dh

import org.junit.jupiter.api.Test
import se.vbgt.crypto.DiffieHellman
import java.math.BigInteger
import kotlin.test.assertEquals

internal class DiffieHellmanTest {

    /**
     * https://en.wikipedia.org/wiki/Diffie%E2%80%93Hellman_key_exchange
     */
    @Test
    fun wikipediaCryptograhicExplanation() {
        val modulus = 23.toBigInteger()
        val base = 5.toBigInteger()

        val alice = DiffieHellman(modulus, base)
        val bob = DiffieHellman(modulus, base)

        alice.setPrivateKey(4.toBigInteger())
        bob.setPrivateKey(3.toBigInteger())

        val alicePublicKey = alice.getPublicKey()
        val bobPublicKey = bob.getPublicKey()

        assertEquals(4.toBigInteger(), alicePublicKey)
        assertEquals(10.toBigInteger(), bobPublicKey)

        alice.setPartnersPublicKey(bobPublicKey)
        bob.setPartnersPublicKey(alicePublicKey)

        assertEquals(18.toBigInteger(), alice.getSecret())
        assertEquals(18.toBigInteger(), bob.getSecret())
    }

    /**
     * https://en.wikipedia.org/wiki/Diffie%E2%80%93Hellman_key_exchange
     */
    @Test
    fun wikipediaSecrecyChart() {
        val modulus = 23.toBigInteger()
        val base = 5.toBigInteger()

        val alice = DiffieHellman(modulus, base)
        val bob = DiffieHellman(modulus, base)

        alice.setPrivateKey(6.toBigInteger())
        bob.setPrivateKey(15.toBigInteger())

        val alicePublicKey = alice.getPublicKey()
        val bobPublicKey = bob.getPublicKey()

        assertEquals(8.toBigInteger(), alicePublicKey)
        assertEquals(19.toBigInteger(), bobPublicKey)

        alice.setPartnersPublicKey(bobPublicKey)
        bob.setPartnersPublicKey(alicePublicKey)

        assertEquals(2.toBigInteger(), alice.getSecret())
        assertEquals(2.toBigInteger(), bob.getSecret())
    }

    /**
     * https://www.geeksforgeeks.org/implementation-diffie-hellman-algorithm/
     */
    @Test
    fun geeksForGeeksExample() {
        val modulus = 23.toBigInteger()
        val base = 9.toBigInteger()

        val alice = DiffieHellman(modulus, base)
        val bob = DiffieHellman(modulus, base)

        alice.setPrivateKey(4.toBigInteger())
        bob.setPrivateKey(3.toBigInteger())

        val alicePublicKey = alice.getPublicKey()
        val bobPublicKey = bob.getPublicKey()

        assertEquals(6.toBigInteger(), alicePublicKey)
        assertEquals(16.toBigInteger(), bobPublicKey)

        alice.setPartnersPublicKey(bobPublicKey)
        bob.setPartnersPublicKey(alicePublicKey)

        assertEquals(9.toBigInteger(), alice.getSecret())
        assertEquals(9.toBigInteger(), bob.getSecret())
    }

    /**
     * https://www.ques10.com/p/7533/explain-diffie-hellman-key-exchange-algorithm-wi-1/
     */
    @Test
    fun ques10Test() {
        val modulus = 353.toBigInteger()
        val base = 3.toBigInteger()

        val alice = DiffieHellman(modulus, base)
        val bob = DiffieHellman(modulus, base)

        alice.setPrivateKey(97.toBigInteger())
        bob.setPrivateKey(233.toBigInteger())

        val alicePublicKey = alice.getPublicKey()
        val bobPublicKey = bob.getPublicKey()

        assertEquals(40.toBigInteger(), alicePublicKey)
        assertEquals(248.toBigInteger(), bobPublicKey)

        alice.setPartnersPublicKey(bobPublicKey)
        bob.setPartnersPublicKey(alicePublicKey)

        assertEquals(160.toBigInteger(), alice.getSecret())
        assertEquals(160.toBigInteger(), bob.getSecret())
    }

    /**
     * https://cryptographyacademy.com/diffie-hellman/
     */
    @Test
    fun cryptographyacademyTest() {
        val modulus = 199.toBigInteger()
        val base = 127.toBigInteger()

        val alice = DiffieHellman(modulus, base)
        val bob = DiffieHellman(modulus, base)

        alice.setPrivateKey(190.toBigInteger())
        bob.setPrivateKey(14.toBigInteger())

        val alicePublicKey = alice.getPublicKey()
        val bobPublicKey = bob.getPublicKey()

        assertEquals(4.toBigInteger(), alicePublicKey)
        assertEquals(51.toBigInteger(), bobPublicKey)

        alice.setPartnersPublicKey(bobPublicKey)
        bob.setPartnersPublicKey(alicePublicKey)

        assertEquals(177.toBigInteger(), alice.getSecret())
        assertEquals(177.toBigInteger(), bob.getSecret())
    }

    /**
     * https://cryptographyacademy.com/diffie-hellman/
     */
    @Test
    fun bigNumberTest() {
        val modulus = BigInteger("da3a8085d372437805de95b88b675122f575df976610c6a844de99f1df82a06848bf7a42f18895c97402e81118e01a00d0855d51922f434c022350861d58ddf60d65bc6941fc6064b147071a4c30426d82fc90d888f94990267c64beef8c304a4b2b26fb93724d6a9472fa16bc50c5b9b8b59afb62cfe9ea3ba042c73a6ade35",16)
        val base = BigInteger("a51883e9ac0539859df3d25c716437008bb4bd8ec4786eb4bc643299daef5e3e5af5863a6ac40a597b83a27583f6a658d408825105b16d31b6ed088fc623f648fd6d95e9cefcb0745763cddf564c87bcf4ba7928e74fd6a3080481f588d535e4c026b58a21e1e5ec412ff241b436043e29173f1dc6cb943c09742de989547288",16)


        val alice = DiffieHellman(modulus, base)
        val bob = DiffieHellman(modulus, base)

        alice.setPrivateKey(BigInteger("42c6ee70beb7465928a1efe692d2281b8f7b53d6",16))
        bob.setPrivateKey(BigInteger("54081a8fef2127a1f22ed90440b1b09c331d0614",16))

        val alicePublicKey = alice.getPublicKey()
        val bobPublicKey = bob.getPublicKey()

        assertEquals(
            BigInteger("5a7890f6d20ee9c7162cd84222cb0c7cb5b4f29244a58fc95327fc41045f476fb3da42fca76a1dd59222a7a7c3872d5af7d8dc254e003eccdb38f291619c51911df2b6ed67d0b459f4bc25819c0078777b9a1a24c72e7c037a3720a1edad5863ef5ac75ce816869c820859558d5721089ddbe331f55bef741396a3bbf85c6c1a",16),
            alicePublicKey)
        assertEquals(
            BigInteger("0b92af0468b841ea5de4ca91d895b5e922245421de57ed7a88d2de41610b208e8e233705f17b2e9eb91914bad2fa87f0a58519a7da2980bc06e7411c925a6050526bd86e621505e6f610b63fdcd9afcfaa96bd087afca44d9197cc35b559f731357a5b979250c0f3a254bb8165f5072156e3fd6f9a6e69bcf4b4578f78b3bde7",16),
            bobPublicKey)

        alice.setPartnersPublicKey(bobPublicKey)
        bob.setPartnersPublicKey(alicePublicKey)

        val secret = BigInteger("8d8f4175e16e15a42eb9099b11528af88741cc206a088971d3064bb291eda608d1600bff829624db258fd15e95d96d3e74c6be3232afe5c855b9c59681ce13b7aea9ff2b16707e4c02f0e82bf6dadf2149ac62630f6c62dea0e505e3279404da5ffd5a088e8474ae0c8726b8189cb3d2f04baffe700be849df9f91567fc2ebb8",16)

        assertEquals(secret, alice.getSecret())
        assertEquals(secret, bob.getSecret())
    }
}

