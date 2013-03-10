package not.blog.jfinal.kit;

import org.apache.commons.codec.digest.DigestUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created with IntelliJ IDEA.
 * User: not
 * Date: 13-3-10
 * Time: 下午6:38
 * To change this template use File | Settings | File Templates.
 */
public class SecureUitl {
    public static String toMD5(String md5){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] array = md.digest(md5.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(toMD5("loveyu1314"));
        System.out.println(DigestUtils.md2Hex("admin"));
    }
}
