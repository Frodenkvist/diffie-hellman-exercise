package se.vbgt.crypto

import java.math.BigInteger

class DiffieHellman(val modulus: BigInteger, val base: BigInteger) {
    private lateinit var privateKey: BigInteger
    private lateinit var secretKey: BigInteger
    private val pKey: BigInteger by lazy { base.modPow(privateKey, modulus) }

    fun setPrivateKey(privateKey: BigInteger) {
        this.privateKey = privateKey
    }

    fun getPublicKey() = pKey

    fun setPartnersPublicKey(partnerPublicKey: BigInteger) {
        secretKey = partnerPublicKey.modPow(privateKey, modulus)
    }

    fun getSecret() = secretKey
}