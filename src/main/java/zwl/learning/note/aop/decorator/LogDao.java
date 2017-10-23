package zwl.learning.note.aop.decorator;

import zwl.learning.note.aop.primitive.Dao;

/**
 * @author zhangwanli
 * @description
 * @date 2017-10-23 上午11:23
 */
public class LogDao implements Dao {

    private Dao dao;

    public LogDao(Dao dao) {
        this.dao = dao;
    }

    @Override
    public void insert() {
        System.out.println("insert()方法开始时间：" + System.currentTimeMillis());
        dao.insert();
        System.out.println("insert()方法结束时间：" + System.currentTimeMillis());
    }

    @Override
    public void delete() {
        dao.delete();
    }

    @Override
    public void update() {
        System.out.println("update()方法开始时间：" + System.currentTimeMillis());
        dao.update();
        System.out.println("update()方法结束时间：" + System.currentTimeMillis());
    }

}
