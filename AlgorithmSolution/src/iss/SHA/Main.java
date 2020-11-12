package iss.SHA;

import org.apache.commons.codec.binary.Base64;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

public class Main {
    public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        SHAAlgorithm shaAlgorithm = new SHAAlgorithm();

        // Gi13I9x4jj4yTJ5Dh1p8,mhsrM39uiGcbPPyyz930,sLrGGze569971g35dtZi
        for(int i=0;i<100000;i++){  // 10만번 수행
            String r = shaAlgorithm.randomStringGenerator();    // 랜덤 문자열 생성
            byte[] s = shaAlgorithm.sha256ToByte(r);       // SHA256 해시화
            if(s[0]==0 && s[1]==0){     // 2바이트 값이 모두 0 이라면, 즉 16비트가 0일 경우
                System.out.println(r);  // 본래 문자열 출력
                System.out.println(byteArrayToHexString(s));    // 해시값의 hex값 출력
            }
        }
    }

    // hex to Byte[]
    public static byte[] hexStringToByteArray(String hex) {
        if (hex == null || hex.length() == 0) { return null; }
        byte[] ba = new byte[hex.length() / 2];
        for (int i = 0; i < ba.length; i++) {
            ba[i] = (byte) Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
        }
        return ba;
    }

    // byte[] to hex
    public static String byteArrayToHexString(byte[] bytes){
        StringBuilder sb = new StringBuilder();
        for(byte b : bytes){
            sb.append(String.format("%02X", b&0xff));
        }
        return sb.toString();
    }
}
