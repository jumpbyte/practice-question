package com.github.jumpbyte.practice.gof.decoratormode.io;

import java.io.IOException;
import java.io.OutputStream;

/**
 * 自定义加密文件输出流
 * 功能：把英文字母向后移动两个位置，比如：a变成c，b变成d，以此类推，最后的y变成a，z就变成b
 * @className: EncryptOutputStream
 * @author: yuanjinan
 * @create: 2018/12/27
 **/
public class EncryptOutputStream extends OutputStream {


    /**
     * 持有被装饰的对象
     */
    private OutputStream os;

    public EncryptOutputStream(OutputStream os) {
        this.os = os;
    }

    /**
     * Writes the specified byte to this output stream. The general
     * contract for <code>write</code> is that one byte is written
     * to the output stream. The byte to be written is the eight
     * low-order bits of the argument <code>b</code>. The 24
     * high-order bits of <code>b</code> are ignored.
     * <p>
     * Subclasses of <code>OutputStream</code> must provide an
     * implementation for this method.
     *
     * @param a the <code>byte</code>.
     * @throws IOException if an I/O error occurs. In particular,
     *                     an <code>IOException</code> may be thrown if the
     *                     output stream has been closed.
     */
    @Override
    public void write(int a) throws IOException {

        //先统一向后移动两位
         a = a + 2;
        //97是小写的a的码值
        if (a >= (97 + 26)) {
            //如果大于，表示已经是y或者z了，减去26就回到a或者b了
            a = a - 26;
        }
        this.os.write(a);

    }
}
