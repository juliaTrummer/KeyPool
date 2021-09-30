package com.mobappdev.keypool.savepwgeneration

import org.bouncycastle.crypto.generators.PKCS5S2ParametersGenerator
import org.bouncycastle.crypto.prng.RandomGenerator
import java.security.SecureRandom
import java.util.*


class SafePasswordGeneration {

    private lateinit var generator : PKCS5S2ParametersGenerator

    fun init(){

    }

    fun generateSHA256(pw : String){
        generator = PKCS5S2ParametersGenerator()
        generator.init(passwordGen(pw), salt(), 128)
    }

    private fun salt(): ByteArray? {
        val random : SecureRandom = SecureRandom()
        val salt = ByteArray(6)
        random.nextBytes(salt)
        return salt
    }

    private fun passwordGen(pw : String) : ByteArray?{
        val charset = Charsets.UTF_8
        val byteArray = pw.toByteArray(charset)
        return byteArray
    }

}
