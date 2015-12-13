//package dev.idrv.coach.utils;
//
//
//import org.bouncycastle.asn1.ASN1Sequence;
//import org.bouncycastle.asn1.pkcs.RSAPrivateKeyStructure;
//
//import java.security.KeyFactory;
//import java.security.NoSuchAlgorithmException;
//import java.security.PrivateKey;
//import java.security.interfaces.RSAPrivateKey;
//import java.security.interfaces.RSAPublicKey;
//import java.security.spec.InvalidKeySpecException;
//import java.security.spec.RSAPrivateKeySpec;
//import java.security.spec.X509EncodedKeySpec;
//
//import javax.crypto.Cipher;
//
///**
// * Created by Bigflower on 2015/11/28.
// *
// * in android , we always use #8 for RSA, but here we use #1, which is for android to server .
// */
//public class RSAUtil {
//
//    // these two keys all are base64ed
//    private static String publicKeyStr = "here is your public key";
//    private static String privateKeyStr = "this is your private key";
//
//    //加载字符串类型的私钥
//    public static RSAPrivateKey loadPrivateKey(String privateKeyStr) throws Exception {
//        try {
//            byte[] priKeyData = Base64Utils.decode(privateKeyStr);
//            RSAPrivateKeyStructure asn1PrivKey = new RSAPrivateKeyStructure((ASN1Sequence) ASN1Sequence.fromByteArray(priKeyData));
//            RSAPrivateKeySpec rsaPrivKeySpec = new RSAPrivateKeySpec(asn1PrivKey.getModulus(), asn1PrivKey.getPrivateExponent());
//            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
//            PrivateKey priKey = keyFactory.generatePrivate(rsaPrivKeySpec);
//
//            System.out.println("加载私钥成功");
//            return (RSAPrivateKey) priKey;
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new Exception("私钥数据为空");
//        }
//    }
//
//    /**
//     * 从字符串中加载公钥
//     *
//     * @throws Exception 加载公钥时产生的异常
//     */
//    public static RSAPublicKey loadPublicKey() throws Exception {
//        try {
//            byte[] buffer = Base64Utils.decode(publicKeyStr);
//            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
//            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(buffer);
//            return (RSAPublicKey) keyFactory.generatePublic(keySpec);
//        } catch (NoSuchAlgorithmException e) {
//            throw new Exception("无此算法");
//        } catch (InvalidKeySpecException e) {
//            throw new Exception("公钥非法");
//        } catch (NullPointerException e) {
//            throw new Exception("公钥数据为空");
//        }
//    }
//
//    /**
//     * 用公钥加密 <br>
//     * 每次加密的字节数，不能超过密钥的长度值减去11
//     *
//     * @param input 需加密数据的数据
//     * @return 加密后的并进行64编码
//     */
//    public static String encryptData(String input) {
//        try {
//            byte[] data = input.getBytes();
//            RSAPublicKey publicKey = RSAUtil.loadPublicKey();
//
//            Cipher cipher = Cipher.getInstance("RSA/None/PKCS1Padding");
////            Cipher cipher = Cipher.getInstance("RSA/None/NoPadding", new org.bouncycastle.jce.provider.BouncyCastleProvider());
//            // 编码前设定编码方式及密钥
//            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
//            // 得到加密后的byte数据
//            byte[] byteData = cipher.doFinal(data);
//            // 64编码后返回
//            return Base64Utils.encode(byteData);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    /**
//     * 解密
//     *
//     * @param data
//     * @return
//     */
//    public static String decryptData(String data) {
//        //加载私钥
//        try {
//            RSAPrivateKey privateKey = loadPrivateKey(privateKeyStr);
////            Cipher cipher = Cipher.getInstance("RSA/None/PKCS1Padding", new org.bouncycastle.jce.provider.BouncyCastleProvider());
//            Cipher cipher = Cipher.getInstance("RSA/None/PKCS1Padding");
//            cipher.init(Cipher.DECRYPT_MODE, privateKey);
//
//            byte[] bcd = Base64Utils.decode(data);
//            byte[] output = cipher.doFinal(bcd);
//            System.out.println("plain : " + new String(output));
//
//            return new String(output);
//
//        } catch (Exception e) {
//            System.err.println(e.getMessage());
//            System.err.println("解密失败");
//            return null;
//        }
//    }
//
//
//}
