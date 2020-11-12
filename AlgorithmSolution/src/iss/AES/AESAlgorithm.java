package iss.AES;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;
import java.io.*;

public class AESAlgorithm {
    byte[] enc_iv = "A".repeat(16).getBytes(); // IV값

    // AES 암호화
    public String encode(String str, String enc_key) throws Exception {
        // key 길이가 32가 아닐경우 에러.
        if(enc_key.length() != 32){
            System.out.println("Key Length Error");
            return null;
        }
        // AES
        byte[] data = enc_key.getBytes();
        SecretKey secretKey = new SecretKeySpec(data, "AES"); // 키생성
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, new IvParameterSpec(enc_iv));
        byte[] encrypted = cipher.doFinal(str.getBytes("UTF-8"));

        // base64로 인코딩
        String enc_data = new String(Base64.encodeBase64(encrypted));
        return enc_data;
    }

    // AES 복호화
    public String decode(String str,String enc_key) throws Exception {
        // key 길이 확인
        if(enc_key.length() != 32){
            System.out.println("Key Length Error");
            return null;
        }
        byte[] data = enc_key.getBytes();

        // AES
        SecretKey secretKey = new SecretKeySpec(data, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, secretKey, new IvParameterSpec(enc_iv));

        // base64 인코딩 및 리턴
        byte[] decrypted = Base64.decodeBase64(str.getBytes());
        return new String(cipher.doFinal(decrypted), "UTF-8");
    }

    // 파일 읽기
    public String fileRead(String path) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(path);
        byte[] readBuffer = new byte[fileInputStream.available()];
        while(fileInputStream.read(readBuffer) != -1){ }
        String r = new String(readBuffer);
        fileInputStream.close();
        return r;
    }

    // 파일 쓰기
    public boolean fileWrite(String path,String text) throws IOException {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(path));
        try {
            bufferedOutputStream.write(text.getBytes());
        }catch (Exception e){
            e.getStackTrace();
        }finally {
            bufferedOutputStream.close();
            return true;
        }
    }
}
