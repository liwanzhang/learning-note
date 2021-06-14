package zwl.learning.note.encrypt;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.Security;

/**
 * @Description: TODO
 * @Author zhangwanli
 * @Date 2019/11/14 15:29
 * @Version V1.0
 **/
public class Encryptor extends JFrame {

    private JPanel contentPane;
    private JTextField textFieldSelected;
    private JButton btnEncryptFile;
    private JButton btnDecryptFile;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        Security.addProvider(new BouncyCastleProvider());
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Encryptor frame = new Encryptor();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Encryptor() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        btnEncryptFile = new JButton("\u52A0\u5BC6");
        btnEncryptFile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String fileName=textFieldSelected.getText();
                String encryptedFileName=fileName+".SEC";
                MyFileEncryptor.encryptFile(fileName, encryptedFileName);
                JOptionPane.showMessageDialog(null, "加密成功");
            }
        });
        btnEncryptFile.setBounds(14, 213, 113, 27);
        contentPane.add(btnEncryptFile);

        btnDecryptFile = new JButton("\u89E3\u5BC6");
        btnDecryptFile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String decryptedFile=textFieldSelected.getText();
                String fileType=".SEC";
                String decryptedFileName=decryptedFile.substring(0, decryptedFile.length()-fileType.length());
                String encryptedFileName=textFieldSelected.getText();
                MyFileEncryptor.decryptedFile(encryptedFileName, decryptedFileName);
            }
        });
        btnDecryptFile.setBounds(292, 213, 113, 27);
        contentPane.add(btnDecryptFile);

        textFieldSelected = new JTextField();
        textFieldSelected.setBounds(14, 92, 360, 24);
        contentPane.add(textFieldSelected);
        textFieldSelected.setColumns(10);

        JButton buttonSelect = new JButton("......");
        buttonSelect.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser=new JFileChooser("D:");
                if(fileChooser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION){
                    textFieldSelected.setText(fileChooser.getSelectedFile().getPath());
                }
            }
        });
        buttonSelect.setBounds(378, 91, 40, 27);
        contentPane.add(buttonSelect);

        JLabel label = new JLabel("\u9009\u62E9\u6587\u4EF6\uFF1A");
        label.setBounds(14, 74, 97, 18);
        contentPane.add(label);

        JLabel lblAes = new JLabel("AES\u52A0\u5BC6\uFF0C\u5BC6\u94A5\u957F\u5EA6128");
        lblAes.setBounds(132, 29, 153, 18);
        contentPane.add(lblAes);
    }
}

