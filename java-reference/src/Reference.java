import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * @author mcrwayfun
 * @version v1.0
 * @date Created in 2018/11/24
 * @description java4种引用
 */
public class Reference {

    public static void main(String[] args) {

        // 强引用
        Object powerfulObj = new Object();

        // 软引用
        Object softObj = new Object();
        SoftReference<Object> sf = new SoftReference<>(softObj);
        softObj = null;
        System.out.println("softReferecnce:" + sf.get());//有时候会返回null
        System.out.println("softReferecnce isEnqueued:" + sf.isEnqueued());

        // 弱引用
        Object weakObj = new Object();
        WeakReference<Object> wf = new WeakReference<>(weakObj);
        weakObj = null;
        System.out.println("weakReference:" + wf.get());//有时候会返回null
        System.out.println("weakReference isEnqueued:" + wf.isEnqueued());//返回是否被垃圾回收器标记为即将回收的垃圾

        // 幻想引用-虚引用
        Object phantomObj = new Object();
        PhantomReference<Object> pf = new PhantomReference<>(phantomObj, new ReferenceQueue<>());
        phantomObj = null;
        System.out.println("phantomReference:" + pf.get());//永远返回null
        System.out.println("phantomReference isEnqueued:" + pf.isEnqueued());//返回是否从内存中已经删除

    }
}
