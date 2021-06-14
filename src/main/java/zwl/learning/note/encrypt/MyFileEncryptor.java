package zwl.learning.note.encrypt;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.*;
import java.util.Random;

/**
 * @Description:
 * @Author zhangwanli
 * @Date 2019/11/14 15:23
 * @Version V1.0
 **/
public class MyFileEncryptor {

    private static byte[] keyValue;

    static {

    }

    @SuppressWarnings("static-access")
    //文件加密的实现方法
    public static void encryptFile(String fileName, String encryptedFileName) {
        try {
            FileInputStream fis = new FileInputStream(fileName);
            FileOutputStream fos = new FileOutputStream(encryptedFileName);

            //秘钥自动生成
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(128);
            Key key = keyGenerator.generateKey();


//            byte[] keyValue = key.getEncoded();
            keyValue = key.getEncoded();

//            fos.write(keyValue);//记录输入的加密密码的消息摘要

            SecretKeySpec encryKey = new SecretKeySpec(keyValue, "AES");//加密秘钥

            byte[] ivValue = new byte[16];
            Random random = new Random(System.currentTimeMillis());
            random.nextBytes(ivValue);
            IvParameterSpec iv = new IvParameterSpec(ivValue);//获取系统时间作为IV

            fos.write("MyFileEncryptor".getBytes());//文件标识符

            fos.write(ivValue);    //记录IV
            Cipher cipher = Cipher.getInstance("AES/CFB/PKCS5Padding");
            cipher.init(cipher.ENCRYPT_MODE, encryKey, iv);

            CipherInputStream cis = new CipherInputStream(fis, cipher);

            byte[] buffer = new byte[1024];
            int n = 0;
            while ((n = cis.read(buffer)) != -1) {
                fos.write(buffer, 0, n);
            }
            cis.close();
            fos.close();
        } catch (InvalidKeyException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvalidAlgorithmParameterException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @SuppressWarnings("static-access")
    //文件解密的实现代码
    public static void decryptedFile(String encryptedFileName, String decryptedFileName) {

        try {
            FileInputStream fis = new FileInputStream(encryptedFileName);
            FileOutputStream fos = new FileOutputStream(decryptedFileName);

            byte[] fileIdentifier = new byte[15];

//            byte[] keyValue = new byte[16];
//            fis.read(keyValue);//读记录的文件加密密码的消息摘要
            fis.read(fileIdentifier);
            if (new String(fileIdentifier).equals("MyFileEncryptor")) {
                SecretKeySpec key = new SecretKeySpec(keyValue, "AES");
                byte[] ivValue = new byte[16];
                fis.read(ivValue);//获取IV值
                IvParameterSpec iv = new IvParameterSpec(ivValue);
                Cipher cipher = Cipher.getInstance("AES/CFB/PKCS5Padding");
                cipher.init(cipher.DECRYPT_MODE, key, iv);
                CipherInputStream cis = new CipherInputStream(fis, cipher);
                byte[] buffer = new byte[1024];
                int n = 0;
                while ((n = cis.read(buffer)) != -1) {
                    fos.write(buffer, 0, n);
                }
                cis.close();
                fos.close();
                JOptionPane.showMessageDialog(null, "解密成功");
            } else {
                JOptionPane.showMessageDialog(null, "文件不是我加密的，爱找谁着谁去");
            }
        } catch (InvalidKeyException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (HeadlessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvalidAlgorithmParameterException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Security.addProvider(new BouncyCastleProvider());
    }
}

