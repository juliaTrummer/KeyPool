package com.mobappdev.keypool.savepwgeneration

import org.bouncycastle.crypto.generators.PKCS5S2ParametersGenerator
import org.bouncycastle.jce.provider.BouncyCastleProvider
import java.security.Key
import java.security.SecureRandom
import java.security.Security
import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec


class SafePasswordGeneration {

    fun init(){

    }

    fun close(key : String){
        encrypt(key)
    }

    //https://github.com/rodbate/bouncycastle-examples/blob/master/src/main/java/chapter2/KeyGeneratorExample.java
    private fun encrypt(key : String){
        val ivBytes = byteArrayOf(0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08, 0x99.toByte())
        val bcp : BouncyCastleProvider = BouncyCastleProvider()
        Security.addProvider(bcp)
        val cipher : Cipher = Cipher.getInstance("DES", "BC")
        val keyGen : KeyGenerator = KeyGenerator.getInstance("DES", "BC")
        keyGen.init(64)
        var encryptionKey : Key = keyGen.generateKey()
        println("Test: " + encryptionKey.encoded)
        println("Input: " + key)

        cipher.init(Cipher.ENCRYPT_MODE, encryptionKey, IvParameterSpec(ivBytes))
        var ciphertext : ByteArray = ByteArray(cipher.getOutputSize(key.length))
        var ctLength : Int = cipher.update(generateByteArray(key), 0, key.length, ByteArray(0))
        ctLength += cipher.doFinal(ciphertext, ctLength)
        println("Cipher: " + ctLength)

        var decryptionKey : Key = SecretKeySpec(encryptionKey.encoded, encryptionKey.algorithm)
        cipher.init(Cipher.DECRYPT_MODE, decryptionKey, IvParameterSpec(ivBytes))
        var plainText : ByteArray = ByteArray(cipher.getOutputSize(ctLength))
        var ptLength : Int = cipher.update(ciphertext,0,ctLength,plainText,0)
        ptLength += cipher.doFinal(plainText, ptLength)
        println("Cipher decrypted: " + plainText + " " + ptLength)
    }

    fun generateSalt(): ByteArray {
        val salt = ByteArray(16)
        var random : SecureRandom = SecureRandom()
        random.nextBytes(salt)
        return salt
    }


    private fun generateByteArray(key:String) : ByteArray{
        val charset = Charsets.UTF_8
        val byteArray = key.toByteArray(charset)
        return byteArray
    }
}
