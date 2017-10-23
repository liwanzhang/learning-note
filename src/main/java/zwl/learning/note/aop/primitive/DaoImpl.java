package zwl.learning.note.aop.primitive;

/**
 * @author zhangwanli
 * @description
 * @date 2017-10-23 上午11:19
 */
public class DaoImpl implements Dao {

    @Override
    public void insert() {
        System.out.println("DaoImpl.insert()");
    }

    @Override
    public void delete() {
        System.out.println("DaoImpl.delete()");
    }

    @Override
    public void update() {
        System.out.println("DaoImpl.update()");
    }

}
